drop table movies if exists;
create table movies(id identity, title varchar(100), description varchar(500),
director varchar(255),  genre varchar(100), languages varchar(100), starring varchar(500),
duration varchar(100),  year varchar(10));
