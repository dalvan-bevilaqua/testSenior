package com.test.senior.modules.produto.service;

import com.test.senior.modules.produto.dto.CreateProdutoDto;
import com.test.senior.modules.produto.dto.ProdutoDto;
import com.test.senior.modules.produto.dto.ProdutoFilter;
import java.util.UUID;
import javax.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProdutoService {

  ProdutoDto findByid(UUID idProduto);

  Page<ProdutoDto> findAll(ProdutoFilter filter, Pageable pageable);

  void deleteById(UUID idProduto);

  UUID create(@Valid CreateProdutoDto dto);

  void update(UUID idProduto, CreateProdutoDto dto);
}
