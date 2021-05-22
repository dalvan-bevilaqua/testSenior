package com.test.senior.modules.pedido.service.impl;

import com.test.senior.modules.pedido.dto.PedidoItemDto;
import com.test.senior.modules.pedido.entity.Pedido;
import com.test.senior.modules.pedido.entity.PedidoItem;
import com.test.senior.modules.pedido.repository.PedidoItemRepository;
import com.test.senior.modules.pedido.service.PedidoItemService;
import com.test.senior.modules.produto.entity.Produto;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PedidoItemServiceImpl implements PedidoItemService {

  private final PedidoItemRepository pedidoItemRepository;

  @Override
  public void createItens(List<PedidoItemDto> pedidoItemList) {
    var pedidoItem =
        pedidoItemList.stream()
            .map(
                pedidoItemDto ->
                    PedidoItem.builder()
                        .pedido(Pedido.builder().id(pedidoItemDto.getIdPedido()).build())
                        .produto(Produto.builder().id(pedidoItemDto.getIdProduto()).build())
                        .qtProduto(pedidoItemDto.getQtProduto())
                        .vlProduto(pedidoItemDto.getVlProduto())
                        .build())
            .collect(Collectors.toList());

    pedidoItemRepository.saveAll(pedidoItem);
  }
}
