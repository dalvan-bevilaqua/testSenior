package com.test.senior.modules.pedido.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDto implements Serializable {
  private static final long serialVersionUID = -8409560421919702935L;

  private UUID id;
  private UUID idSituacao;
  private String situacao;
  private String descricao;
  private Date dtCadastro;
  private BigDecimal perDesc;
}
