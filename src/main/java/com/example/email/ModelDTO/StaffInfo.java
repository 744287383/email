package com.example.email.ModelDTO;

import com.example.email.entity.Authorrity;
import com.example.email.entity.Position;
import lombok.Data;

import java.util.Date;

@Data
public class StaffInfo {
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

    private String qq;

    private String wechatNo;

    private String cellPhone;

    private Long deptNo;

    private String token;

    private String imgUrl;

    private Position positions;

    private Authorrity authorrity;

}
