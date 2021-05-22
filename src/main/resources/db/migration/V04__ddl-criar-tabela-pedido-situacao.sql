CREATE TABLE pedido_situacao (
  id uuid DEFAULT uuid_generate_v1(),
  situacao VARCHAR(50) NOT NULL CHECK (situacao IN ('ABERTO', 'FECHADO'))
);

ALTER TABLE pedido_situacao ADD CONSTRAINT PKPEDIDOSITUACAO PRIMARY KEY (id);

INSERT INTO pedido_situacao (situacao) values ('ABERTO');
INSERT INTO pedido_situacao (situacao) values ('FECHADO');