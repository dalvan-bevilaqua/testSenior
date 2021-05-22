CREATE TABLE produto (
  id uuid DEFAULT uuid_generate_v1(),
  id_tipo uuid NOT NULL,
  nome VARCHAR(25) NOT NULL,
  descricao VARCHAR(100),
  valor DECIMAL(8,2) NOT NULL,
  dt_cadastro DATE NOT NULL
);

ALTER TABLE produto ADD CONSTRAINT PKPRODUTO PRIMARY KEY (id);
ALTER TABLE produto add CONSTRAINT FK1PRODUTO FOREIGN KEY (id_tipo) REFERENCES produto_tipo(id);

INSERT INTO produto (id_tipo, nome, descricao, valor, dt_cadastro) values ((select id from  produto_tipo where tipo = 'PRODUTO'), 'laranja', '', 6.99, '2021-05-21');
INSERT INTO produto (id_tipo, nome, descricao, valor, dt_cadastro) values ((select id from  produto_tipo where tipo = 'SERVICO'), 'programação', '', 65.00, '2021-05-21');
INSERT INTO produto (id_tipo, nome, descricao, valor, dt_cadastro) values ((select id from  produto_tipo where tipo = 'PRODUTO'), 'mamão', '', 5.99, '2021-05-21');
INSERT INTO produto (id_tipo, nome, descricao, valor, dt_cadastro) values ((select id from  produto_tipo where tipo = 'SERVICO'), 'pintura', '', 150.00, '2021-05-21');
INSERT INTO produto (id_tipo, nome, descricao, valor, dt_cadastro) values ((select id from  produto_tipo where tipo = 'PRODUTO'), 'pinhão', '', 5.80, '2021-05-21');
INSERT INTO produto (id_tipo, nome, descricao, valor, dt_cadastro) values ((select id from  produto_tipo where tipo = 'PRODUTO'), 'doritos', '', 11.0, '2021-05-21');
INSERT INTO produto (id_tipo, nome, descricao, valor, dt_cadastro) values ((select id from  produto_tipo where tipo = 'PRODUTO'), 'Colca cola', '', 5.0, '2021-05-21');
INSERT INTO produto (id_tipo, nome, descricao, valor, dt_cadastro) values ((select id from  produto_tipo where tipo = 'PRODUTO'), 'Leite L. Vida', '', 3.99, '2021-05-21');
INSERT INTO produto (id_tipo, nome, descricao, valor, dt_cadastro) values ((select id from  produto_tipo where tipo = 'SERVICO'), 'Mão de Obra', '', 80.00, '2021-05-21');
INSERT INTO produto (id_tipo, nome, descricao, valor, dt_cadastro) values ((select id from  produto_tipo where tipo = 'SERVICO'), 'teste', '', 5.0, '2021-05-21');
INSERT INTO produto (id_tipo, nome, descricao, valor, dt_cadastro) values ((select id from  produto_tipo where tipo = 'PRODUTO'), 'teste', '', 5.0, '2021-05-21');