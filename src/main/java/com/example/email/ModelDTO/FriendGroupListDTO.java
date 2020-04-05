package com.example.email.ModelDTO;

import com.example.email.entity.Staff;
import lombok.Data;

import java.util.List;
@Data
public class FriendGroupListDTO {
    private Long id;

    private String groupName;

    private String userName;

    private Integer defaultGroup;
    private List<Staff> staff;
}
