create table position
(
	position_id bigint auto_increment,
	position_name varchar(50) not null comment '职位名称',
	create_time datetime null comment '职位创建时间',
	modify_time datetime null comment '职位更改时间',
	auth_id bigint not null comment '权限id',
	constraint position_pk
		primary key (position_id)
);