create table friendgroup
(
	id bigint auto_increment,
	group_name varchar(20) null,
	user_name varchar(50) null,
	default_group int null,
        constraint friendgroup_pk
        primary key (id)
);
create table addressbook
(
    aid bigint auto_increment,
    friendgroup_id bigint null,
    user_name varchar(50) null,
    constraint addressbook_pk
        primary key (aid)
);