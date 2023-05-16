// 
// 
// 

package com.esms.controller;

import com.esms.vo.EmployeeMonthlyAttendancePages;
import javax.servlet.http.HttpSession;
import com.esms.po.MonthlyAttendance;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import com.esms.vo.MonthlyAttendancePages;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Map;
import java.util.HashMap;
import com.esms.vo.MonthlyAttendanceCustomVo;
import java.util.List;
import com.esms.dao.MonthlyAttendanceMapper;
import com.esms.dao.MonthlyAttendanceCustomVoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.esms.service.impl.MonthlyAttendanceServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping({ "/monthlyattendance" })
public class MonthlyAttendanceController
{
    @Autowired
    private MonthlyAttendanceServiceImpl monthlyAttendanceService;
    @Autowired
    private MonthlyAttendanceCustomVoMapper monthlyAttendanceCustomVoMapper;
    @Autowired
    private MonthlyAttendanceMapper monthlyAttendanceMapper;
    
    public MonthlyAttendanceController() {
        this.monthlyAttendanceCustomVoMapper = null;
        this.monthlyAttendanceMapper = null;
    }
    
    @RequestMapping({ "test.do" })
    @ResponseBody
    public List<MonthlyAttendanceCustomVo> test() {
        final HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("e_account", "4");
        map.put("d_id", 4);
        map.put("attendance_time", "2017-08");
        final List<MonthlyAttendanceCustomVo> monthlyAttendanceCustomVos = this.monthlyAttendanceCustomVoMapper.selectMonthlyAttendanceCustomVoMapperByeAccountAnddIdAndTime(map);
        return monthlyAttendanceCustomVos;
    }
    
    @RequestMapping({ "/findSelective.do" })
    @ResponseBody
    public MonthlyAttendancePages findSelective(@RequestParam(value = "page", defaultValue = "1") final int pageNum, @RequestParam(value = "limit", defaultValue = "5") final int limit, @RequestParam(value = "e_account", defaultValue = "") final String e_account, @RequestParam(value = "d_id", defaultValue = "0") final int d_id, @RequestParam(value = "attendance_time", defaultValue = "") final String attendance_time) throws Exception {
        final HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("e_account", e_account);
        map.put("d_id", d_id);
        map.put("attendance_time", attendance_time);
        PageHelper.startPage(pageNum, limit);
        final List<MonthlyAttendanceCustomVo> list = this.monthlyAttendanceCustomVoMapper.selectMonthlyAttendanceCustomVoMapperByeAccountAnddIdAndTime(map);
        final PageInfo pageResult = new PageInfo((List)list);
        final MonthlyAttendancePages monthlyAttendancePages = new MonthlyAttendancePages();
        monthlyAttendancePages.setCode(0);
        monthlyAttendancePages.setMsg("");
        monthlyAttendancePages.setCount((int)pageResult.getTotal());
        monthlyAttendancePages.setData(pageResult.getList());
        return monthlyAttendancePages;
    }
    
    @RequestMapping({ "/selectVoByPrimaryKey.do" })
    @ResponseBody
    public MonthlyAttendanceCustomVo selectVoByPrimaryKey(final int id) {
        MonthlyAttendanceCustomVo monthlyAttendanceCustomVo = new MonthlyAttendanceCustomVo();
        monthlyAttendanceCustomVo = this.monthlyAttendanceCustomVoMapper.selectVoByPrimaryKey(id);
        return monthlyAttendanceCustomVo;
    }
    
    @RequestMapping({ "/updateByPrimaryKeySelective.do" })
    @ResponseBody
    public int updateByPrimaryKeySelective(final int maId, final int sickLeaveNum, final int compassionateLeaveNum, final double overtimeHour, final double weekendHour, final double holidayHour, final int lateNum, final int earlyNum, final int absenceNum, final int businessTravelNum) throws Exception {
        final MonthlyAttendance monthlyAttendance = new MonthlyAttendance();
        monthlyAttendance.setMaId(maId);
        monthlyAttendance.setSickLeaveNum(sickLeaveNum);
        monthlyAttendance.setCompassionateLeaveNum(compassionateLeaveNum);
        monthlyAttendance.setOvertimeHour(overtimeHour);
        monthlyAttendance.setWeekendHour(weekendHour);
        monthlyAttendance.setHolidayHour(holidayHour);
        monthlyAttendance.setLateNum(lateNum);
        monthlyAttendance.setEarlyNum(earlyNum);
        monthlyAttendance.setAbsenceNum(absenceNum);
        monthlyAttendance.setBusinessTravelNum(businessTravelNum);
        this.monthlyAttendanceService.updateByPrimaryKeySelective(monthlyAttendance);
        return 1;
    }
    
    @RequestMapping({ "/deleteByPrimaryKey.do" })
    @ResponseBody
    public int deleteByPrimaryKey(final int id) throws Exception {
        final MonthlyAttendance monthlyAttendance = new MonthlyAttendance();
        monthlyAttendance.setMaId(id);
        this.monthlyAttendanceService.deleteByPrimaryKey(id);
        return 1;
    }
    
    @RequestMapping({ "/deleteByQuery.do" })
    @ResponseBody
    public int deleteByQuery(@RequestParam("arr") final int[] ids) {
        if (ids.length > 0) {
            this.monthlyAttendanceService.deleteByQuery(ids);
        }
        return 1;
    }
    
    @RequestMapping({ "/findEmployeeAttendance.do" })
    @ResponseBody
    public EmployeeMonthlyAttendancePages findEmployeeAttendance(@RequestParam(value = "page", defaultValue = "1") final int pageNum, @RequestParam(value = "limit", defaultValue = "5") final int limit, @RequestParam(value = "attendance_time", defaultValue = "") final String attendance_time, final HttpSession httpSession) throws Exception {
        final Integer id = (Integer)httpSession.getAttribute("employeeId");
        PageHelper.startPage(pageNum, limit);
        final HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("e_id", id);
        map.put("attendance_time", attendance_time);
        final List<MonthlyAttendance> list = this.monthlyAttendanceMapper.selectMonthlyAttendanceMapperByeEidAndTime(map);
        final PageInfo pageResult = new PageInfo((List)list);
        final EmployeeMonthlyAttendancePages employeeMonthlyAttendancePages = new EmployeeMonthlyAttendancePages();
        employeeMonthlyAttendancePages.setCode(0);
        employeeMonthlyAttendancePages.setMsg("");
        employeeMonthlyAttendancePages.setCount((int)pageResult.getTotal());
        employeeMonthlyAttendancePages.setData(pageResult.getList());
        return employeeMonthlyAttendancePages;
    }
}
