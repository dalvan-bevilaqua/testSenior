package com.test.senior.modules.produto.dto;

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
public class CreateProdutoDto implements Serializable {

  private static final long serialVersionUID = -6927803739301059259L;

  @NotNull(message = "{nome.not_null}")
  private String nome;

  @NotNull(message = "{cdTipo.not_null}")
  private UUID cdTipo;

  @NotNull(message = "{descricao.not_null}")
  private String descricao;

  @NotNull(message = "{valor.not_null}")
  private BigDecimal valor;

  private String isAtivo;
}
