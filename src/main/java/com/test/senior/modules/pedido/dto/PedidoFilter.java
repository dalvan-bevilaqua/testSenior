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
@NoArgsConstructor
@AllArgsConstructor
public class PedidoFilter implements Serializable {
  private static final long serialVersionUID = -8773803474363838352L;

  private UUID id;
  private UUID idSituacao;
  private String situacao;
  private String descricao;
  private Date dtCadastroInicial;
  private Date dtCadastroFinal;
  private BigDecimal perDesc;
}
