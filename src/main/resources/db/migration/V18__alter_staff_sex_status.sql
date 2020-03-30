alter table staff
	add sex int null comment '性别，0为女，1为男';

alter table staff
	add status int null comment '账号状态，0为正常，1为离职';