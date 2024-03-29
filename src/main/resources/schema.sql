create table IF NOT EXISTS course_test
(id int not null,
name varchar(255) not null,
author varchar(255) not null,
primary key (id)
)
;

insert into course_test values (100, 'name1', 'author1');
insert into course_test values (101, 'name2', 'author2');
insert into course_test values (102, 'name3', 'author3');
