package com.test.senior.modules.pedido.service;

import com.test.senior.modules.pedido.dto.PedidoItemDto;
import java.util.List;

public interface PedidoItemService {

  void createItens(List<PedidoItemDto> pedidoItemList);
}
