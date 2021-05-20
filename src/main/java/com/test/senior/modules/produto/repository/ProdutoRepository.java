package com.test.senior.modules.produto.repository;

import com.test.senior.modules.produto.entity.Produto;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, UUID> {}
