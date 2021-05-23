package com.test.senior.modules.pedido.repository;

import com.test.senior.modules.pedido.entity.Pedido;
import com.test.senior.modules.pedido.entity.PedidoItem;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface PedidoItemRepository
    extends JpaRepository<PedidoItem, UUID>,
        QuerydslPredicateExecutor<Pedido>,
        PedidoItemRepositoryCustom {}
