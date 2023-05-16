// 
// 
// 

package com.esms.controller;

import java.util.Date;
import com.esms.utils.MD5Utils;
import com.esms.po.Employee;
import java.text.SimpleDateFormat;
import org.springframework.web.bind.annotation.ResponseBody;
import com.esms.vo.EmployeeCustomVo;
import java.util.List;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import java.util.HashMap;
import com.esms.vo.EmployeePages;
import org.springframework.web.bind.annotation.RequestParam;
import com.esms.dao.EmployeeCustomVoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.esms.service.EmployeeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping({ "/employee" })
public class EmployeeController
{
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmployeeCustomVoMapper employeeCustomVoMapper;
    
    public EmployeeController() {
        this.employeeCustomVoMapper = null;
    }
    
    @RequestMapping({ "/findSelective.do" })
    @ResponseBody
    public EmployeePages findSelective(@RequestParam(value = "page", defaultValue = "1") final int pageNum, @RequestParam(value = "limit", defaultValue = "5") final int limit, @RequestParam(value = "e_account", defaultValue = "") final String e_account, @RequestParam(value = "e_name", defaultValue = "") final String e_name, @RequestParam(value = "d_id", defaultValue = "0") final int d_id) throws Exception {
        final HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("e_account", e_account);
        map.put("e_name", e_name);
        map.put("d_id", d_id);
        PageHelper.startPage(pageNum, limit);
        final List<EmployeeCustomVo> list = this.employeeCustomVoMapper.selectEmployeeSelective(map);
        final PageInfo pageResult = new PageInfo((List)list);
        final EmployeePages employeePages = new EmployeePages();
        employeePages.setCode(0);
        employeePages.setMsg("");
        employeePages.setCount((int)pageResult.getTotal());
        employeePages.setData(pageResult.getList());
        return employeePages;
    }
    
    @RequestMapping({ "/selectVoByPrimaryKey.do" })
    @ResponseBody
    public EmployeeCustomVo selectVoByPrimaryKey(final int id) {
        EmployeeCustomVo monthlyAttendanceCustomVo = new EmployeeCustomVo();
        monthlyAttendanceCustomVo = this.employeeCustomVoMapper.selectVoByPrimaryKey(id);
        return monthlyAttendanceCustomVo;
    }
    
    @RequestMapping({ "/add.do" })
    @ResponseBody
    public int add(final String eAccount, final String eName, final String ePassword, final String eIdcard, final int rbId, final String eSex, final String eBirthday, final String eDagree, final int dId, final int pId, final String eEntryTime, final double eBasePay, final String ePhone, final String eEmail, final String eUrgentPerson, final String eUrgentPhone, final String eHometown, final String headPath) throws Exception {
        final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        final Employee e = this.employeeService.findByeAccount(eAccount);
        if (e != null) {
            return 0;
        }
        final Employee employee = new Employee();
        employee.seteAccount(eAccount);
        employee.seteName(eName);
        employee.setePassword(MD5Utils.encodeByMD5(ePassword));
        employee.seteIdcard(eIdcard);
        employee.seteRank(rbId);
        employee.seteSex(eSex);
        employee.seteBirthday(format.parse(eBirthday));
        employee.seteDagree(eDagree);
        employee.setdId(dId);
        employee.setpId(pId);
        employee.seteEntryTime(format.parse(eEntryTime));
        employee.seteBasePay(eBasePay);
        employee.setePhone(ePhone);
        employee.seteEmail(eEmail);
        employee.seteUrgentPerson(eUrgentPerson);
        employee.seteUrgentPhone(eUrgentPhone);
        employee.seteHometown(eHometown);
        employee.seteHeadPath(headPath);
        employee.seteIsdel(1);
        this.employeeService.insert(employee);
        return 1;
    }
    
    @RequestMapping({ "/updateByPrimaryKeySelective.do" })
    @ResponseBody
    public int updateByPrimaryKeySelective(final int eId, final String eName, final String eIdcard, final int rbId, final String eSex, final String eBirthday, final String eDagree, final int dId, final int pId, final String eEntryTime, final double eBasePay, final String ePhone, final String eEmail, final String eUrgentPerson, final String eUrgentPhone, final String eHometown, final String headPath) throws Exception {
        final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        final Employee employee = new Employee();
        employee.seteId(eId);
        employee.seteName(eName);
        employee.seteIdcard(eIdcard);
        employee.seteRank(rbId);
        employee.seteSex(eSex);
        employee.seteBirthday(format.parse(eBirthday));
        employee.seteDagree(eDagree);
        employee.setdId(dId);
        employee.setpId(pId);
        employee.seteEntryTime(format.parse(eEntryTime));
        employee.seteBasePay(eBasePay);
        employee.setePhone(ePhone);
        employee.seteEmail(eEmail);
        employee.seteUrgentPerson(eUrgentPerson);
        employee.seteUrgentPhone(eUrgentPhone);
        employee.seteHometown(eHometown);
        employee.seteHeadPath(headPath);
        employee.seteIsdel(1);
        this.employeeService.updateByPrimaryKeySelective(employee);
        return 1;
    }
    
    @RequestMapping({ "/deleteByPrimaryKey.do" })
    @ResponseBody
    public int deleteByPrimaryKey(final int id) throws Exception {
        final Employee employee = new Employee();
        employee.seteId(id);
        employee.seteLeaveTime(new Date());
        employee.seteIsdel(0);
        this.employeeService.updateByPrimaryKeySelective(employee);
        return 1;
    }
    
    @RequestMapping({ "/deleteByQuery.do" })
    @ResponseBody
    public int deleteByQuery(@RequestParam("arr") final int[] ids) {
        if (ids.length > 0) {
            this.employeeService.deleteByQuery(ids);
        }
        return 1;
    }
}
