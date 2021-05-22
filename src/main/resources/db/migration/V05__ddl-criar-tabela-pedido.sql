CREATE TABLE pedido (
  id uuid DEFAULT uuid_generate_v1(),
  id_situacao uuid NOT NULL,
  descricao VARCHAR(50) NOT NULL,
  dt_cadastro DATE NOT NULL,
  per_desc DECIMAL(8,2) DEFAULT 0
);

ALTER TABLE pedido ADD CONSTRAINT PKPEDIDO PRIMARY KEY (id);
ALTER TABLE pedido add CONSTRAINT FK1PEDIDO FOREIGN KEY (id_situacao) REFERENCES pedido_situacao(id);
