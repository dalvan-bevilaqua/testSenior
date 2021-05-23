package com.test.senior.modules.pedido.mapper;

import com.test.senior.modules.pedido.dto.PedidoItemDto;
import com.test.senior.modules.pedido.entity.PedidoItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface PedidoItemMapper {

  @Mapping(target = "idProduto", source = "produto.id")
  @Mapping(target = "idPedido", source = "pedido.id")
  PedidoItemDto toPedidoItemDto(PedidoItem pedidoItem);

  @Mapping(target = "produto.id", source = "idProduto")
  @Mapping(target = "pedido.id", source = "idPedido")
  PedidoItem toPedidoItem(PedidoItemDto pedidoItemDto);
}
