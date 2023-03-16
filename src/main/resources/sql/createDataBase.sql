drop database if exists servlet_practice;
create database servlet_practice;
use servlet_practice;
create table users(
    id int auto_increment primary key ,
    username varchar(12) check (length(username)>=6) unique ,
    password varchar(12) check (length(password)>=6)
);

insert into users values (null,'testacc01','password');
insert into users values (null,'testacc02','password');

select * from users;

