DROP DATABASE IF EXISTS transportadora;
CREATE DATABASE IF NOT EXISTS transportadora;
USE transportadora;


CREATE TABLE colaborador(
    idColaborador INT not null AUTO_INCREMENT,
    cpf varchar(14) NOT NULL,
    nome VARCHAR(100) NOT NULL,
    telefone VARCHAR(14) NOT NULL,
    email  VARCHAR(45) NOT NULL,
    cidade varchar(45) not null,
    estado VARCHAR(2) NOT NULL,
    bairro varchar(45) not null,
	rua varchar(45) not null,
    PRIMARY KEY (idColaborador)
);
CREATE TABLE cliente(
    idCliente INT not null AUTO_INCREMENT,
    cpf varchar(14) NOT NULL,
    nome VARCHAR(100) NOT NULL,
    telefone VARCHAR(14) NOT NULL,
    email  VARCHAR(45) NOT NULL,
    cidade varchar(45) not null,
   estado VARCHAR(2) NOT NULL,
    bairro varchar(45) not null,
	rua varchar(45) not null,
    PRIMARY KEY (idCliente)
);
CREATE TABLE funcionario(
	idFuncionario INT not null AUTO_INCREMENT,
	cpf varchar(14) NOT NULL,
    nome VARCHAR(100) NOT NULL,
    telefone VARCHAR(14) NOT NULL,
    email  VARCHAR(45) NOT NULL,
    cidade varchar(45) not null,
    estado VARCHAR(2) NOT NULL,
    bairro varchar(45) not null,
	rua varchar(45) not null,
    nivel char(1) not null,
    senha varchar(45) not null,
    PRIMARY KEY (idFuncionario)
);
create table produto (
    idProduto int not null auto_increment,
    tipo varchar(45) not null,
    primary key(idProduto)
);
CREATE TABLE carga(
    idCarga INT not null AUTO_INCREMENT,
    idCliente int NOT NULL,
    idProduto int NOT NULL,
    dataAprovacao date,
    origem varchar(45) not null,
    destino varchar(45) not null,
    qtdeTotal double not null,
    valorCarga double not null,
    unidadeMedida varchar(20) not null,
    qtdeTransportada double not null,
    PRIMARY KEY (idCarga),
    FOREIGN KEY (idCliente) references cliente (idCliente),
	FOREIGN KEY (idProduto) references produto (idProduto)
);
create table transporte(
    idTransporte int not null auto_increment,
    idCarga int not null,
    idColaborador int not null,
    dataCarregou date,
    dataDescarregou date,
    qtde double not null,
    valorFrete double not null,
    primary key(idTransporte),
    foreign key(idCarga) references carga (idCarga),
    foreign key(idColaborador) references colaborador (idColaborador)
);

create table pagamentoTransporte(
    idPagamentoTransporte int not null,
    idTransporte int not null,
    valorParcela double not null,
    dataVencimento date not null,
    dataPagamento date,
    primary key(idPagamentoTransporte, idTransporte),
    foreign key(idTransporte) references Transporte(idTransporte)
);
create table pagamento(
    idPagamento int not null auto_increment,
    idCarga int not null,
    idFuncionario int not null,
    valorTotal double not null,
    dataPagamento date,
    PRIMARY KEY (idPagamento),
    FOREIGN KEY (idCarga) references carga (idCarga),
	foreign key(idFuncionario) references funcionario(idFuncionario)
);

INSERT INTO colaborador (cpf, nome, telefone, email, cidade, estado, bairro, rua) VALUES
('123.456.789-10', 'Marcelo Cristian', '(18)98127-3050', 'Mc@gamil.com', 'Rio de Janeiro', 'RJ', 'Copacabana', 'Rua dos Três Pescadores'),
('234.567.890-12', 'Ana Beatriz', '(11)98234-5678', 'AnaB@gamil.com', 'São Paulo', 'SP', 'Vila Mariana', 'Rua da Consolação'),
('345.678.901-23', 'Carlos Silva', '(21)98345-6789', 'CarlosS@gamil.com', 'Rio de Janeiro', 'RJ', 'Botafogo', 'Rua São Clemente'),
('456.789.012-34', 'Mariana Costa', '(31)98456-7890', 'MarianaC@gamil.com', 'Belo Horizonte', 'MG', 'Centro', 'Avenida Afonso Pena'),
('567.890.123-45', 'Pedro Oliveira', '(41)98567-8901', 'PedroO@gamil.com', 'Curitiba', 'PR', 'Água Verde', 'Rua Riachuelo'),
('678.901.234-56', 'Fernanda Lima', '(51)98678-9012', 'FernandaL@gamil.com', 'Porto Alegre', 'RS', 'Cidade Baixa', 'Rua da Praia');


INSERT INTO cliente (cpf, nome, telefone, email, cidade, estado, bairro, rua) VALUES
('098.765.432-12', 'Raul Lopes', '(18)98190-2783', 'RLopes@gamil.com', 'Campo Grande', 'MT', 'Centro', 'Rua da Liberdade'),
('543.210.987-65', 'Juliana Santos', '(71)98765-4321', 'JulianaS@gamil.com', 'Salvador', 'BA', 'Barra', 'Avenida Oceanica'),
('654.321.098-76', 'Ricardo Mendes', '(85)97654-3210', 'RicardoM@gamil.com', 'Fortaleza', 'CE', 'Meireles', 'Rua José de Alencar'),
('765.432.109-87', 'Tatiane Ferreira', '(62)96543-2109', 'TatianeF@gamil.com', 'Goiânia', 'GO', 'Setor Bueno', 'Rua 1.200'),
('876.543.210-98', 'Sofia Martins', '(61)98765-4321', 'SofiaM@gamil.com', 'Brasília', 'DF', 'Asa Norte', 'Quadra 201'),
('987.654.321-09', 'Gustavo Rocha', '(51)97654-3210', 'GustavoR@gamil.com', 'Porto Alegre', 'RS', 'Moinhos de Vento', 'Rua da República');


INSERT INTO funcionario (cpf, nome, telefone, email, cidade, estado, bairro, rua, nivel, senha) VALUES
('527.723.588-44', 'Heloisa Giovana', '(18)98128-3350', 'HG@gamil.com', 'Presidente Prudente', 'SP', 'Jardim Real', 'Rua das Flores', 'A', '123'),
('222.707.318-75', 'Amanda Rodrigues', '(18)98123-6036', 'AR@gamil.com', 'Maringá', 'PR', 'Renascer', 'Avenida Brasil', 'F', '321'),
('333.444.555-66', 'Lucas Pereira', '(31)98765-4321', 'LucasP@gamil.com', 'Belo Horizonte', 'MG', 'Santa Tereza', 'Rua dos Trovadores', 'F', '456'),
('444.555.666-77', 'Isabela Almeida', '(21)97654-3210', 'IsabelaA@gamil.com', 'Rio de Janeiro', 'RJ', 'Leblon', 'Avenida Atlântica', 'A', '789');


INSERT INTO produto (tipo) VALUES
('Milho'),
('Soja'),
('Arroz'),
('Trigo'),
('Feijão'),
('Cevada'),
('Aveia');


