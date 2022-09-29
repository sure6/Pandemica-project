create database if not exists pandemicaapply;
use pandemicaapply;

create table if not exists Application
(
    applicationInfo    varchar(5000) not null,
    compensationAmount decimal(7, 2) not null,
    userID             varchar(100)  not null primary key
);

create table if not exists Complaint
(
    complaintID     int auto_increment
        primary key,
    complaintInfo   varchar(5000) not null,
    complaintAmount decimal(7, 2) not null,
    userID          varchar(100)  not null
);
