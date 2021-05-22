CREATE TABLE produto_tipo (
  id uuid DEFAULT uuid_generate_v1(),
  tipo VARCHAR(20) NOT NULL CHECK (tipo IN ('PRODUTO', 'SERVICO'))
);

ALTER TABLE produto_tipo ADD CONSTRAINT PKPRODUTOTIPO PRIMARY KEY (id);

INSERT INTO produto_tipo (tipo) values ('PRODUTO');
INSERT INTO produto_tipo (tipo) values ('SERVICO');

