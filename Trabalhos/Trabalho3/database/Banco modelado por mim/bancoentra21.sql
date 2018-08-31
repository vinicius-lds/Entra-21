
CREATE DATABASE bancoentra21 DEFAULT charset=utf8;

CREATE TABLE `Pessoas` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `idAgencia` INT NOT NULL,
  `nome` varchar(150) NOT NULL,
  `codigo` varchar(14) NOT NULL UNIQUE,
  PRIMARY KEY (`id`)
);

CREATE TABLE `Contatos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `idPessoa` INT NOT NULL,
  `contato` varchar(150) NOT NULL UNIQUE,
  PRIMARY KEY (`id`)
);

CREATE TABLE `Enderecos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `idPessoa` INT NOT NULL,
  `rua` varchar(150) NOT NULL,
  `numero` INT NOT NULL,
  `bairro` varchar(150) NOT NULL,
  `complemento` varchar(500),
  PRIMARY KEY (`id`)
);

CREATE TABLE `Contas` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `idPessoa` INT NOT NULL,
  `contaCorrente` varchar(50) NOT NULL UNIQUE,
  `agencia` varchar(50) NOT NULL,
  `fundos` DECIMAL(50,2) NOT NULL DEFAULT '0',
  `senha` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `Transferencias` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `de` INT NOT NULL,
  `para` varchar(100) NOT NULL,
  `valor` DECIMAL(50,2) NOT NULL,
  `dataHora` DATETIME NOT NULL,
  `idCaixa` INT NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `Saques` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `idConta` INT NOT NULL,
  `valor` DECIMAL(50,2) NOT NULL,
  `dataHora` DATETIME NOT NULL,
  `idCaixa` INT NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `Depositos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `idConta` INT NOT NULL,
  `valor` DECIMAL(50,2) NOT NULL,
  `dataHora` DATETIME NOT NULL,
  `idCaixa` INT NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `Funcionarios` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `idPessoa` INT NOT NULL UNIQUE,
  `salario` DECIMAL(50,2) NOT NULL,
  `nivelDePermissao` INT NOT NULL,
  `senha` varchar(100),
  PRIMARY KEY (`id`)
);

CREATE TABLE `Emprestimos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `idConta` INT NOT NULL,
  `valorInicial` DECIMAL(50,2) NOT NULL,
  `valorProximaParcela` DECIMAL(50,2) NOT NULL,
  `dataProximaParcela` DECIMAL(50,2) NOT NULL,
  `parcelasRestantes` INT NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `caixasEletronicos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fundos` DECIMAL(50,2) NOT NULL,
  `idAgencia` INT NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `Agencias` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `endereco` varchar(500) NOT NULL,
  `telefone` varchar(15) NOT NULL,
  PRIMARY KEY (`id`)
);

ALTER TABLE `Pessoas` ADD CONSTRAINT `Pessoas_fk0` FOREIGN KEY (`idAgencia`) REFERENCES `Agencias`(`id`);

ALTER TABLE `Contatos` ADD CONSTRAINT `Contatos_fk0` FOREIGN KEY (`idPessoa`) REFERENCES `Pessoas`(`id`);

ALTER TABLE `Enderecos` ADD CONSTRAINT `Enderecos_fk0` FOREIGN KEY (`idPessoa`) REFERENCES `Pessoas`(`id`);

ALTER TABLE `Contas` ADD CONSTRAINT `Contas_fk0` FOREIGN KEY (`idPessoa`) REFERENCES `Pessoas`(`id`);

ALTER TABLE `Transferencias` ADD CONSTRAINT `Transferencias_fk0` FOREIGN KEY (`de`) REFERENCES `Contas`(`id`);

ALTER TABLE `Transferencias` ADD CONSTRAINT `Transferencias_fk1` FOREIGN KEY (`idCaixa`) REFERENCES `caixasEletronicos`(`id`);

ALTER TABLE `Saques` ADD CONSTRAINT `Saques_fk0` FOREIGN KEY (`idConta`) REFERENCES `Contas`(`id`);

