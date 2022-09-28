use csci927service;

create table if not exists mentalHealthSupport(
    userID varchar(100) not null primary key,
    serviceType varchar(50) not null,
    reason varchar(1000) not null
);

create table if not exists consultation(
  userID varchar(100) not null primary key,
  gpName varchar(100) not null,
  consultationFee decimal(7,2) not null,
  symptoms varchar(1000) not null
);