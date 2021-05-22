CREATE TABLE pedido_item (
  id uuid DEFAULT uuid_generate_v1(),
  id_produto uuid NOT NULL,
  id_pedido uuid NOT NULL,
  qt_produto DECIMAL (15,5) NOT NULL,
  vl_produto DECIMAL(8,2) NOT NULL
);

ALTER TABLE pedido_item ADD CONSTRAINT PK1PEDIDOITEM PRIMARY KEY (id);
ALTER TABLE pedido_item add CONSTRAINT FK2PEDIDOITEM FOREIGN KEY (id_produto) REFERENCES produto(id);
ALTER TABLE pedido_item add CONSTRAINT FK3PEDIDOITEM FOREIGN KEY (id_pedido) REFERENCES pedido(id);