ALTER TABLE `Saques` ADD CONSTRAINT `Saques_fk1` FOREIGN KEY (`idCaixa`) REFERENCES `caixasEletronicos`(`id`);

ALTER TABLE `Depositos` ADD CONSTRAINT `Depositos_fk0` FOREIGN KEY (`idConta`) REFERENCES `Contas`(`id`);

ALTER TABLE `Depositos` ADD CONSTRAINT `Depositos_fk1` FOREIGN KEY (`idCaixa`) REFERENCES `caixasEletronicos`(`id`);

ALTER TABLE `Funcionarios` ADD CONSTRAINT `Funcionarios_fk0` FOREIGN KEY (`idPessoa`) REFERENCES `Pessoas`(`id`);

ALTER TABLE `Emprestimos` ADD CONSTRAINT `Emprestimos_fk0` FOREIGN KEY (`idConta`) REFERENCES `Contas`(`id`);

ALTER TABLE `caixasEletronicos` ADD CONSTRAINT `caixasEletronicos_fk0` FOREIGN KEY (`idAgencia`) REFERENCES `Agencias`(`id`);


INSERT INTO agencias (nome, endereco) VALUES
  ("agencia1", "endereco1"),
  ("agencia2", "endereco2"),
  ("agencia3", "endereco3"),
  ("agencia4", "endereco4"),
  ("agencia5", "endereco5"),
  ("agencia6", "endereco6"),
  ("agencia7", "endereco7"),
  ("agencia8", "endereco8"),
  ("agencia9", "endereco9"),
  ("agencia10", "endereco10"),
  ("agencia11", "endereco11"),
  ("agencia12", "endereco12"),
  ("agencia13", "endereco13"),
  ("agencia14", "endereco14"),
  ("agencia15", "endereco15"),
  ("agencia16", "endereco16"),
  ("agencia17", "endereco17"),
  ("agencia18", "endereco18"),
  ("agencia19", "endereco19"),
  ("agencia20", "endereco20");

INSERT INTO caixasEletronicos (fundos, idAgencia) VALUES
  (10000, 1),
  (10000, 2),
  (10000, 3),
  (10000, 4),
  (10000, 5),
  (10000, 6),
  (10000, 7),
  (10000, 8),
  (10000, 9),
  (10000, 10),
  (10000, 11),
  (10000, 12),
  (10000, 13),
  (10000, 14),
  (10000, 15),
  (10000, 16),
  (10000, 17),
  (10000, 18),
  (10000, 19),
  (10000, 20);

INSERT INTO pessoas (idAgencia, nome, codigo) VALUES
  (1, "Diego", "999.949.999-99"),
  (2, "Ribas", "888.888.888-88"),
  (3, "Marcos", "777.777.777-77"),
  (4, "Bruno", "666.666.666-66"),
  (5, "Vinicius", "555.555.555-55"),
  (6, "Junior", "444.444.444-44"),
  (7, "Lucas", "333.333.333-33"),
  (8, "Paquetá", "222.222.222-22"),
  (9, "Renato", "111.111.111-11"),
  (10, "Augusto", "000.000.000-00"),
  (11, "Messi", "999.999.991-99"),
  (12, "Gabriel", "999.991.999-99"),
  (13, "Jesus", "999.999.919-99"),
  (14, "Luiz", "999.999.999-99"),
  (15, "Felipe", "999.999.299-99"),
  (16, "Scolari", "999.999.499-99"),
  (17, "Neymar", "999.999.909-99"),
  (18, "Coutinho", "999.999.099-99"),
  (19, "Roberto", "999.999.939-99"),
  (20, "Firmino", "999.999.969-99");

