create table abrigos(
	identificador serial primary key,
	nome varchar(100) not null,
	email varchar(100) unique not null,
	telefone varchar(40) unique not null,
	cep char(8) not null,
	cidade varchar(100) not null,
	bairro varchar(100) not null,
	logradouro varchar(100) not null,
	numero integer,
	complemento varchar(100),
	descricao varchar(1000)
);