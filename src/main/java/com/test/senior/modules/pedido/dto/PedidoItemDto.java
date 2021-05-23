package com.test.senior.modules.pedido.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PedidoItemDto implements Serializable {
  private static final long serialVersionUID = -2357602730976161986L;

  private UUID id;
  private UUID idPedido;
  private UUID idProduto;
  private String nome;
  private BigDecimal qtProduto;
  private BigDecimal vlProduto;
}
