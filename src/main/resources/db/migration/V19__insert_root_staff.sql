insert staff (user_name, login_password, email, email_password, start_time, login_time, nameall, position_id, card_no, img_url, QQ, wechat_no, cell_phone, dept_no,sex,status)
        values('root','123456','root@test.com','123456',now(),now(),'管理员',1,'*****************','http://test.com:8080/images/tx.png','123456789','123456789','12345678901',1,0,0);
insert into users (username, pwdHash, pwdAlgorithm, useForwarding,  useAlias)
            VALUES('root','fEqNCco3Yq9h5ZUglD3CZJT4','SHA',0,0);
insert into position (position_name, create_time, modify_time, auth_id,dept_no) values('root',now(),now(),1,1);