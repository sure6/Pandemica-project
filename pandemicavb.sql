create database if not exists pandemicavaccinebooking;
use pandemicavaccinebooking;

create table if not exists VaccineBooking
(
    userID      varchar(100)  not null primary key,
    vaccineType varchar(200)  not null,
    vaccineNum  int           not null,
    comments    varchar(1000) null
);
