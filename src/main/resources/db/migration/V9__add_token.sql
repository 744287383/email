alter table staff
	add token varchar(255) null comment '登录token';

create unique index staff_token_uindex
	on staff (token);