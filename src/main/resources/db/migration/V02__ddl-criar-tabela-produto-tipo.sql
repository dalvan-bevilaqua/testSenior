CREATE TABLE produto_tipo (
  id uuid DEFAULT uuid_generate_v1(),
  nm_tipo VARCHAR(50) NOT NULL
);

ALTER TABLE produto_tipo ADD CONSTRAINT PKPRODUTOTIPO PRIMARY KEY (id);

INSERT INTO produto_tipo (nm_tipo) values ('PRODUTO');
INSERT INTO produto_tipo (nm_tipo) values ('SERVICO');