INSERT INTO funcionarios (idPessoa, salario, nivelDePermissao, senha) VALUES
  (1, 1500, 0, null),
  (2, 1500, 1, MD5("123")),
  (3, 1500, 0, null),
  (4, 1500, 2, MD5("123")),
  (5, 1500, 4, MD5("123")),
  (6, 1500, 2, MD5("123")),
  (7, 1500, 1, MD5("123")),
  (8, 1500, 2, MD5("123")),
  (9, 1500, 1, MD5("123")),
  (10, 1500, 1, MD5("123")),
  (11, 1500, 1, MD5("123")),
  (12, 1500, 1, MD5("123")),
  (13, 1500, 3, MD5("123")),
  (14, 1500, 2, MD5("123")),
  (15, 1500, 1, MD5("123")),
  (16, 1500, 2, MD5("123")),
  (17, 1500, 1, MD5("123")),
  (18, 1500, 1, MD5("123")),
  (19, 1500, 1, MD5("123")),
  (20, 1500, 0, null);

INSERT INTO contas (idPessoa, contaCorrente, agencia, senha) VALUES
  (1, "111111", "123", "abc"),
  (2, "222222", "123", "abc"),
  (3, "333333", "123", "abc"),
  (4, "444444", "123", "abc"),
  (5, "555555", "123", "abc"),
  (6, "666666", "123", "abc"),
  (7, "777777", "123", "abc"),
  (8, "888888", "123", "abc"),
  (9, "999999", "123", "abc"),
  (10, "123456", "123", "abc"),
  (11, "234567", "123", "abc"),
  (12, "345678", "123", "abc"),
  (13, "456789", "123", "abc"),
  (14, "567890", "123", "abc"),
  (15, "678901", "123", "abc"),
  (16, "789012", "123", "abc"),
  (17, "890123", "123", "abc"),
  (18, "901234", "123", "abc"),
  (19, "012345", "123", "abc"),
  (20, "102938", "123", "abc");

INSERT INTO enderecos (idPessoa, rua, numero, bairro, complemento) VALUES
  (1, "rua", 123, "bairro", null),
  (2, "rua", 123, "bairro", "complemento"),
  (3, "rua", 123, "bairro", null),
  (4, "rua", 123, "bairro", "complemento"),
  (5, "rua", 123, "bairro", null),
  (6, "rua", 123, "bairro", "complemento"),
  (7, "rua", 123, "bairro", null),
  (8, "rua", 123, "bairro", "complemento"),
  (9, "rua", 123, "bairro", null),
  (10, "rua", 123, "bairro", "complemento"),
  (11, "rua", 123, "bairro", null),
  (12, "rua", 123, "bairro", "complemento"),
  (13, "rua", 123, "bairro", null),
  (14, "rua", 123, "bairro", "complemento"),
  (15, "rua", 123, "bairro", null),
  (16, "rua", 123, "bairro", "complemento"),
  (17, "rua", 123, "bairro", null),
  (18, "rua", 123, "bairro", "complemento"),
  (19, "rua", 123, "bairro", null),
  (20, "rua", 123, "bairro", "complemento");

INSERT INTO contatos (idPessoa, contato) VALUES
  (1, "contato1"),
  (2, "contato2"),
  (3, "contato3"),
  (4, "contato4"),
  (5, "contato5"),
  (6, "contato6"),
  (7, "contato7"),
  (8, "contato8"),
  (9, "contato9"),
  (10, "contato10"),
  (11, "contato11"),
  (12, "contato12"),
  (13, "contato13"),
  (14, "contato14"),
  (15, "contato15"),
  (16, "contato16"),
  (17, "contato17"),
  (18, "contato18"),
  (19, "contato19"),
  (20, "contato20");

