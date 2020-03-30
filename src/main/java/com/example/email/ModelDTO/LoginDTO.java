package com.example.email.ModelDTO;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class LoginDTO {
    @Email(message = "请真确输入邮箱地址格式！")
    @NotBlank(message = "邮箱地址不能为空！")
    private String email;
    @NotBlank(message = "密码不能为空！")
    @Length(min = 6,message = "密码不能小于6位")
    private String password;

}
