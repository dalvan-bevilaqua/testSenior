package com.test.senior.modules.produto.mapper;

import com.test.senior.modules.produto.dto.CreateProdutoDto;
import com.test.senior.modules.produto.dto.ProdutoDto;
import com.test.senior.modules.produto.entity.Produto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ProdutoMapper {

  @Mapping(target = "tipo", source = "produtoTipo.nmTipo")
  @Mapping(target = "idTipo", source = "produtoTipo.id")
  ProdutoDto toProdutoDto(Produto produto);

  @Mapping(target = "produtoTipo.id", source = "cdTipo")
  Produto toProduto(CreateProdutoDto dto);
}
