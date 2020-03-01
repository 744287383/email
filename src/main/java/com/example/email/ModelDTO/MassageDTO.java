package com.example.email.ModelDTO;

import lombok.Data;

@Data
public class MassageDTO {
    private String to;
    private String subject;
    private String text;
}
