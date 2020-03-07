package com.example.email.ModelDTO;

import lombok.Data;

import java.util.Date;
@Data
public class MinMessageDTO {


    private String messageName;

    private String sender;

    private String recipients;

    private Date lastUpdated;

    private Integer readed;

    private Integer senderStatus;

    private Integer newMsg;

    private Integer isFileStatus;

    private Integer recStatus;

    private String subject;
    private int size;
}
