drop database if exists uscdoordrink;
create database if not exists uscdoordrink;
use uscdoordrink;

create table if not exists users(
	email varchar(255) unique not null,
	password varchar(100) not null,
	id mediumint not null auto_increment, 
	address varchar(255) not null,
	postal char(5) not null,
    type smallint not null,
	primary key(id)

);

create table if not exists orders(
    orderID int not null auto_increment,
    customerID mediumint not null,
    shopID mediumint not null,
    total_caffeiene double not null,
    orderTime timestamp default current_timestamp,
    foreign key(customerID) references users(id),
    foreign key(shopID) references users(id),
	primary key(orderID)

);

create table if not exists orderitems(
	orderitem varchar(200) not null,
    caffeine double not null,
	orderid int not null, 
	foreign key(orderid) references orders(orderid)

);