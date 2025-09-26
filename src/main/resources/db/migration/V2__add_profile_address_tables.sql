create table address
(
    id         bigint auto_increment
        primary key,
    street     varchar(255) not null,
    city       varchar(255) not null,
    state      varchar(255) not null,
    zip        varchar(255) not null,
    patient_id bigint       not null,
    constraint address_patients_id_fk
        foreign key (patient_id) references patients (id)
);

create table profile
(
    id              bigint      not null
        primary key,
    phone_number    varchar(15) null,
    date_of_birth   date        null,
    bio             longtext    null,
    registered_date date        null,
    constraint profile_patients_id_fk
        foreign key (id) references patients (id)
);