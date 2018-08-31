CREATE DATABASE prova01;

CREATE TABLE clientez (
	idCliente INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	nomeCliente VARCHAR(60),
	sexoCliente CHAR
);

CREATE TABLE contatosClientes (
	idContato INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	idCliente INT, #FOREIGN KEY REFERENCES clientez(idCliente),
	emailCliente VARCHAR(35),
	telefoneCliente INT,
	celularCliente INT
);

CREATE TABLE enderecosClientes (
	idEndereco INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	idCliente INT,
	estadoCliente VARCHAR(2),
	cidadeCliente VARCHAR(40),
	bairroCliente VARCHAR(30),
	ruaCliente VARCHAR(40),
	numeroCliente INT,
	cepCliente INT,
	complementoCliente VARCHAR(100)
);

CREATE TABLE marca (
	idMarca INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	nomeMarca VARCHAR(40)
);

CREATE TABLE produtos (
	idProduto INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	nomeProduto VARCHAR(50),
	valorProduto DECIMAL(10,2),
	idMarca INT
);

CREATE TABLE estoqueProdutos (
	idEstoque INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	idProduto INT,
	quantidadeEstoque INT 
);

CREATE TABLE vendas (
	idVenda INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	idProduto INT,
	idCliente INT, 
	dataVenda DATE
);

RENAME TABLE clientez TO clientes;
RENAME TABLE marca TO marcas;
ALTER TABLE contatosClientes ADD CONSTRAINT "fk_cliente" REFERENCES clientes(idCliente);
ALTER TABLE enderecosClientes ADD CONSTRAINT "fk_cliente" REFERENCES clientes(idCliente);
ALTER TABLE produtos ADD CONSTRAINT "fk_marca" REFERENCES marcas(idMarca);
ALTER TABLE estoqueProdutos ADD CONSTRAINT "fk_produto" REFERENCES produtos(idProduto);
ALTER TABLE vendas ADD CONSTRAINT "fk_produto" REFERENCES produtos(idProduto);
ALTER TABLE vendas ADD CONSTRAINT "fk_cliente" REFERENCES clientes(idCliente);
ALTER TABLE vendas ADD COLLUMN dataPedido DATE;

INSERT INTO clientes(nomeCliente, sexoCliente) VALUES
	("Ana Parker", "f"),
	("Gean Kloth ", "m"),
	("Isabela Fontana ", "f"),
	("Ingrid Mello ", "f"),
	("Rubens Almeida ", "m");

INSERT INTO contatoClientes(idCliente, emailCliente, telefoneCliente, celularCliente) VALUES
	(1, "ana.parker@live.com ", null, 98757476),
	(2, "geankbnu@gmail.com  ", null, 96365512 ),
	(3, "Isabela1999@bol.com.br  ", null, null ),
	(4, "Ingrid.fontana@gmail.com  ", null, 88559497 ),
	(5, "Rubens.a@gmail.com  ", null, 89226688 );

INSERT INTO enderecoClientes (idCliente, estadoCliente, cidadeCliente, numeroCliente, bairroCliente, ruaCliente, cepCliente, complementoCliente) VALUES 
	(1, "sc", "Blumenau ", 98757476, "Escola Agrícola", "Regente Feijó ", 89035600 , null),
	(1, "sc", "Brusque  ", 96365512 , "Centro ", "Rua XV ", 88556321  , null),
	(1, "sc", "Blumenau ", null , "Centro ", "Beira Rio  ", null , null),
	(1, "pr ", "Curitiba  ", 88559497 , "Batel ", "Tupinambá  ", 84579633  , null),
	(1, "sc", "Blumenau ", 89226688 , "Vila Nova ", "Instaninslau Schaete ", null , null);

INSERT INTO marcas(nomeMarca) VALUES
	("Nestle "),
	("P&G"),
	("Unilever "),
	("PepsiCo "),
	("Danone ");

