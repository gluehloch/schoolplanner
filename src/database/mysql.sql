
select 'Start installation of schoolplanner 0.0.1 MySQL schema.' as INFO;
select version();

drop table if exists class;
drop table if exists course;
drop table if exists school;
drop table if exists student;
drop table if exists teacher;
drop table if exists timetable;

create table class (
    id bigint not null,
    name VARCHAR(10) not null,
    year VARCHAR(50) not null,
    teacher_ref bigint,
    school_ref bigint not null,
    primary key (id)
) ENGINE=InnoDB;
 
create table student (
    id bigint not null,
    name VARCHAR(50) not null,
    firstname VARCHAR(50) not null,
    telephone VARCHAR(50),
    birthday datetime,
    email VARCHAR(50),
    class_ref bigint,
    primary key(id)
) ENGINE=InnoDB;

alter table student
    add index fk_student_class(class_ref),
    add constraint fk_student_class,
    foreign key (class_ref)
    references class (id);
