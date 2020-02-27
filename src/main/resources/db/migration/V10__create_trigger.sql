delimiter $
create trigger inbox_to_msg before insert on inbox
 for each row
 begin
  insert into message (message_name,sender,recipients,last_updated) values(new.message_name,new.sender,new.recipients,new.last_updated);
  end$
  delimiter ;