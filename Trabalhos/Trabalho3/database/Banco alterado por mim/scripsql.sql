CREATE DATABASE mercado WITH default charset=utf8;

CREATE TABLE `produtos` (
	`idProduto` INT NOT NULL AUTO_INCREMENT,
	`nomeProduto` varchar(100) NOT NULL,
	`valorProduto` DECIMAL(10,2) NOT NULL,
	`quantidadeProduto` INT,
	`idMarca` INT NOT NULL,
	`idSetor` INT NOT NULL,
	PRIMARY KEY (`idProduto`)
);

CREATE TABLE `marcas` (
	`idMarca` INT NOT NULL AUTO_INCREMENT,
	`nomeMarca` varchar(30) NOT NULL,
	PRIMARY KEY (`idMarca`)
);

CREATE TABLE `saidaDosProdutos` (
	`idSaida` INT NOT NULL AUTO_INCREMENT,
	`valorSaida` DECIMAL(10,2) NOT NULL,
	`quantidadeSaida` INT,
	`idProduto` INT,
	PRIMARY KEY (`idSaida`)
);

CREATE TABLE `pessoas` (
	`idPessoa` INT NOT NULL AUTO_INCREMENT,
	`nomePessoa` varchar(30) NOT NULL,
	`mascPessoa` BOOLEAN NOT NULL,
	`nascPessoa` DATE NOT NULL,
	`idCargo` INT,
	PRIMARY KEY (`idPessoa`)
);

CREATE TABLE `promocoes` (
	`idPromocao` INT NOT NULL AUTO_INCREMENT,
	`idProduto` INT NOT NULL,
	`percentualDesconto` DECIMAL(5,2) NOT NULL,
	PRIMARY KEY (`idPromocao`)
);

CREATE TABLE `cargos` (
	`idCargo` INT NOT NULL AUTO_INCREMENT,
	`nomeCargo` varchar(40) NOT NULL,
	`salarioCargo` DECIMAL(10,2) NOT NULL,
	PRIMARY KEY (`idCargo`)
);

CREATE TABLE `setores` (
	`idSetor` INT NOT NULL AUTO_INCREMENT,
	`nomeDoSetor` varchar(30) NOT NULL,
	PRIMARY KEY (`idSetor`)
);

CREATE TABLE `contatos` (
	`idContato` INT NOT NULL AUTO_INCREMENT,
	`conteudoContato` varchar(100) NOT NULL,
	`idPessoa` INT NOT NULL,
	PRIMARY KEY (`idContato`)
);

CREATE TABLE `enderecos` (
	`idEndereco` INT NOT NULL AUTO_INCREMENT,
	`cepEndereco` varchar(50) NOT NULL,
	`ruaEndereco` varchar(100) NOT NULL,
	`complementoEndereco` varchar(150),
	`idPessoa` INT NOT NULL,
	PRIMARY KEY (`idEndereco`)
);

ALTER TABLE `produtos` ADD CONSTRAINT `produtos_fk0` FOREIGN KEY (`idMarca`) REFERENCES `marcas`(`idMarca`);

ALTER TABLE `produtos` ADD CONSTRAINT `produtos_fk1` FOREIGN KEY (`idSetor`) REFERENCES `setores`(`idSetor`);

ALTER TABLE `saidaDosProdutos` ADD CONSTRAINT `saidaDosProdutos_fk0` FOREIGN KEY (`idProduto`) REFERENCES `produtos`(`idProduto`);

ALTER TABLE `pessoas` ADD CONSTRAINT `pessoas_fk0` FOREIGN KEY (`idCargo`) REFERENCES `cargos`(`idCargo`);

ALTER TABLE `promocoes` ADD CONSTRAINT `promocoes_fk0` FOREIGN KEY (`idProduto`) REFERENCES `produtos`(`idProduto`);

ALTER TABLE `contatos` ADD CONSTRAINT `contatos_fk0` FOREIGN KEY (`idPessoa`) REFERENCES `pessoas`(`idPessoa`);

ALTER TABLE `enderecos` ADD CONSTRAINT `enderecos_fk0` FOREIGN KEY (`idPessoa`) REFERENCES `pessoas`(`idPessoa`);
