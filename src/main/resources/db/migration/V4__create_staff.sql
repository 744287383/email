create table staff
(
	id bigint auto_increment comment '这是普通的id' primary key ,
	user_name varchar(64) not null comment '用户名',
	login_password varchar(50) not null comment '登录密码',
	email varchar(200) not null comment '电子邮箱号',
	email_password varchar(50) not null comment '邮箱服务器认证密码',
	start_time datetime not null comment '入职时间',
	login_time datetime not null comment '登录时间',
	nameall varchar(10) not null comment '真实姓名',
	position bigint null comment '职位id',
	card_no varchar(18) not null comment '身份证号码',
	img_url text null comment '头像地址',
	QQ varchar(12) null comment 'QQ号',
	wechat_no varchar(50) null comment '微信号',
	cell_phone varchar(11) null comment '手机号',
	dept_no bigint not null comment '部门id'
);

create unique index staff_email_uindex
	on staff (email);

create unique index staff_user_name_uindex
	on staff (user_name);

