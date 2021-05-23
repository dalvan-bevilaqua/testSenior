package com.test.senior.modules.pedido.repository;

import com.test.senior.modules.pedido.dto.PedidoFilter;
import com.test.senior.modules.pedido.entity.Pedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PedidoRepositoryCustom {

  Page<Pedido> findAll(PedidoFilter filter, Pageable pageable);
}
