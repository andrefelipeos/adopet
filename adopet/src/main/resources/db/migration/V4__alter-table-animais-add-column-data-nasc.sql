alter table animais add column data_nasc date;

update animais set data_nasc = '1900-01-01';

alter table animais alter column data_nasc set not null;