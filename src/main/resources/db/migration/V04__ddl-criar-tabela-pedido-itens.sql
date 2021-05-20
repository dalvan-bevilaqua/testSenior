CREATE TABLE pedido_item (
  id uuid DEFAULT uuid_generate_v1(),
  id_produto uuid NOT NULL,
  qt_produto decimal(15,5)
);

ALTER TABLE pedido_item ADD CONSTRAINT PKPEDIDOITEM PRIMARY KEY (id);
ALTER TABLE pedido_item add CONSTRAINT FKPEDIDOITEM FOREIGN KEY (id_produto) REFERENCES produto(id);
