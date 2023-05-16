// 
// 
// 

package com.esms.controller;

import com.esms.po.Salary;
import java.util.List;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import com.esms.vo.EmployeeSalaryVO;
import org.springframework.web.bind.annotation.RequestParam;
import com.esms.po.Employee;
import com.esms.vo.EmployeeCustomVo;
import com.esms.exception.CustomException;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.esms.utils.MD5Utils;
import com.esms.po.SystemManager;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import com.esms.service.impl.UserInforServiceImpl;
import org.springframework.stereotype.Controller;

@Controller
public class UserInforController
{
    @Autowired
    private UserInforServiceImpl userInforService;
    
    public UserInforController() {
        this.userInforService = null;
    }
    
    @RequestMapping({ "changePassword.do" })
    @ResponseBody
    public Map<String, String> changePassword(final String oldPassword, final String newPassword1, final String newPassword2, final HttpSession httpSession) {
        System.out.println(String.valueOf(oldPassword) + " " + newPassword1 + " " + newPassword2);
        final HashMap<String, String> map = new HashMap<String, String>();
        if (!newPassword1.equals(newPassword2)) {
            map.put("status", "0");
            map.put("msg", "\u6d93\u3086\ue0bc\u7035\u55d9\u721c\u6d93\u5d84\u7af4\u9477\ufffd");
            return map;
        }
        final SystemManager admin = (SystemManager)httpSession.getAttribute("admin");
        final String encodeByMD5 = MD5Utils.encodeByMD5(oldPassword);
        if (encodeByMD5.equals(admin.getSmPassword())) {
            final String newPassword3 = MD5Utils.encodeByMD5(newPassword1);
            admin.setSmPassword(newPassword3);
            this.userInforService.updateSystemManagePassword(admin.getSmId(), admin);
            map.put("status", "1");
            map.put("msg", "\u7035\u55d9\u721c\u6dc7\ue1bd\u657c\u93b4\u612c\u59db");
            return map;
        }
        map.put("status", "2");
        map.put("msg", "\u9358\u71b7\u7611\u942e\u4f80\u654a\u7487\ufffd");
        return map;
    }
    
    @RequestMapping({ "changeEmployeePassword.do" })
    @ResponseBody
    public Map<String, String> changeEmployeePassword(final String oldPassword, final String newPassword1, final String newPassword2, final HttpSession httpSession) {
        System.out.println(String.valueOf(oldPassword) + " " + newPassword1 + " " + newPassword2);
        final HashMap<String, String> map = new HashMap<String, String>();
        if (newPassword1.equals(newPassword2)) {
            final Integer eid = (Integer)httpSession.getAttribute("employeeId");
            try {
                this.userInforService.updateEmployeePassword(eid, oldPassword, newPassword1);
                map.put("status", "1");
                map.put("msg", "\u7035\u55d9\u721c\u6dc7\ue1bd\u657c\u93b4\u612c\u59db");
                return map;
            }
            catch (CustomException e) {
                map.put("status", "2");
                map.put("msg", "\u9358\u71b7\u7611\u942e\u4f80\u654a\u7487\ufffd");
                return map;
            }
        }
        map.put("status", "0");
        map.put("msg", "\u6d93\u3086\ue0bc\u7035\u55d9\u721c\u6d93\u5d84\u7af4\u9477\ufffd");
        return map;
    }
    
    @RequestMapping({ "inforEmployee.do" })
    @ResponseBody
    public EmployeeCustomVo getInforEmployee(final HttpSession httpSession) {
        final Integer id = (Integer)httpSession.getAttribute("employeeId");
        final EmployeeCustomVo employeeCustomVo = this.userInforService.getInforEmployee(id);
        return employeeCustomVo;
    }
    
    @RequestMapping({ "updateInforEmployee.do" })
    @ResponseBody
    public String updateInforEmployee(final HttpSession httpSession, final Employee employee) {
        final Integer id = (Integer)httpSession.getAttribute("employeeId");
        employee.seteId(id);
        final int i = this.userInforService.updateEmploueeById(id, employee);
        if (i == 1) {
            return "1";
        }
        return "0";
    }
    
    @RequestMapping({ "employeeSalaryList.do" })
    @ResponseBody
    public EmployeeSalaryVO findSelective(@RequestParam(value = "page", defaultValue = "1") final int pageNum, @RequestParam(value = "limit", defaultValue = "10") final int limit, @RequestParam(value = "year", defaultValue = "1") final String year, final HttpSession httpSession) throws Exception {
        final Integer eId = (Integer)httpSession.getAttribute("employeeId");
        PageHelper.startPage(pageNum, limit);
        final List<Salary> salaryList = this.userInforService.getEmployeeSalaryList(eId, year);
        final PageInfo pageResult = new PageInfo((List)salaryList);
        final EmployeeSalaryVO employeeSalaryVO = new EmployeeSalaryVO();
        employeeSalaryVO.setCode(0);
        employeeSalaryVO.setMsg("");
        employeeSalaryVO.setCount((int)pageResult.getTotal());
        employeeSalaryVO.setData(pageResult.getList());
        return employeeSalaryVO;
    }
}
