package com.test.senior.modules.pedido.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;
import javax.validation.constraints.NotNull;
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

  @NotNull(message = "{idPedido.not_null}")
  private UUID idPedido;

  @NotNull(message = "{idProduto.not_null}")
  private UUID idProduto;

  @NotNull(message = "{qtProduto.not_null}")
  private BigDecimal qtProduto;

  @NotNull(message = "{vlProduto.not_null}")
  private BigDecimal vlProduto;

  private String nome;
}
