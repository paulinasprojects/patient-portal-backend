alter table doctor_profile
drop column specialty;

alter table doctors
    add specialty longtext not null;
