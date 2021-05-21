package com.test.senior.modules.produto.repository;

import com.test.senior.modules.produto.dto.ProdutoFilter;
import com.test.senior.modules.produto.entity.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProdutoRepositoryCustom {

  Page<Produto> findAll(ProdutoFilter filter, Pageable pageable);
}
