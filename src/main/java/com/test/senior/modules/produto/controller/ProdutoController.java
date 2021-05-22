package com.test.senior.modules.produto.controller;

import com.test.senior.modules.produto.dto.CreateProdutoDto;
import com.test.senior.modules.produto.dto.ProdutoDto;
import com.test.senior.modules.produto.dto.ProdutoFilter;
import com.test.senior.modules.produto.service.ProdutoService;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/produto")
public class ProdutoController {

  private final ProdutoService produtoService;

  @GetMapping("/{idProduto}")
  public ProdutoDto findById(@PathVariable UUID idProduto) {
    return produtoService.findByid(idProduto);
  }

  @PostMapping
  public UUID create(@RequestBody CreateProdutoDto dto) {
    return produtoService.create(dto);
  }

  @PutMapping("/{idProduto}")
  public void update(@PathVariable UUID idProduto, CreateProdutoDto dto) {
    produtoService.update(idProduto, dto);
  }

  @GetMapping
  public Page<ProdutoDto> findAll(ProdutoFilter filter, Pageable pageable) {
    return produtoService.findAll(filter, pageable);
  }

  @DeleteMapping("/{idProduto}/delete")
  @ResponseStatus(HttpStatus.OK)
  public void deleteById(@PathVariable UUID idProduto) {
    produtoService.deleteById(idProduto);
  }
}
