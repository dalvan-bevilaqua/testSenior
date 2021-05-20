CREATE TABLE pedido (
  id uuid DEFAULT uuid_generate_v1(),
  id_situacao_pedido uuid NOT NULL,
  descricao VARCHAR(50) NOT NULL,
  dt_cadastro DATE NOT NULL
);

ALTER TABLE pedido ADD CONSTRAINT PKPEDIDO PRIMARY KEY (id);
ALTER TABLE pedido add CONSTRAINT FK1PEDIDO FOREIGN KEY (id_situacao_pedido) REFERENCES pedido_situacao(id);
