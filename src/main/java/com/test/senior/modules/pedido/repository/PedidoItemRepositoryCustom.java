package com.test.senior.modules.pedido.repository;

import java.util.UUID;

public interface PedidoItemRepositoryCustom {

  boolean findIfProdutoExistsInPedido(UUID idProduto);
}
