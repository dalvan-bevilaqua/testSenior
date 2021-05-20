CREATE TABLE produto (
  id uuid DEFAULT uuid_generate_v1(),
  id_tipo uuid NOT NULL,
  nome VARCHAR(25) NOT NULL,
  descricao VARCHAR(100) NOT NULL,
  valor DECIMAL(8,2) NOT NULL,
  dt_cadastro DATE NOT NULL
);

ALTER TABLE produto ADD CONSTRAINT PKPRODUTO PRIMARY KEY (id);

ALTER TABLE produto add CONSTRAINT FK1PRODUTO FOREIGN KEY (id_tipo) REFERENCES produto_tipo(id);