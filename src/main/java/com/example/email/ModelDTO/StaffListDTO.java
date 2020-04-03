package com.example.email.ModelDTO;

import lombok.Data;

import java.util.Date;
@Data
public class StaffListDTO {
    private Long id;

    private String userName;

    private String loginPassword;

    private String email;

    private String emailPassword;

    private Date startTime;

    private Date loginTime;

    private String nameall;

    private Long positionId;

    private String cardNo;

    private String imgUrl;

    private String qq;

    private String wechatNo;

    private String cellPhone;

    private Long deptNo;

    private String token;

    private Integer sex;

    private Integer status;

    private String deptName;

    private String positionName;
}
