
use javadb;

create table student(
no int auto_increment,
s_no varchar(30),
s_name varchar(50) not null,
s_btday varchar(10),
s_tel varchar(15),
s_addr varchar(30),
regdate datetime default now(),
primary key(no));