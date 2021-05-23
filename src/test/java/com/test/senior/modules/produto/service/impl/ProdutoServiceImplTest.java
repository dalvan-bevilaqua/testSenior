package com.test.senior.modules.produto.service.impl;

import com.test.senior.modules.produto.entity.Produto;
import com.test.senior.modules.produto.entity.ProdutoTipo;
import com.test.senior.modules.produto.repository.ProdutoRepository;
import com.test.senior.modules.produto.repository.ProdutoTipoRepository;
import java.util.Date;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class ProdutoServiceImplTest {

  @Autowired ProdutoServiceImpl produtoService;

  @Autowired ProdutoRepository produtoRepository;

  @Autowired ProdutoTipoRepository produtoTipoRepository;

  @Test
  @Rollback
  @DisplayName("Should find by id")
  void ShouldFindById() {
    var tipo = produtoTipoRepository.save(ProdutoTipo.builder().tipo("PRODUTO").build());
    var produto =
        produtoRepository.save(
            Produto.builder()
                .descricao("Inserção teste")
                .dtCadastro(new Date())
                .produtoTipo(tipo)
                .nome("teste")
                .build());

    var response = produtoService.findById(produto.getId());

    Assertions.assertThat(response.getId()).isEqualTo(produto.getId());
  }

  @Test
  @Rollback
  void findAll() {}

  @Test
  @Rollback
  void deleteById() {}

  @Test
  @DisplayName("Should't  delete by id")
  void shouldntDeleteById() {

  }

  @Test
  @Rollback
  void create() {}

  @Test
  @Rollback
  void update() {}
}
