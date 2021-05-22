package com.test.senior.modules.pedido.repository;

import com.test.senior.modules.pedido.entity.PedidoSituacao;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoSituacaoRepository extends JpaRepository<PedidoSituacao, UUID> {

  PedidoSituacao findBySituacao(String situacao);
}
