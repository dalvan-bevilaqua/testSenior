package com.test.senior.modules.produto.repository.impl;

import com.test.senior.modules.produto.dto.ProdutoFilter;
import com.test.senior.modules.produto.entity.Produto;
import com.test.senior.modules.produto.entity.QProduto;
import com.test.senior.modules.produto.repository.ProdutoRepositoryCustom;
import java.util.Objects;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.data.support.PageableExecutionUtils;

public class ProdutoRepositoryCustomImpl extends QuerydslRepositorySupport
    implements ProdutoRepositoryCustom {

  public ProdutoRepositoryCustomImpl() {
    super(Produto.class);
  }

  @Override
  public Page<Produto> findAll(ProdutoFilter filter, Pageable pageable) {

    var qproduto = QProduto.produto;
    var query = from(qproduto);

    Optional.ofNullable(filter.getId()).ifPresent(id -> query.where(qproduto.id.eq(id)));

    Optional.ofNullable(filter.getDescricao())
        .ifPresent(descricao -> query.where(qproduto.descricao.eq(descricao)));

    Optional.ofNullable(filter.getNome()).ifPresent(nome -> query.where(qproduto.nome.eq(nome)));

    Optional.ofNullable(filter.getTipo())
        .ifPresent(tipo -> query.where(qproduto.produtoTipo.nmTipo.eq(tipo)));

    if (Objects.nonNull(filter.getDtCadastroInicial())
        && Objects.nonNull(filter.getDtCadastroFinal())) {
      query.where(
          qproduto
              .dtCadastro
              .goe(filter.getDtCadastroInicial())
              .and(qproduto.dtCadastro.loe(filter.getDtCadastroFinal())));
    }

    var queryResults = super.getQuerydsl().applyPagination(pageable, query).fetchResults();
    return PageableExecutionUtils.getPage(
        queryResults.getResults(), pageable, queryResults::getTotal);
  }
}
