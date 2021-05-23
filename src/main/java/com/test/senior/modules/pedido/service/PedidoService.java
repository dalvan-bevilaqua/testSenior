package com.test.senior.modules.pedido.service;

import com.test.senior.modules.pedido.dto.CreatePedidoDto;
import com.test.senior.modules.pedido.dto.PedidoDto;
import com.test.senior.modules.pedido.dto.PedidoFilter;
import java.math.BigDecimal;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PedidoService {
  PedidoDto findById(UUID idPedido);

  PedidoDto create(CreatePedidoDto dto);

  void finalizarPedido(UUID idPedido);

  Page<PedidoDto> findAll(PedidoFilter filter, Pageable pageable);

  void deleteById(UUID idPedido);

  void applyDesc(UUID idPedido, BigDecimal vlDesc);
}
