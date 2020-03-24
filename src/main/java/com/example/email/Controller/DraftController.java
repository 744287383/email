package com.example.email.Controller;

import com.example.email.ModelDTO.DraftDTO;
import com.example.email.ModelDTO.LoginUser;
import com.example.email.ModelDTO.MassageDTO;
import com.example.email.Service.DraftServiceImp;
import com.example.email.entity.Draft;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;

@Controller
public class DraftController {
    @Value("${page.size}")
    private int size;
@Autowired
private DraftServiceImp draftServiceImp;
    @RequestMapping(value = "/user/setDraft")

    public String setDraft(MassageDTO massageDTO,
                              HttpSession session, @RequestParam(value = "file",required = false) MultipartFile file) throws MessagingException {
        LoginUser loginUser = (LoginUser) session.getAttribute("user");
        draftServiceImp.saveDraft(loginUser, massageDTO);
        return "redirect:/user/getDraftListView";
    }

    @RequestMapping(value = "/user/getDraftListView")
    public String getDraftListView(@RequestParam(required = false,value = "indexPage",defaultValue = "1")int indexPage,
                                      HttpSession session, Model model){
        LoginUser loginUser = (LoginUser) session.getAttribute("user");
        PageInfo<DraftDTO> pageList = draftServiceImp.getDraftList(indexPage, size, loginUser);
        model.addAttribute("pageList",pageList);

        return "draftListView";
    }
    @RequestMapping(value = "/user/deleteDraft")
    @ResponseBody
    public String deleteDraft(@RequestParam(required = false,value = "indexPage",defaultValue = "1")int indexPage,
                              @RequestParam(value = "id")int id,
                                   HttpSession session, Model model){
        LoginUser loginUser = (LoginUser) session.getAttribute("user");
        draftServiceImp.deleteDraftByid(loginUser,id);


        return "success";
    }

    @RequestMapping(value = "/user/editorDraft")
    public String editorDraft(@RequestParam(required = false,value = "indexPage",defaultValue = "1")int indexPage,
                              @RequestParam(value = "id")int id,
                              HttpSession session, Model model){
        LoginUser loginUser = (LoginUser) session.getAttribute("user");
       Draft draft= draftServiceImp.getDraftById(loginUser,id);
       DraftDTO draftDTO=new DraftDTO();
        BeanUtils.copyProperties(draft,draftDTO);
       model.addAttribute("draftDTO",draftDTO);
        return "write";
    }

}
