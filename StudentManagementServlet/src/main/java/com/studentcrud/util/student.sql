SELECT * FROM student_management.student;
use student_management;
alter table student drop teacher_username;
alter table student
add column teacher_username varchar(20)  ,
add constraint teacher_username
Foreign key (teacher_username) References admin_users(user_name);
create table admin_users(
	user_name varchar(20) primary key,
    password varchar(20) not null,
    section char(1) not null
);
truncate student;
alter table student
add column half_yearly int ,
add column Annual_yearly int;