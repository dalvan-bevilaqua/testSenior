package com.test.senior.modules.pedido.service.impl;

import com.test.senior.modules.pedido.dto.CreatePedidoDto;
import com.test.senior.modules.pedido.dto.PedidoDto;
import com.test.senior.modules.pedido.dto.PedidoFilter;
import com.test.senior.modules.pedido.entity.Pedido;
import com.test.senior.modules.pedido.entity.PedidoSituacao;
import com.test.senior.modules.pedido.enums.SituacaoPedido;
import com.test.senior.modules.pedido.repository.PedidoRepository;
import com.test.senior.modules.pedido.repository.PedidoSituacaoRepository;
import com.test.senior.modules.pedido.service.PedidoItemService;
import com.test.senior.modules.pedido.service.PedidoService;
import com.test.senior.modules.produto.dto.ProdutoDto;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;
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
  private final PedidoItemService pedidoItemService;

  @Override
  public ProdutoDto findByid(UUID idPedido) {
    return null;
  }

  @Override
  public UUID create(CreatePedidoDto dto) {
    var idSituacao = pedidoSituacaoRepository.findBySituacao(SituacaoPedido.ABERTO.name()).getId();
    var pedido =
        Pedido.builder()
            .descricao(dto.getDescricao())
            .pedidoSituacao(PedidoSituacao.builder().id(idSituacao).build())
            .dtCadastro(new Date())
            .perDesc(BigDecimal.ZERO)
            .build();
    var pedidoSalvo = pedidoRepository.save(pedido);

    if (CollectionUtils.isEmpty(dto.getPedidoItemList())) {
      return pedido.getId();
    }

    dto.getPedidoItemList()
        .forEach(pedidoItemDto -> pedidoItemDto.setIdPedido(pedidoSalvo.getId()));

    pedidoItemService.createItens(dto.getPedidoItemList());

    return pedido.getId();
  }

  @Override
  public void update(UUID idProduto, CreatePedidoDto dto) {}

  @Override
  public Page<PedidoDto> findAll(PedidoFilter filter, Pageable pageable) {
    return null;
  }

  @Override
  public void deleteById(UUID idPedido) {}
}
