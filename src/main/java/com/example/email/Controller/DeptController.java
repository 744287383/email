package com.example.email.Controller;

import com.example.email.ModelDTO.DraftDTO;
import com.example.email.ModelDTO.LoginUser;
import com.example.email.Service.DeptInfoServiceIMP;
import com.example.email.Service.PositionServiceImp;
import com.example.email.Service.StaffInfoServiceIMP;
import com.example.email.entity.Dept;
import com.example.email.entity.DeptExample;
import com.example.email.entity.Position;
import com.example.email.entity.Staff;
import com.example.email.mapper.DeptMapper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class DeptController {
    @Value("${page.size}")
    private int size;
    @Autowired
    private DeptInfoServiceIMP deptInfoServiceIMP;
    @Autowired
    private StaffInfoServiceIMP staffInfoServiceIMP;
    @Autowired
    private PositionServiceImp positionServiceImp;
    @RequestMapping(value = "/user/admin/getDeptView")
    public String getDraftListView(@RequestParam(required = false,value = "indexPage",defaultValue = "1")int indexPage,
                                   HttpSession session, Model model){
        LoginUser loginUser = (LoginUser) session.getAttribute("user");
        PageInfo<DraftDTO> pageList = deptInfoServiceIMP.getAlLDept(indexPage, size, loginUser);
        model.addAttribute("pageList",pageList);
        return "deptView";
    }
    @RequestMapping(value = "/user/admin/addDept")
    @ResponseBody
    public Map<String,String> addDept(@RequestParam("deptName")String deptName){
        Map<String,String> result=new HashMap<>();

        Dept dept=deptInfoServiceIMP.getDeptByDeptName(deptName);
        if (null!=dept){
            result.put("msg","添加失败，该部门已存在！");
            return result;
        }
        deptInfoServiceIMP.addDept(deptName);
        result.put("msg","添加成功！");
        return result;
    }
    @RequestMapping(value = "/user/admin/deleteDept")
    @ResponseBody
    public Map<String,String> deleteDept(@RequestParam("deptNo")long deptNo){
        Map<String,String> result=new HashMap<>();
        List<Staff> staffs=staffInfoServiceIMP.getStaffListByDeptNo(deptNo);
        if (null!=staffs&&0!=staffs.size()){
            result.put("msg","该部门中还有员工，部门删除失败！");
            return result;
        }

        List<Position> positions=positionServiceImp.getpositionByDeptNo(deptNo);
        if (null!=positions&&0!=positions.size()){
            result.put("msg","该部门中还有职位未被删除，部门删除失败！");
            return result;
        }
        DeptExample deptExample=new DeptExample();
        deptExample.or().andDeptNoEqualTo(deptNo);
        deptInfoServiceIMP.deleteDeptByDeptNo(deptNo);
        result.put("msg","部门删除成功！");
        return result;
    }

    @RequestMapping(value = "/user/admin/updateDept")
    @ResponseBody
    public Map<String,String> updateDept(@RequestParam("deptName")String deptName,
                                         @RequestParam("deptNo")long deptNo){
        Map<String,String> result=new HashMap<>();

        Dept dept=deptInfoServiceIMP.getDeptByDeptNO(deptNo);
        if (null==dept){
            result.put("msg","修改失败，不存在该部门！");
            return result;
        }
        dept=new Dept();
        dept.setDeptName(deptName);
        dept.setDeptNo(deptNo);
        deptInfoServiceIMP.updateDeptByDeptNo(dept);
        result.put("msg","部门修改成功！");
        return result;
    }
}
