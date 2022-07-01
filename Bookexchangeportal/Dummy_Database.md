  ### Copy and Paste the following MYSQL commands to make a dummy database for this Project :


create database onlinebookstore;

use onlinebookstore;

create table books(barcode varchar(100) primary key, name varchar(100), author varchar(100), price int, quantity int,firstname varchar(100),phone varchar(100));

create table users(username varchar(100) primary key,password varchar(100), firstname varchar(100),lastname varchar(100),address text, phone varchar(100),mailid varchar(100),Amount varchar(100), usertype int);

insert into books values('10101','Programming in C','James k Wick',500,5,'Ramesh', '9848412340');

insert into books values('10102','Learn Java','Scott Mayers',150,13,'Suresh', '8978132145');

insert into books values('10103','Database Knowledge','Charles Pettzoid',124,360,'Bhargav', '7896724123');

insert into books values('10104','Let us c++','Steve Macclen',90,111,'Shivamani', '8657423910');

insert into books values('10105','Success Key','Shashi Raj',5000,15,'Yasovar', '9848036728');
 	
insert into users values('User','Password','First','User','My Home','42502216225','User@gmail.com','100',2);

insert into users values('Admin','Admin','Mr.','Admin','Haldia WB','9584552224521','admin@gmail.com','200',1);

insert into users values('shashi','shashi','Shashi','Raj','Bihar','1236547089','shashi@gmail.com','300', 2);

commit;
