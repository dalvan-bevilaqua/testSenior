CREATE TABLE pedido_situacao (
  id uuid DEFAULT uuid_generate_v1(),
  nm_situacao VARCHAR(50) NOT NULL
);

ALTER TABLE pedido_situacao ADD CONSTRAINT PKPEDIDOSITUACAO PRIMARY KEY (id);

INSERT INTO pedido_situacao (nm_situacao) values ('ABERTO');
INSERT INTO pedido_situacao (nm_situacao) values ('FECHADO');