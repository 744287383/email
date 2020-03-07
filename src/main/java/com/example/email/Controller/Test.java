package com.example.email.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Test {
    @RequestMapping(value = "/test1")
    public String testView(){
        return "recMessageList";
    }
}
