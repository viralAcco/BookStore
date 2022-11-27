create database bookstore;
use bookstore;

create table user(
	user_id int not null auto_increment,
    user_name varchar(255) not null unique,
    mail_id varchar(255) unique,
    phone_num varchar(20) unique,
    user_status boolean DEFAULT 1,
	user_wallet int,
    user_log_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    primary key(user_id)
);

create table book(
	book_id int not null auto_increment,
    book_name varchar(20) not null,
    book_author varchar(20) not null,
    book_price int not null not null,
    book_category varchar(30) not null,
    book_log_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    primary key(book_id)
);

create table bookCount(
	book_copies int ,
    book_id int not null,
	foreign key(book_id) REFERENCES book(book_id)
);

create table review(
	user_id int not null,
    book_id int not null,
    book_review varchar(255),
	
    foreign key(book_id) REFERENCES book(book_id),
    foreign key(user_id) REFERENCES user(user_id)
);

create table rented(
	user_id int not null,
    book_id int not null,
    book_quantity int not null,
    issue_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    return_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,	
    foreign key(book_id) REFERENCES book(book_id),
    foreign key(user_id) REFERENCES user(user_id)
);