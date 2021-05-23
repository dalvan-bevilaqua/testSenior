package com.test.senior.modules.pedido.service.impl;

import com.test.senior.exception.RecordNotFoundException;
import com.test.senior.modules.pedido.dto.PedidoItemDto;
import com.test.senior.modules.pedido.entity.Pedido;
import com.test.senior.modules.pedido.entity.PedidoItem;
import com.test.senior.modules.pedido.enums.TipoProduto;
import com.test.senior.modules.pedido.mapper.PedidoItemMapper;
import com.test.senior.modules.pedido.repository.PedidoItemRepository;
import com.test.senior.modules.pedido.repository.PedidoRepository;
import com.test.senior.modules.pedido.service.PedidoItemService;
import com.test.senior.modules.produto.entity.Produto;
import com.test.senior.modules.produto.repository.ProdutoRepository;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PedidoItemServiceImpl implements PedidoItemService {

  private final PedidoItemRepository pedidoItemRepository;
  private final PedidoItemMapper pedidoItemMapper;
  private final ProdutoRepository produtoRepository;
  private final PedidoRepository pedidoRepository;

  @Override
  public List<PedidoItemDto> createItens(List<PedidoItemDto> pedidoItemList) {
    var pedidoItens =
        pedidoItemList.stream()
            .map(
                pedidoItemDto ->
                    PedidoItem.builder()
                        .pedido(Pedido.builder().id(pedidoItemDto.getIdPedido()).build())
                        .produto(Produto.builder().id(pedidoItemDto.getIdProduto()).build())
                        .qtProduto(pedidoItemDto.getQtProduto())
                        .vlProduto(pedidoItemDto.getVlProduto())
                        .vlTotal(
                            pedidoItemDto.getQtProduto().multiply(pedidoItemDto.getVlProduto()))
                        .build())
            .collect(Collectors.toList());

    return pedidoItemRepository.saveAll(pedidoItens).stream()
        .map(pedidoItem -> pedidoItemMapper.toPedidoItemDto(pedidoItem))
        .collect(Collectors.toList());
  }

  @Override
  public UUID createItem(PedidoItemDto dto) {
    var pedidoItem = pedidoItemMapper.toPedidoItem(dto);

    pedidoItem.setPedido(
        pedidoRepository
            .findById(pedidoItem.getPedido().getId())
            .orElseThrow(RecordNotFoundException::new));
    pedidoItem.setProduto(
        produtoRepository
            .findById(pedidoItem.getProduto().getId())
            .orElseThrow(RecordNotFoundException::new));

    return pedidoItemRepository.save(pedidoItem).getId();
  }

  @Override
  public boolean existsItemInPedido(UUID idProduto) {
    return pedidoItemRepository.findIfProdutoExistsInPedido(idProduto);
  }

  @Override
  public void aplicarDesconto(List<PedidoItem> pedidoItens, BigDecimal perDesc) {
    var itensTipoProduto =
        pedidoItens.stream()
            .filter(
                pedidoItem ->
                    TipoProduto.PRODUTO
                        .name()
                        .equals(pedidoItem.getProduto().getProdutoTipo().getTipo()))
            .collect(Collectors.toList());

    this.fillAndCalcDesc(itensTipoProduto, perDesc);

    pedidoItemRepository.saveAll(itensTipoProduto);
  }

  private void fillAndCalcDesc(List<PedidoItem> itensTipoProduto, BigDecimal perDesc) {
    itensTipoProduto.forEach(
        pedidoItem -> {
          var valTotal = pedidoItem.getQtProduto().multiply(pedidoItem.getVlProduto());
          var desconto = valTotal.multiply(perDesc.divide(new BigDecimal(100)));
          pedidoItem.setVlDesconto(desconto);
          pedidoItem.setVlTotal(valTotal.subtract(desconto));
        });
  }
}
