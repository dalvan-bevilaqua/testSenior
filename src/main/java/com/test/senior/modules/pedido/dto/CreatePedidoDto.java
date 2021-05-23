package com.test.senior.modules.pedido.dto;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreatePedidoDto implements Serializable {
  private static final long serialVersionUID = -1283769300896947182L;

  @NotNull(message = "{descricao.not_null}")
  private String descricao;
}
