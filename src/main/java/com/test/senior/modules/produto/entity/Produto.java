package com.test.senior.modules.produto.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Produto {

  @Id private UUID id;

  @ManyToOne
  @JoinColumn(name = "id_tipo")
  private ProdutoTipo produtoTipo;

  private String nome;
  private String descricao;
  private BigDecimal valor;
  private Date dtCadastro;
}
