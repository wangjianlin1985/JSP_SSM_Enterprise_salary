// 
// 
// 

package com.esms.controller;

import com.esms.vo.EchMonthSalary;
import com.esms.vo.EchSalaryPercent;
import com.esms.vo.EchDepartmentSalary;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.esms.vo.EchEmployeeNums;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import com.esms.service.IEchartsService;
import org.springframework.stereotype.Controller;

@Controller
public class EchartsController
{
    @Autowired
    private IEchartsService echartsService;
    
    @RequestMapping({ "/showEmployeeNums.do" })
    @ResponseBody
    public Map<String, List<EchEmployeeNums>> showEmployeeNums() {
        return this.echartsService.getEmployeeNums();
    }
    
    @RequestMapping({ "/showDepartmentSalary.do" })
    @ResponseBody
    public Map<String, List<EchDepartmentSalary>> showDepartmentSalary(final String date) {
        return this.echartsService.getDepartmentSalary(date);
    }
    
    @RequestMapping({ "/showSalaryPercent.do" })
    @ResponseBody
    public Map<String, List<EchSalaryPercent>> showSalaryPercent(final String date, final int state) {
        return this.echartsService.getSalaryPercent(date, state);
    }
    
    @RequestMapping({ "/showMonthSalary.do" })
    @ResponseBody
    public Map<String, List<EchMonthSalary>> showMonthSalary() {
        return this.echartsService.getMonthSalary();
    }
}
