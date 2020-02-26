create table message
(
	id bigint auto_increment,
	message_name varchar(200) not null,
	sender varchar(255) null comment '发送者',
	recipients text not null comment '接受者',
	last_updated datetime not null comment '发送时间',
	readed int default 0 null comment '是否已读。0为未读，1为已读',
	sender_status int default 0 null comment '发送者是否删除已发送,0为未删除，1为未删除',
	new_msg int default 1 null comment '是否为新消息，0不是新消息，1是新消息',
	is_file int default 0 null comment '是否有附件。0为不是，1为是',
	rec__status int default 0 null comment '接收者是否删除，0为未删除，1为删除了，2为彻底删除了',
	constraint message_pk
		primary key (id)
);

create unique index message_message_name_uindex
	on message (message_name);

