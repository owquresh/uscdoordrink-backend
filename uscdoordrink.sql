drop database if exists uscdoordrink;
create database if not exists uscdoordrink;
use uscdoordrink;

create table if not exists customers(
	email varchar(255) unique not null,
	name varchar(255) not null,
	password varchar(100) not null,
	id mediumint not null auto_increment, 
	address varchar(255) not null,
	state char(2) not null,
	postal char(5) not null,
	city varchar(255) not null,
	lat decimal(10,8) not null,
	lng decimal(11,8) not null,
	primary key(id)

);

create table if not exists shops(
	email varchar(255) unique not null,
	name varchar(255) not null,
	password varchar(100) not null,
	id mediumint not null auto_increment, 
	address varchar(255) not null,
	state char(2) not null,
	lat decimal(10,8) not null,
	lng decimal(11,8) not null,
	city varchar(255) not null,
	postal char(5) not null,
	primary key(id)
	
);


create table if not exists shopitems(
	shopID mediumint not null,
	item varchar(30) not null,
	description varchar(100),
	url varchar(max),  
	foreign key(shopID) references shops(id)
);


create table if not exists orders(
    	orderID int not null auto_increment,
    	customerID mediumint not null,
    	shopID mediumint not null,
    	total_caffeiene double not null,
    	orderTime timestamp default current_timestamp,
   	foreign key(customerID) references customers(id),
    	foreign key(shopID) references shops(id),
	primary key(orderID)

);

create table if not exists orderitems(
	orderitem varchar(200) not null,
   	caffeine double not null,
	orderid int not null, 
	foreign key(orderid) references orders(orderid)

);
