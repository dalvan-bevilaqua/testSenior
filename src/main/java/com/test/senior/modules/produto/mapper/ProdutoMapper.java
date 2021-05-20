package com.test.senior.modules.produto.mapper;

import com.test.senior.modules.produto.dto.ProdutoDto;
import com.test.senior.modules.produto.entity.Produto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ProdutoMapper {
  @Mapping(target = "tipo", source = "produtoTipo.nmTipo")
  ProdutoDto toProdutoDto(Produto produto);
}
