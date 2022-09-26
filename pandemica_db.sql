create database if not exists csci927service;
use csci927service;

create table Application
(
    applicationID      int auto_increment
        primary key,
    applicationInfo    varchar(5000) not null,
    compensationAmount decimal(7, 2) not null,
    userID             varchar(100)  not null,
    constraint unique1
        unique (userID)
);

create table Complaint
(
    complaintID     int auto_increment
        primary key,
    complaintInfo   varchar(5000) not null,
    complaintAmount decimal(7, 2) not null,
    userID          varchar(100)  not null
);

create table User
(
    firstName   varchar(100) not null,
    lastName    varchar(100) not null,
    age         int          not null,
    gender      varchar(10)  not null,
    phoneNumber varchar(30)  not null,
    email       varchar(50)  not null,
    position    varchar(100) not null,
    userID      varchar(100) not null
        primary key,
    constraint uq1
        unique (phoneNumber),
    constraint uq2
        unique (email)
);

create table UserAccount
(
    username varchar(100) not null
        primary key,
    password varchar(100) not null,
    userID   varchar(100) not null
);