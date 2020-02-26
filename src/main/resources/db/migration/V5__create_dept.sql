create table dept
(
	dept_no bigint auto_increment comment '部门id',
	dept_name varchar(50) not null comment '部门名称',
	create_time datetime not null comment '创建时间',
	constraint dept_pk
		primary key (dept_no)
);

create unique index dept_dept_name_uindex
	on dept (dept_name);
