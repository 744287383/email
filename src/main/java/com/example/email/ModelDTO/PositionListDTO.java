package com.example.email.ModelDTO;

import lombok.Data;
import lombok.Value;

import java.util.Date;

@Data
public class PositionListDTO {
    private Long positionId;

    private String positionName;

    private Date createTime;

    private Date modifyTime;

    private Long deptNo;

    private String deptName;

    private Long authId;

    private String authName;
}
