create table animais(
	identificador serial primary key,
	nome varchar(50) not null,
	descricao varchar(500),
	adotado boolean,
);