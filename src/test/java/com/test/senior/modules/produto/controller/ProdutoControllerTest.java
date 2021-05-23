package com.test.senior.modules.produto.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.senior.modules.produto.entity.Produto;
import com.test.senior.modules.produto.entity.ProdutoTipo;
import com.test.senior.modules.produto.repository.ProdutoRepository;
import com.test.senior.modules.produto.repository.ProdutoTipoRepository;
import com.test.senior.modules.produto.service.impl.ProdutoServiceImpl;
import java.util.Date;
import javax.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Transactional
class ProdutoControllerTest {
  @Autowired private ObjectMapper objectMapper;

  @Autowired ProdutoServiceImpl produtoService;

  @Autowired ProdutoRepository produtoRepository;

  @Autowired ProdutoTipoRepository produtoTipoRepository;

  @Autowired private MockMvc mockMvc;

  @Test
  @Rollback
  void findById() throws Exception {
    var tipo = produtoTipoRepository.save(ProdutoTipo.builder().tipo("PRODUTO").build());
    var produto =
        produtoRepository.save(
            Produto.builder()
                .descricao("Inserção teste")
                .dtCadastro(new Date())
                .produtoTipo(tipo)
                .nome("teste")
                .build());

    mockMvc
        .perform(get("/v1/produto/" + produto.getId()).contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.nome").value("teste"));
  }

  @Test
  @Rollback
  void create() {

  }

  @Test
  void update() {}

  @Test
  void findAll() {}

  @Test
  void deleteById() {}
}
