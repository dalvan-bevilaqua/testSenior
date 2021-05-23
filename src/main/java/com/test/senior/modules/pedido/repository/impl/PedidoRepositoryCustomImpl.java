package com.test.senior.modules.pedido.repository.impl;

import com.test.senior.modules.pedido.dto.PedidoFilter;
import com.test.senior.modules.pedido.entity.Pedido;
import com.test.senior.modules.pedido.entity.QPedido;
import com.test.senior.modules.pedido.repository.PedidoRepositoryCustom;
import java.util.Objects;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.data.support.PageableExecutionUtils;

public class PedidoRepositoryCustomImpl extends QuerydslRepositorySupport
    implements PedidoRepositoryCustom {

  public PedidoRepositoryCustomImpl() {
    super(Pedido.class);
  }

  @Override
  public Page<Pedido> findAll(PedidoFilter filter, Pageable pageable) {
    var qpedido = QPedido.pedido;
    var query = from(qpedido);

    Optional.ofNullable(filter.getId()).ifPresent(id -> query.where(qpedido.id.eq(id)));

    Optional.ofNullable(filter.getDescricao())
        .ifPresent(descricao -> query.where(qpedido.descricao.eq(descricao)));

    Optional.ofNullable(filter.getIdSituacao())
        .ifPresent(idSituacao -> query.where(qpedido.pedidoSituacao.id.eq(idSituacao)));

    Optional.ofNullable(filter.getSituacao())
        .ifPresent(situacao -> query.where(qpedido.pedidoSituacao.situacao.eq(situacao)));

    if (Objects.nonNull(filter.getDtCadastroInicial())
        && Objects.nonNull(filter.getDtCadastroFinal())) {
      query.where(
          qpedido
              .dtCadastro
              .goe(filter.getDtCadastroInicial())
              .and(qpedido.dtCadastro.loe(filter.getDtCadastroFinal())));
    }

    var queryResults = super.getQuerydsl().applyPagination(pageable, query).fetchResults();
    return PageableExecutionUtils.getPage(
        queryResults.getResults(), pageable, queryResults::getTotal);
  }
}
