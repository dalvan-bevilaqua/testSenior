package com.test.senior.modules.pedido.repository;

import com.test.senior.modules.pedido.entity.Pedido;
import com.test.senior.modules.produto.dto.ProdutoFilter;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface PedidoRepository
    extends JpaRepository<Pedido, UUID>, QuerydslPredicateExecutor<Pedido>, PedidoRepositoryCustom {
}
