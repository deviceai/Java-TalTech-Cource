drop table if exists person;
drop sequence if exists seq1;

create sequence seq1 start with 1;

create table person (
    id BIGINT not null primary key default nextval('seq1'),
    name VARCHAR (20) not null,
    age int
);