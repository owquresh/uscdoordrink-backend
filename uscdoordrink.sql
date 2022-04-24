drop database if exists uscdoordrink;
create database if not exists uscdoordrink;
use uscdoordrink;

create table if not exists customers(
	name varchar(255) not null,
    email varchar(255) unique not null,
	password varchar(100) not null,
	id mediumint not null auto_increment, 
	address varchar(255) not null,
	state char(2) not null,
	postal char(5) not null,
	lat decimal(10,8) not null,
	lng decimal(11,8) not null,
	city varchar(255) not null,
	primary key(id)

);

create table if not exists shops(
	name varchar(255) not null,
	email varchar(255) unique not null,
	password varchar(100) not null,
	id mediumint not null auto_increment, 
	address varchar(255) not null,
	state char(2) not null,
	lat decimal(10,8) not null,
	lng decimal(11,8) not null,
	postal char(5) not null,
    city varchar(255) not null,
	primary key(id)
	
);

create table if not exists shopitems(
	itemID mediumint not null auto_increment,
	shopID mediumint not null,
	item varchar(30) not null,
	description varchar(100),
    caffine double not null,
    price double not null, 
    discountPrice double,
	url varchar(256),  
	foreign key(shopID) references shops(id),
    primary key(itemID)
);


create table if not exists orders(
    	orderID int not null auto_increment,
    	customerID mediumint not null,
    	shopID mediumint not null,
    	total_caffine double not null,
    	orderTime timestamp default current_timestamp,
        deliveredTime timestamp,
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
INSERT INTO shops(name, email, password, address, state, lat, lng, postal, city)
VALUES
("shop 1", "shop1@gmail.com", "123", "2810 S Figueroa St", "CA", 34.026192, -118.276993, "90007", "Los Angeles"),
("shop 2", "shop2@gmail.com", "123", "2701 S Vermont Ave", "CA", 34.030041, -118.292000, "90007", "Los Angeles"),
("shop 3", "shop3@gmail.com", "123", "1101 W 23rd St", "CA", 34.035049, -118.283539, "90007", "University Park"),
("shop 4", "shop4@gmail.com", "123", "3758 S Figueroa St", "CA", 34.016788, -118.282722, "90007", "Los Angeles");
INSERT INTO customers(name, email, password, address, state, lat, lng, postal, city)
VALUES
("customer 1", "c1@gmail.com", "123", "2810 S Figueroa St", "CA", 34.026192, -118.276993, "90007", "Los Angeles"),
("customer 2", "c2@gmail.com", "123", "2810 S Figueroa St", "CA", 34.026192, -118.276993, "90007", "Los Angeles"),
("customer 3", "c3@gmail.com", "123", "2810 S Figueroa St", "CA", 34.026192, -118.276993, "90007", "Los Angeles"); 
INSERT INTO orders (customerID, shopID, total_caffine)
VALUES (1, 1, 200),
(1, 1, 200),
(2, 1, 200),
(3, 1, 400),
(3, 2, 100);
INSERT INTO shopitems (shopID, item, caffine, description, price)
VALUES 
(1, "Black Coffee", 96, "300ml black coffee", 2.99),
(1, "Latte", 45, "330ml iced latte", 4.99),
(1, "Espresso", 30, "50ml shot of espresso", 5.99),
(1, "The devil", 400 , "100ml of pure caffine, NSFW", 6.99);
INSERT INTO shopitems (shopID, item, caffine, description, price, discountPrice)
VALUES 
(1, "Seasonal Tea", 0, "Only for summer", 5.99,4.99);





