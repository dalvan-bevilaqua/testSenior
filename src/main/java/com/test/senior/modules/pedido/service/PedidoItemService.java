package com.test.senior.modules.pedido.service;

import com.test.senior.modules.pedido.dto.PedidoItemDto;
import com.test.senior.modules.pedido.entity.PedidoItem;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface PedidoItemService {

  List<PedidoItemDto> createItens(List<PedidoItemDto> pedidoItemList);

  UUID createItem(PedidoItemDto dto);

  boolean existsItemInPedido(UUID idProduto);

  void aplicarDesconto(List<PedidoItem> pedidoItens, BigDecimal perDesc);
}
