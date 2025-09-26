create table doctor_address
(
    id        bigint auto_increment
        primary key,
    street    varchar(255) null,
    city      varchar(255) null,
    state     varchar(255) null,
    zip       varchar(255) null,
    doctor_id bigint       null,
    constraint doctor_address_doctors_id_fk
        foreign key (doctor_id) references doctors (id)
);

create table doctor_profile
(
    id              bigint      not null
        primary key,
    specialty       longtext    not null,
    bio             longtext    null,
    phone_number    varchar(15) null,
    date_of_birth   date        null,
    registered_date date        null,
    constraint doctor_profile_doctors_id_fk
        foreign key (id) references doctors (id)
);


