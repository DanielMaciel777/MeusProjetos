/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  danie
 * Created: 07/11/2018
 */
create database dbpersonalmoney;
use dbpersonalmoney;

create table usuario
(
 idUsuario int not null auto_increment,
 nome varchar(30) not null,
 senha varchar(12) not null,
 pergunta varchar(30) not null,
 resposta varchar(30) not null,
 primary key(idUsuario)
);

create table gastos
(
idGastos int not null auto_increment,
categoria varchar(20) not null,
idUsuario int not null,
descricao varchar(100) not null,
valor double not null,
dataGastos date not null,
primary key(idGastos),
foreign key(idUsuario) references usuario(idUsuario)
);

create table ganhos
(
idGanhos int not null auto_increment,
categoria varchar(20) not null,
idUsuario int not null,
descricao varchar(100) not null,
valor double not null,
dataGanhos date not null,
primary key(idGanhos),
foreign key(idUsuario) references usuario(idUsuario)
);