package com.test.senior.modules.produto.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoFilter implements Serializable {

  private static final long serialVersionUID = -6609906667668176431L;

  private UUID id;
  private String nome;
  private String tipo;
  private String descricao;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private Date dtCadastroInicial;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private Date dtCadastroFinal;
}
