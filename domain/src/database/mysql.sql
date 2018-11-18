
select 'Start installation of schoolplanner 0.0.1 MySQL schema.' as INFO;
select version();

drop table if exists user_registration;
drop table if exists user_session;
drop table if exists user;

create table user_registration (
    id bigint not null auto_increment,
    username varchar(20) not null unique,
    password varchar(60) not null,
    email varchar(50) not null,
    created datetime not null,
    token varchar(2048) not null,
    primary key(id)
) ENGINE=InnoDB;

create table user (
    id bigint not null auto_increment,
    username varchar(20) not null unique,
    password varchar(60) not null,
    email varchar(50) not null,
    created datetime not null,
    last_change datetime comment 'Last password change',
    enabled bit comment 'account enabled',
    expired bit comment 'password expired',
    locked bit comment 'account locked',
    credential_expired bit comment 'credential expired?',
    primary key(id)
) ENGINE=InnoDB;

create table user_session (
    id bigint not null auto_increment,
    user_ref bigint,
    token varchar(2048) not null comment 'Session Token',
    login datetime comment 'Login date and time',
    logout datetime comment 'Logout date and time',
    remoteaddress varchar(30) comment 'IP address',
    browser varchar(200) comment 'Browser',
    primary key(id)
) ENGINE=InnoDB;

alter table user_session
    add constraint fk_user_session_user
    foreign key (user_ref)
    references user(id);

drop table if exists lesson;
drop table if exists class_student;
drop table if exists class;
drop table if exists schoolclass;
drop table if exists course;
drop table if exists school;
drop table if exists student;
drop table if exists teacher;
drop table if exists timetable;

create table lesson (
    id bigint not null auto_increment,
    starttime time,
    endtime time,
    dayofweek varchar(10),
    course_ref bigint,
    timetable_ref bigint, 
    primary key(id)
) ENGINE=InnoDB;

create table school (
    id bigint not null auto_increment,
    shortname varchar(20) not null unique,
    name varchar(100) not null,
    primary key(id)
) ENGINE=InnoDB;

create table course (
    id bigint not null auto_increment,
    shortname varchar(20) not null unique,
    name varchar(100),
    primary key(id)
) ENGINE=InnoDB;

create table timetable (
    id bigint not null auto_increment,
    schoolclass_ref bigint not null unique,
    primary key(id)
) ENGINE=InnoDB;

create table schoolclass (
    id bigint not null auto_increment,
    name varchar(10) not null,
    year varchar(50) not null,
    teacher_ref bigint,
    school_ref bigint not null,
    primary key(id)
) ENGINE=InnoDB;

alter table `schoolclass` add unique `unique_index`(`name`, `year`);

create table class_student (
    class_ref bigint not null,
    student_ref bigint not null,
    primary key (class_ref, student_ref)
);

create table student (
    id bigint not null auto_increment,
    name varchar(50) not null,
    firstname varchar(50) not null,
    telephone varchar(50),
    birthday datetime,
    email varchar(50),
    primary key(id)
) ENGINE=InnoDB;

create table teacher (
    id bigint not null auto_increment,
    name varchar(50) not null,
    firstname varchar(50) not null,
    telephone varchar(50),
    birthday datetime,
    email varchar(50),
    primary key(id)
 ) ENGINE=InnoDB;

alter table class_student
    add index fk_class_student(student_ref, class_ref),

    add constraint fk_class_student
    foreign key (student_ref)
    references student(id),

    add constraint fk_student_class
    foreign key (class_ref)
    references schoolclass(id);

alter table schoolclass
    add index fk_schoolclass_school(school_ref),

    add constraint fk_schoolclass_school
    foreign key (school_ref)
    references school(id);

alter table lesson
    add index fk_lesson_course(course_ref),

    add constraint fk_lesson_course
    foreign key (course_ref)
    references course(id);

alter table lesson
    add index fk_lesson_timetable(timetable_ref),

    add constraint fk_lesson_timetable
    foreign key (timetable_ref)
    references timetable(id);
