create database if not exists csci927service;
use csci927service;

create table if not exists User
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

create table if not exists UserAccount
(
    username varchar(100) not null
        primary key,
    password varchar(100) not null,
    userID   varchar(100) not null,
    constraint ua_unique unique (userID)
);