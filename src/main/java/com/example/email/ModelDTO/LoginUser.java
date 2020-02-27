package com.example.email.ModelDTO;

import lombok.Data;

@Data
public class LoginUser {
    private String userName;
    private String loginPassword;
    private String email;
    private String emailPassword;
    private String nameall;
    private String imgUrl;
    private String authorrity;
}
