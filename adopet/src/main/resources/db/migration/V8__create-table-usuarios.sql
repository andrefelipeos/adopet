create table usuarios(
	id serial primary key,
	username varchar not null unique,
	password varchar not null
);
