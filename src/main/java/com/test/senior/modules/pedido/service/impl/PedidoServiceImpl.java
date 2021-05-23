package com.test.senior.modules.pedido.service.impl;

import com.test.senior.exception.RecordNotFoundException;
import com.test.senior.handler.BusinessException;
import com.test.senior.helper.i18n.Translator;
import com.test.senior.modules.pedido.dto.CreatePedidoDto;
import com.test.senior.modules.pedido.dto.PedidoDto;
import com.test.senior.modules.pedido.dto.PedidoFilter;
import com.test.senior.modules.pedido.entity.Pedido;
import com.test.senior.modules.pedido.entity.PedidoItem;
import com.test.senior.modules.pedido.enums.SituacaoPedido;
import com.test.senior.modules.pedido.enums.TipoProduto;
import com.test.senior.modules.pedido.mapper.PedidoMapper;
import com.test.senior.modules.pedido.repository.PedidoRepository;
import com.test.senior.modules.pedido.repository.PedidoSituacaoRepository;
import com.test.senior.modules.pedido.service.PedidoItemService;
import com.test.senior.modules.pedido.service.PedidoService;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {

  private final PedidoRepository pedidoRepository;
  private final PedidoSituacaoRepository pedidoSituacaoRepository;
  private final PedidoMapper pedidoMapper;
  private final Translator translator;
  private final PedidoItemService pedidoItemService;

  @Override
  public PedidoDto findById(UUID idPedido) {
    var pedido = pedidoRepository.findById(idPedido).orElseThrow(RecordNotFoundException::new);
    this.fillValTotalPedido(pedido);
    return pedidoMapper.toPedidoDto(pedido);
  }

  @Override
  public PedidoDto create(CreatePedidoDto dto) {
    var situacao = pedidoSituacaoRepository.findBySituacao(SituacaoPedido.ABERTO.name());
    var pedido =
        Pedido.builder()
            .descricao(dto.getDescricao())
            .pedidoSituacao(situacao)
            .dtCadastro(new Date())
            .perDesc(BigDecimal.ZERO)
            .vlPedido(BigDecimal.ZERO)
            .build();
    return pedidoMapper.toPedidoDto(pedidoRepository.save(pedido));
  }

  public void fillValTotalPedido(Pedido pedido) {
    var valTotalPedido =
        pedido.getPedidoItens().stream()
            .map(PedidoItem::getVlTotal)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
    pedido.setVlPedido(valTotalPedido);
  }

  @Override
  public void finalizarPedido(UUID idPedido) {
    var pedido = pedidoRepository.findById(idPedido).orElseThrow(RecordNotFoundException::new);
    var situacao = pedidoSituacaoRepository.findBySituacao(SituacaoPedido.FECHADO.name());
    pedido.setPedidoSituacao(situacao);
    pedidoRepository.save(pedido);
  }

  @Override
  public Page<PedidoDto> findAll(PedidoFilter filter, Pageable pageable) {
    return pedidoRepository.findAll(filter, pageable).map(pedidoMapper::toPedidoDto);
  }

  @Override
  public void deleteById(UUID idPedido) {
    var pedido = pedidoRepository.findById(idPedido).orElseThrow(RecordNotFoundException::new);
    validaSeEhPossivelDeletar(pedido);
    pedidoRepository.deleteById(pedido.getId());
  }

  @Override
  public void applyDesc(UUID idPedido, BigDecimal perDesc) {
    var pedido = pedidoRepository.findById(idPedido).orElseThrow(RecordNotFoundException::new);
    validaSeEhPossivelAplicarDesconto(pedido);
    validaSeExistemItensNoPedido(pedido);
    validaSeExistemItensTipoProdutoNoPedido(pedido);

    pedido.setPerDesc(perDesc);
    pedidoRepository.save(pedido);
    pedidoItemService.aplicarDesconto(pedido.getPedidoItens(), perDesc);
  }

  private void validaSeExistemItensTipoProdutoNoPedido(Pedido pedido) {
    var itens =
        pedido.getPedidoItens().stream()
            .filter(
                pedidoItem ->
                    TipoProduto.PRODUTO
                        .name()
                        .equals(pedidoItem.getProduto().getProdutoTipo().getTipo()))
            .filter(Objects::nonNull)
            .collect(Collectors.toList());
    if (CollectionUtils.isEmpty(itens)) {
      new BusinessException(translator.get("nao.existem.itens.no.pedido.tipo.produto"));
    }
  }

  private void validaSeExistemItensNoPedido(Pedido pedido) {
    if (CollectionUtils.isEmpty(pedido.getPedidoItens())) {
      throw new BusinessException(translator.get("nao.existem.itens.no.pedido"));
    }
  }

  private void validaSeEhPossivelAplicarDesconto(Pedido pedido) {
    if (SituacaoPedido.FECHADO.name().equals(pedido.getPedidoSituacao().getSituacao())) {
      throw new BusinessException(
          translator.get("nao.eh.possivel.applicar.desconto-pedido-finalizado"));
    }
  }

  private void validaSeEhPossivelDeletar(Pedido pedido) {
    if (SituacaoPedido.ABERTO.name().equals(pedido.getPedidoSituacao().getSituacao())) {
      throw new BusinessException(translator.get("nao.eh.possivel.deletar.pedido.finalizado"));
    }
  }
}
