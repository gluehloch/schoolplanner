
select 'Start installation of schoolplanner 0.0.1 MySQL schema.' as INFO;
select version();

drop table if exists lesson;
drop table if exists class_student;
drop table if exists class;
drop table if exists course;
drop table if exists school;
drop table if exists student;
drop table if exists teacher;
drop table if exists timetable;

create table lesson (
    id bigint not null auto_increment,
    starttime time,
    endtime time,
    dayofweek int,
    course_ref bigint, 
    primary key (id)
) ENGINE=InnoDB;

create table school (
    id bigint not null auto_increment,
    shortname VARCHAR(20) not null,
    name VARCHAR(100) not null,
    primary key (id)
) ENGINE=InnoDB;

create table course (
    id bigint not null auto_increment,
    shortname VARCHAR(20) not null,
    name VARCHAR(100),
    primary key (id)
) ENGINE=InnoDB;

create table timetable (
    id bigint not null auto_increment,
    primary key (id)
) ENGINE=InnoDB;

create table class (
    id bigint not null auto_increment,
    name VARCHAR(10) not null,
    year VARCHAR(50) not null,
    teacher_ref bigint,
    school_ref bigint not null,
    primary key (id)
) ENGINE=InnoDB;

create table class_student (
    class_ref bigint not null,
    student_ref bigint not null,
    primary key (class_ref, student_ref)
);

create table student (
    id bigint not null auto_increment,
    name VARCHAR(50) not null,
    firstname VARCHAR(50) not null,
    telephone VARCHAR(50),
    birthday datetime,
    email VARCHAR(50),
    primary key (id)
) ENGINE=InnoDB;

create table teacher (
    id bigint not null auto_increment,
    name VARCHAR(50) not null,
    firstname VARCHAR(50) not null,
    telephone VARCHAR(50),
    birthday datetime,
    email VARCHAR(50),
    primary key (id)
 ) ENGINE=InnoDB;

alter table class_student
    add index fk_class_student(student_ref, class_ref),

    add constraint fk_class_student
    foreign key (student_ref)
    references student (id),

    add constraint fk_student_class
    foreign key (class_ref)
    references class (id);

alter table class
    add index fk_class_school(school_ref),

    add constraint fk_class_school
    foreign key (school_ref)
    references school (id);

alter table lesson
    add index fk_lesson_course(course_ref),

    add constraint fk_lesson_course
    foreign key (course_ref)
    references course (id);
