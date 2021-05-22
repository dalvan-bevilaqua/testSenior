package com.test.senior.modules.pedido.entity;

import com.test.senior.modules.produto.entity.ProdutoTipo;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
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
@Table(name = "pedido")
public class Pedido implements Serializable {
  private static final long serialVersionUID = -1853454009145388603L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private UUID id;

  @OneToOne
  @JoinColumn(name = "id_situacao")
  private PedidoSituacao pedidoSituacao;

  private String descricao;
  private Date dtCadastro;
  private BigDecimal perDesc;

}
