package com.test.senior.modules.pedido.mapper;

import com.test.senior.modules.pedido.dto.PedidoDto;
import com.test.senior.modules.pedido.dto.PedidoItemDto;
import com.test.senior.modules.pedido.entity.Pedido;
import java.util.Objects;
import java.util.stream.Collectors;
import org.mapstruct.Mapper;

@Mapper
public interface PedidoMapper {

  default PedidoDto toPedidoDto(Pedido pedido) {
    return PedidoDto.builder()
        .id(pedido.getId())
        .idSituacao(pedido.getPedidoSituacao().getId())
        .situacao(pedido.getPedidoSituacao().getSituacao())
        .perDesc(pedido.getPerDesc())
        .vlPedido(pedido.getVlPedido())
        .dtCadastro(pedido.getDtCadastro())
        .descricao(pedido.getDescricao())
        .pedidoItemDtoList(
            Objects.isNull(pedido.getPedidoItens())
                ? null
                : pedido.getPedidoItens().stream()
                    .map(
                        item ->
                            PedidoItemDto.builder()
                                .id(item.getId())
                                .idPedido(item.getPedido().getId())
                                .qtProduto(item.getQtProduto())
                                .vlProduto(item.getVlProduto())
                                .idProduto(item.getProduto().getId())
                                .nome(item.getProduto().getNome())
                                .build())
                    .collect(Collectors.toList()))
        .build();
  }
}
