package com.example.email.ModelDTO;

import lombok.Data;

import java.util.Date;

@Data
public class DraftDTO {
    private Long id;

    private String recipients;

    private String subjects;

    private String content;

    private String sender;

    private Integer type;

    private Date createTime;
}
