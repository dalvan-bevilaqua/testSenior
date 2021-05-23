package com.test.senior.modules.produto.repository;

import com.test.senior.modules.produto.dto.ProdutoFilter;
import com.test.senior.modules.produto.entity.Produto;
import java.util.List;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProdutoRepositoryCustom {

  Page<Produto> findAll(ProdutoFilter filter, Pageable pageable);

  boolean findByIdInAndStatusIsDisabled(List<UUID> listIds);
}
