create database db_crud;

use db_crud;

create table people(id int auto_increment primary key, nome varchar(200) not null, idade int not null);

select * from people;