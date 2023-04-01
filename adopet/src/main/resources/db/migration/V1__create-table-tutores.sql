create table tutores(
	identificador serial primary key,
	nome varchar(100) not null,
	email varchar(100) unique not null,
	telefone varchar(40) unique not null,
	cidade varchar(100) not null,
	biografia varchar(500),
	senha varchar(100) not null
);