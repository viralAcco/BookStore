use bookstore;

create table user(
	user_id int not null auto_increment,
    user_name varchar(255) not null unique,
    mail_id varchar(255) unique,
    phone_num varchar(20) unique,
    user_status varchar(20),
    created_time DATETIME DEFAULT CURRENT_TIMESTAMP,
    primary key(user_id)
);