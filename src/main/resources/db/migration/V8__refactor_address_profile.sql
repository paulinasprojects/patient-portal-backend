alter table patients
    add address varchar(255) null;

alter table patients
    add phone_number varchar(15) null;

alter table patients
    add date_of_birth date null;

alter table patients
    add bio longtext null;

alter table patients
    add registered_date date null;

alter table doctors
    add address varchar(255) null;

alter table doctors
    add phone_number varchar(15) null;

alter table doctors
    add date_of_birth date null;

alter table doctors
    add registered_date date null;

alter table doctors
    add bio longtext null;
