package com.example.email.ModelDTO;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class MassageDTO {
    private String to;
    private String subject;
    private String text;

}
