package com.test.senior.modules.produto.controller;

import com.test.senior.modules.produto.dto.ProdutoDto;
import com.test.senior.modules.produto.entity.Produto;
import com.test.senior.modules.produto.service.ProdutoService;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/produto")
public class ProdutoController {

  private final ProdutoService produtoService;

  @GetMapping("/{cdProduto}")
  public ProdutoDto findById(@PathVariable UUID cdProduto) {
    return produtoService.findByid(cdProduto);
  }
}
