package com.example.email.ModelDTO;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class LoginDTO {
    @Email(message = "请真确输入邮箱地址格式！")
    @NotBlank(message = "邮箱地址不能为空！")
    private String email;
    @NotBlank(message = "密码不能为空！")
    private String password;

}
