package com.test.senior.modules.pedido.repository.impl;

import com.test.senior.modules.pedido.entity.PedidoItem;
import com.test.senior.modules.pedido.entity.QPedidoItem;
import com.test.senior.modules.pedido.repository.PedidoItemRepositoryCustom;
import java.util.Objects;
import java.util.UUID;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class PedidoItemRepositoryCustomImpl extends QuerydslRepositorySupport
    implements PedidoItemRepositoryCustom {

  public PedidoItemRepositoryCustomImpl() {
    super(PedidoItem.class);
  }

  @Override
  public boolean findIfProdutoExistsInPedido(UUID idProduto) {
    var qpedidoItem = QPedidoItem.pedidoItem;
    var query = from(qpedidoItem).where(qpedidoItem.produto.id.eq(idProduto));
    return Objects.nonNull(query.fetchOne());
  }
}
