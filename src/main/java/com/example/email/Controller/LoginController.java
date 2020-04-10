package com.example.email.Controller;

import com.example.email.Enum.StaffStatus;
import com.example.email.ModelDTO.LoginDTO;
import com.example.email.ModelDTO.LoginUser;
import com.example.email.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.UUID;

@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String getLoginview(){
        return "login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String Login( @Validated LoginDTO loginDTO,
                        BindingResult bindingResult,
                        Model model,
                        HttpServletResponse response,
                        HttpSession session){
        if (bindingResult.hasErrors()){
            return "errorLogin";
        }
        if (!loginService.isPasswordMatch(loginDTO.getEmail(),loginDTO.getPassword())){
            bindingResult.rejectValue("email","密码错误！","密码错误！");

            return "errorLogin";
        }
        LoginUser loginUserInfo = loginService.getLoginUserInfo(loginDTO.getEmail(), loginDTO.getPassword());
        int status=  loginService.getStatus(loginDTO.getEmail());
        if (status== StaffStatus.QUIT.getStatus()){
            bindingResult.rejectValue("email","员工已经离职，账号已被停用","员工已经辞职，账号已被停用");
            return "errorLogin";
        }
        String token = UUID.randomUUID().toString();
        loginService.updateToken(token,loginUserInfo.getEmail());
        session.setAttribute("user",loginUserInfo);
        Cookie cookie=new Cookie("token",token);
        cookie.setMaxAge(60*60*24*7);
        response.addCookie(cookie);
        model.addAttribute("loginUser",loginUserInfo);
        return "redirect:/user/index";

    }
    @RequestMapping(value = "/user/index",method = RequestMethod.GET)
    public String getindexview(){
        return "write";
    }

}