INSERT INTO emprestimos (idConta, valorInicial, valorProximaParcela, dataProximaParcela, parcelasRestantes) VALUES
  (1, 10000.00, 1050, "01/07/2018", 10),
  (2, 10000.00, 1050, "01/07/2018", 10),
  (3, 10000.00, 1050, "01/07/2018", 10),
  (4, 10000.00, 1050, "01/07/2018", 10),
  (5, 10000.00, 1050, "01/07/2018", 10),
  (6, 10000.00, 1050, "01/07/2018", 10),
  (7, 10000.00, 1050, "01/07/2018", 10),
  (8, 10000.00, 1050, "01/07/2018", 10),
  (9, 10000.00, 1050, "01/07/2018", 10),
  (10, 10000.00, 1050, "01/07/2018", 10),
  (11, 10000.00, 1050, "01/07/2018", 10),
  (12, 10000.00, 1050, "01/07/2018", 10),
  (13, 10000.00, 1050, "01/07/2018", 10),
  (14, 10000.00, 1050, "01/07/2018", 10),
  (15, 10000.00, 1050, "01/07/2018", 10),
  (16, 10000.00, 1050, "01/07/2018", 10),
  (17, 10000.00, 1050, "01/07/2018", 10),
  (18, 10000.00, 1050, "01/07/2018", 10),
  (19, 10000.00, 1050, "01/07/2018", 10),
  (20, 10000.00, 1050, "01/07/2018", 10);

INSERT INTO depositos (idConta, idCaixa, valor, dataHora) VALUES
  (1, 1, 1000, NOW()),
  (2, 2, 1000, NOW()),
  (3, 3, 1000, NOW()),
  (4, 4, 1000, NOW()),
  (5, 5, 1000, NOW()),
  (6, 6, 1000, NOW()),
  (7, 7, 1000, NOW()),
  (8, 8, 1000, NOW()),
  (9, 9, 1000, NOW()),
  (10, 10, 1000, NOW()),
  (11, 11, 1000, NOW()),
  (12, 12, 1000, NOW()),
  (13, 13, 1000, NOW()),
  (14, 14, 1000, NOW()),
  (15, 15, 1000, NOW()),
  (16, 16, 1000, NOW()),
  (17, 17, 1000, NOW()),
  (18, 18, 1000, NOW()),
  (19, 19, 1000, NOW()),
  (20, 20, 1000, NOW());

INSERT INTO saques (idConta, idCaixa, valor, dataHora) VALUES
  (1, 1, 1000, NOW()),
  (2, 2, 1000, NOW()),
  (3, 3, 1000, NOW()),
  (4, 4, 1000, NOW()),
  (5, 5, 1000, NOW()),
  (6, 6, 1000, NOW()),
  (7, 7, 1000, NOW()),
  (8, 8, 1000, NOW()),
  (9, 9, 1000, NOW()),
  (10, 10, 1000, NOW()),
  (11, 11, 1000, NOW()),
  (12, 12, 1000, NOW()),
  (13, 13, 1000, NOW()),
  (14, 14, 1000, NOW()),
  (15, 15, 1000, NOW()),
  (16, 16, 1000, NOW()),
  (17, 17, 1000, NOW()),
  (18, 18, 1000, NOW()),
  (19, 19, 1000, NOW()),
  (20, 20, 1000, NOW());

INSERT INTO transferencias (idCaixa, de, para, valor, dataHora) VALUES
  (1, 1,"123456789", 1000, NOW()),
  (2, 2,"123456789", 1000, NOW()),
  (3, 3,"123456789", 1000, NOW()),
  (4, 4,"123456789", 1000, NOW()),
  (5, 5,"123456789", 1000, NOW()),
  (6, 6,"123456789", 1000, NOW()),
  (7, 7,"123456789", 1000, NOW()),
  (8, 8,"123456789", 1000, NOW()),
  (9, 9,"123456789", 1000, NOW()),
  (10, 10,"123456789", 1000, NOW()),
  (11, 11,"123456789", 1000, NOW()),
  (12, 12,"123456789", 1000, NOW()),
  (13, 13,"123456789", 1000, NOW()),
  (14, 14,"123456789", 1000, NOW()),
  (11, 15,"123456789", 1000, NOW()),
  (16, 16,"123456789", 1000, NOW()),
  (17, 17,"123456789", 1000, NOW()),
  (18, 18,"123456789", 1000, NOW()),
  (19, 19,"123456789", 1000, NOW()),
  (20, 20,"123456789", 1000, NOW());
