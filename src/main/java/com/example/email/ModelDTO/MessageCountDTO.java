package com.example.email.ModelDTO;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
public class MessageCountDTO {
    private Long newMsgCount;
    private Long unReadMsgCount;
    private Long DraftCount;
    private Long sendedMsgCount;
    private Long deleteMsgCount;

}
