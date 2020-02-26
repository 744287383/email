create table authorrity
(
	auth_id bigint auto_increment comment '权限id',
	auth_name varchar(50) null comment '权限名称',
	create_time datetime null comment '权限创建时间',
    modify_time datetime null comment '权限更新时间',
	constraint authorrity_pk
		primary key (auth_id)
);