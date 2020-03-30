package com.example.email.Controller;

import com.example.email.ModelDTO.DraftDTO;
import com.example.email.ModelDTO.LoginUser;
import com.example.email.Service.DeptInfoServiceIMP;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class DeptController {
    @Value("${page.size}")
    private int size;
    @Autowired
    private DeptInfoServiceIMP deptInfoServiceIMP;
    @RequestMapping(value = "/user/admin/getDeptView")
    public String getDraftListView(@RequestParam(required = false,value = "indexPage",defaultValue = "1")int indexPage,
                                   HttpSession session, Model model){
        LoginUser loginUser = (LoginUser) session.getAttribute("user");
        PageInfo<DraftDTO> pageList = deptInfoServiceIMP.getAlLDept(indexPage, size, loginUser);
        model.addAttribute("pageList",pageList);
        return "deptView";
    }
}