INSERT INTO produtos(nomeProduto, valorProduto, idMarca) VALUES
	("Pepsi Lata – 350ml ", 2.09, 4),
	("Biscoito Passatempo  ", 2.07, 1),
	("Sabão em pó Ariel 5 kg ", 11.7, 2),
	("Desodorante Old Spice ", 10.9, 2),
	("Pasta de dente Oral-B ", 5.96, 2),
	("Biscoito Mabel 370gr  ", 7.49, 4),
	("Biscouto Toddynho com gotas de chocolate  ", 2.07, 4);

INSERT INTO estoqueProdutos(idProduto, quantidadeEstoque) VALUES
	(1, 7000),
	(2, 8000),
	(3, 6530),
	(4, 1800),
	(5, 950),
	(6, 700),
	(7, 1780);

INSERT INTO vendas(idProduto, idCliente, dataVenda) VALUES
	(2,1,"2018-06-09"),
	(5,1,"2018-06-12"),
	(2,1,"2018-06-17"),
	(1,1,"2018-06-04"),
	(3,1,"2018-06-07"),
	(2,1,"2018-06-14"),
	(4,1,"2018-06-11"),
	(3,1,"2018-06-19"),
	(3,1,"2018-06-13"),
	(2,1,"2018-06-18");

SELECT idProduto, nomeProduto, marcas.nomeMarca FROM produtos INNER JOIN marcas ON produtos.idMarca = marcas.idMarca ORDER BY idProduto;
SELECT clientes.nomeCliente, COUNT(vendas.idCliente), SUM(produtos.valorProduto) FROM vendas INNER JOIN clientes ON clientes.idCliente = vendas.idCliente INNER JOIN produtos ON produtos.idProduto = vendas.idProduto GROUP BY vendas.idCliente
SELECT produtos.nomeProduto, produtos.valorProduto, vendas.dataVenda FROM produtos INNER JOIN vendas ON vendas.idProduto = produtos.idProduto WHERE vendas.dataVenda BETWEEN "2018-06-03" AND "2019-06-09";
SELECT produtos.nomeProduto, estoqueProdutos.quantidadeEstoque FROM estoqueProdutos INNER JOIN produtos ON produtos.idProduto = estoqueProdutos.idProduto WHERE estoqueProdutos.quantidadeEstoque < 1000;
SELECT clientes.nomeCliente, contatosClientes.celularCliente FROM contatosClientes INNER JOIN clientes ON clientes.idCliente = contatosClientes.idCliente WHERE contatosClientes.celularCliente <> NULL;
SELECT COUNT(*) AS "MASC", (SELECT COUNT(*) FROM clientes) - COUNT(*) AS "FEM" FROM clientes;
SELECT COUNT(vendas.idProduto) FROM vendas GROUP BY vendas.dataVenda;
SELECT clientes.nomeCliente, IF(clientes.sexoCliente = "m", "MASC", "FEM"), COUNT(vendas.idCliente) FROM clientes INNER JOIN vendas ON vendas.idCliente = clientes.idCliente GROUP BY vendas.idCliente;
SELECT COUNT(produtos.idProduto) FROM vendas INNER JOIN produtos ON vendas.idProduto = produtos.idProduto WHERE produtos.valorProduto <= 10;
SELECT clientes.nomeCliente, SUM(produtos.valorProduto) FROM vendas INNER JOIN clientes ON clientes.idCliente = produtos.idCliente GROUP BY vendas.idCliente DESC LIMIT 1;
SELECT clientes.nomeCliente, produtos.nomeProduto, MAX(produtos.valorProduto), vendas.dataVenda FROM vendas INNER JOIN clientes ON clientes.idCliente = vendas.idCliente INNER JOIN produtos ON produtos.idProduto = vendas.idProduto GROUP BY clientes.sexoCliente;
SELECT MIN(produtos.valorProduto), marcas.nomeMarca, produtos.nomeProduto FROM produtos INNER JOIN marcas ON produtos.idProduto = marcas.idProduto
DROP DATABASE prova01;