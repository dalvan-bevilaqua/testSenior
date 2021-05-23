package com.test.senior.modules.pedido.service;

import com.test.senior.modules.pedido.dto.PedidoItemDto;
import com.test.senior.modules.pedido.entity.PedidoItem;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import javax.validation.Valid;

public interface PedidoItemService {

  List<PedidoItemDto> createItens(@Valid List<PedidoItemDto> pedidoItemList);

  UUID createItem(@Valid PedidoItemDto dto);

  boolean existsItemInPedido(UUID idProduto);

  void aplicarDesconto(List<PedidoItem> pedidoItens, BigDecimal perDesc);

  void deleteById(UUID idItem);
}
