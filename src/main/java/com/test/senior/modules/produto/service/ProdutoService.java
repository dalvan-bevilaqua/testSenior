package com.test.senior.modules.produto.service;

import com.test.senior.modules.produto.dto.ProdutoDto;
import java.util.UUID;

public interface ProdutoService {

  ProdutoDto findByid(UUID idProduto);
}
