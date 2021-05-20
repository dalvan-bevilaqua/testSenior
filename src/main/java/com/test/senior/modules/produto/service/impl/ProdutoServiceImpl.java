package com.test.senior.modules.produto.service.impl;

import com.test.senior.exception.RecordNotFoundException;
import com.test.senior.modules.produto.dto.ProdutoDto;
import com.test.senior.modules.produto.mapper.ProdutoMapper;
import com.test.senior.modules.produto.repository.ProdutoRepository;
import com.test.senior.modules.produto.service.ProdutoService;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProdutoServiceImpl implements ProdutoService {
  private final ProdutoRepository produtoRepository;
  private final ProdutoMapper produtoMapper;

  @Override
  public ProdutoDto findByid(UUID idProduto) {
    var produto = produtoRepository.findById(idProduto).orElseThrow(RecordNotFoundException::new);
    return produtoMapper.toProdutoDto(produto);
  }
}
