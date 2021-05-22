package com.test.senior.modules.pedido.service;

import com.test.senior.modules.pedido.dto.CreatePedidoDto;
import com.test.senior.modules.pedido.dto.PedidoDto;
import com.test.senior.modules.pedido.dto.PedidoFilter;
import com.test.senior.modules.produto.dto.ProdutoDto;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PedidoService {
  ProdutoDto findByid(UUID idPedido);

  UUID create(CreatePedidoDto dto);

  void update(UUID idProduto, CreatePedidoDto dto);

  Page<PedidoDto> findAll(PedidoFilter filter, Pageable pageable);

  void deleteById(UUID idPedido);
}
