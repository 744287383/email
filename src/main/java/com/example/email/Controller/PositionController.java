package com.example.email.Controller;

import com.example.email.ModelDTO.DeptInfo;
import com.example.email.ModelDTO.DraftDTO;
import com.example.email.ModelDTO.LoginUser;
import com.example.email.ModelDTO.PositionListDTO;
import com.example.email.Service.AuthorrityServiceImp;
import com.example.email.Service.DeptInfoServiceIMP;
import com.example.email.Service.PositionServiceImp;
import com.example.email.Service.StaffInfoServiceIMP;
import com.example.email.entity.Authorrity;
import com.example.email.entity.Dept;
import com.example.email.entity.Position;
import com.example.email.entity.Staff;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class PositionController {
    @Value("${page.size}")
    private int size;
    @Autowired
    private DeptInfoServiceIMP deptInfoServiceIMP;
    @Autowired
    private PositionServiceImp positionServiceImp;
    @Autowired
    private StaffInfoServiceIMP staffInfoServiceIMP;
    @Autowired
    private AuthorrityServiceImp authorrityServiceImp;
    @RequestMapping(value = "/user/admin/getPositionView")
    public String getPositionView(@RequestParam(required = false,value = "indexPage",defaultValue = "1")int indexPage,
                                   HttpSession session, Model model,
                                  @RequestParam(required = false,value = "deptNo",defaultValue = "0")int deptNo){
        LoginUser loginUser = (LoginUser) session.getAttribute("user");
        List<Dept> alLDept = deptInfoServiceIMP.getAlLDept();
        List<Authorrity> list= authorrityServiceImp.getAllAuth();
        model.addAttribute("auths",list);
        if (deptNo==0){

            model.addAttribute("depts",alLDept);
           PageInfo <PositionListDTO> pageList=  positionServiceImp.getAllPositionBypage(indexPage, size, loginUser);
            model.addAttribute("pageList",pageList);
            model.addAttribute("deptNo",deptNo);
           return "positionListView";
        }
        PageInfo <PositionListDTO> pageList=  positionServiceImp.getAllPositionBypage(indexPage, size, loginUser,deptNo);
        model.addAttribute("depts",alLDept);
        model.addAttribute("pageList",pageList);
        model.addAttribute("deptNo",deptNo);
        return "positionListView";
    }

    @RequestMapping(value = "/user/admin/deletePosition")
    @ResponseBody
    public Map<String,String> deletePosition(@RequestParam("positionId")long positionId){
        Map<String,String> result=new HashMap<>();
        List<Staff> staffByPostionId = staffInfoServiceIMP.getStaffByPostionId(positionId);
       if (null==staffByPostionId||0==staffByPostionId.size()){
        positionServiceImp.deletePositionByPositionId(positionId);
        result.put("msg","成功删除职位！");
        return result;
       }
       result.put("msg","该职位已有员工任职，职位删除失败！");
       return result;
    }
    @RequestMapping(value = "/user/admin/updatePositionName")
    @ResponseBody
    public Map<String,String> updatePositionName(@RequestParam("positionId")long positionId,
                                                @RequestParam("deptNo")long deptNo,
                                                 @RequestParam("positonName")String positonName){
        Map<String,String> result=new HashMap<>();
        Position position=new Position();
        position.setDeptNo(deptNo);
        position.setPositionId(positionId);
        position.setPositionName(positonName);
        positionServiceImp.updatePositionByPositionId(position);
        result.put("msg","职位修改成功！");
        return result;
    }
    @RequestMapping(value = "/user/admin/updateAuth")
    @ResponseBody
    public Map<String,String> updateAuth(@RequestParam(value = "positionId")long positionId,
                                                 @RequestParam(value = "authId")long authId
                                                 ){
        Map<String,String> result=new HashMap<>();
        Position position=new Position();
        position.setPositionId(positionId);
        position.setAuthId(authId);
        positionServiceImp.updatePositionByPositionId(position);
        result.put("msg","权限修改成功！");
        return result;
    }
    @RequestMapping("/user/admin/getAddPositionView")
    public String getAddPositionView(
            Model model
    ){
        List<Authorrity> allAuth = authorrityServiceImp.getAllAuth();
        model.addAttribute("auths",allAuth);
        List<Dept> alLDept = deptInfoServiceIMP.getAlLDept();
        model.addAttribute("depts",alLDept);
        return "addPositionView";
    }

    @RequestMapping(value = "/user/admin/addPosition")
    @ResponseBody
    public Map<String,String> addPosition(@RequestParam(value = "positionName")String positionName,
                                         @RequestParam(value = "authId")long authId,
                                          @RequestParam(value = "deptNo")long deptNo
    ){
        Map<String,String> result=new HashMap<>();
        Position obj=positionServiceImp.getPositionByPositionNameAndDeptName(positionName,deptNo);
        if (null!=obj){
            result.put("msg","该部门中已存在同名职位！");
            return result;
        }
        Position position=new Position();
        position.setPositionName(positionName);
        position.setAuthId(authId);
        position.setDeptNo(deptNo);

        position.setCreateTime(new Date(System.currentTimeMillis()));
        position.setModifyTime(new Date(System.currentTimeMillis()));
        positionServiceImp.addPosition(position);
        result.put("msg","职位添加成功！");
        return result;
    }

    @RequestMapping(value = "/user/admin/getPositionByDeptNo")
    @ResponseBody
    public Map<String,Object> getPositionByDeptNo(@RequestParam("deptNo")long deptNo){
        Map<String,Object> result=new HashMap<>();

        List<Position> positions = positionServiceImp.getpositionByDeptNo(deptNo);
        result.put("positions",positions);
        return result;
    }
    @RequestMapping(value = "/user/v3/getPositionByDeptNoAndPosition")
    @ResponseBody
    public Map<String,Object> getPositionByDeptNoAndPosition(@RequestParam("deptNo")long deptNo,HttpSession session){
        Map<String,Object> result=new HashMap<>();
        LoginUser user = (LoginUser) session.getAttribute("user");
        List<Position> positions = positionServiceImp.getpositionByDeptNo(deptNo,user.getAuthid());
        result.put("positions",positions);
        return result;
    }
}
