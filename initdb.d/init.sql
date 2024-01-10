/* MYSQL */

create table chat_gpt_db.test_table
(
    id   bigint auto_increment
        primary key,
    name varchar(50) not null
);

insert into chat_gpt_db.test_table (name) values ('test');
insert into chat_gpt_db.test_table (name) values ('test2');
insert into chat_gpt_db.test_table (name) values ('test3');
