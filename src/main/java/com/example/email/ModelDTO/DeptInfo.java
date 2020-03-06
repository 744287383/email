package com.example.email.ModelDTO;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class DeptInfo {
    private Long deptNo;

    private String deptName;

    private Date createTime;

    private List<StaffInfo> staffInfos;
}
