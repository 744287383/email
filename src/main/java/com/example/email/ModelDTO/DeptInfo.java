package com.example.email.ModelDTO;

import com.example.email.entity.Staff;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Data
public class DeptInfo {
    private Long deptNo;

    private String deptName;

    private Date createTime;

    private List<StaffInfo> staffInfos;
}
