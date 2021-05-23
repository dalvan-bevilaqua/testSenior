package com.test.senior.modules.produto.repository;

import com.test.senior.modules.produto.entity.ProdutoTipo;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoTipoRepository extends JpaRepository<ProdutoTipo, UUID> {}
