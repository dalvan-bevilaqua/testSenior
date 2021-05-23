package com.test.senior.modules.pedido.entity;

import com.test.senior.modules.produto.entity.Produto;
import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "pedido_item")
public class PedidoItem implements Serializable {
  private static final long serialVersionUID = -6138460696413055594L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private UUID id;

  @OneToOne
  @JoinColumn(name = "id_produto")
  private Produto produto;

  @OneToOne
  @JoinColumn(name = "id_pedido")
  private Pedido pedido;

  private BigDecimal qtProduto;
  private BigDecimal vlProduto;
  private BigDecimal vlDesconto;
  private BigDecimal vlTotal;
}
