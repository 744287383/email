package com.example.email.Service;

import com.example.email.Enum.ReadStatus;
import com.example.email.Enum.RecStatus;
import com.example.email.ModelDTO.LoginDTO;
import com.example.email.entity.MessageExample;
import com.example.email.mapper.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceIMP {
@Autowired
private MessageMapper messageMapper;
    @Autowired
    private StaffInfoServiceIMP staffInfoServiceIMP;

    public  long getALLMessageCount(LoginDTO loginDTO){
        MessageExample messageExample=new MessageExample();
        messageExample.or().andRecipientsEqualTo(loginDTO.getEmail());
        long l = messageMapper.countByExample(messageExample);
        return l;
    }
    public  long getUnreadMessageCount(LoginDTO loginDTO){
        MessageExample messageExample=new MessageExample();
        messageExample.or().andRecipientsEqualTo(loginDTO.getEmail()).andReadedEqualTo(ReadStatus.UNREAD.getStatus());
        long l = messageMapper.countByExample(messageExample);
        return l;
    }
    public  int getDeletedMessageCount(LoginDTO loginDTO){
        MessageExample messageExample=new MessageExample();
        messageExample.or().andRecipientsEqualTo(loginDTO.getEmail()).andRecStatusEqualTo(RecStatus.DELETED.getStatus());
        long l = messageMapper.countByExample(messageExample);
        return 0;
    }
    public  int getNewMessageCount(){
        return 0;
    }

}
