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
    private Long authid;
    private Long positionId;
    private Long deptNo;
    private String authorrityName;
    private String positionName;
}
