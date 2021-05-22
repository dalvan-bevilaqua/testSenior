package com.test.senior.modules.pedido.service.impl;

import com.test.senior.modules.pedido.dto.CreatePedidoDto;
import com.test.senior.modules.pedido.dto.PedidoDto;
import com.test.senior.modules.pedido.dto.PedidoFilter;
import com.test.senior.modules.pedido.service.PedidoService;
import com.test.senior.modules.produto.dto.ProdutoDto;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImpl implements PedidoService {
  @Override
  public ProdutoDto findByid(UUID idPedido) {
    return null;
  }

  @Override
  public UUID create(CreatePedidoDto dto) {
    return null;
  }

  @Override
  public void update(UUID idProduto, CreatePedidoDto dto) {}

  @Override
  public Page<PedidoDto> findAll(PedidoFilter filter, Pageable pageable) {
    return null;
  }

  @Override
  public void deleteById(UUID idPedido) {}
}
