// 
// 
// 

package com.esms.service.impl;

import java.util.Date;
import java.text.SimpleDateFormat;
import com.esms.vo.EchMonthSalary;
import com.esms.vo.EchSalaryPercent;
import com.esms.vo.EchSalary;
import com.esms.vo.EchDepartmentSalary;
import java.util.Iterator;
import com.esms.po.Department;
import java.util.HashMap;
import java.util.ArrayList;
import com.esms.vo.EchEmployeeNums;
import java.util.List;
import java.util.Map;
import com.esms.dao.SalaryMapper;
import com.esms.dao.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.esms.dao.DepartmentMapper;
import org.springframework.stereotype.Service;
import com.esms.service.IEchartsService;

@Service
public class EchartsServiceImpl implements IEchartsService
{
    @Autowired
    private DepartmentMapper departmentMapper;
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private SalaryMapper salaryMapper;
    
    @Override
    public Map<String, List<EchEmployeeNums>> getEmployeeNums() {
        final List<EchEmployeeNums> echEmployeeNumsList = new ArrayList<EchEmployeeNums>();
        final Map<String, List<EchEmployeeNums>> map = new HashMap<String, List<EchEmployeeNums>>();
        final List<Department> departmentList = this.departmentMapper.selectAll();
        int nums = 0;
        for (final Department department : departmentList) {
            nums = this.employeeMapper.countByDid(department.getdId());
            final EchEmployeeNums echEmployeeNums = new EchEmployeeNums();
            echEmployeeNums.setDepartment(department.getdName());
            echEmployeeNums.setNum(nums);
            echEmployeeNumsList.add(echEmployeeNums);
            nums = 0;
        }
        map.put("list", echEmployeeNumsList);
        return map;
    }
    
    @Override
    public Map<String, List<EchDepartmentSalary>> getDepartmentSalary(final String date) {
        final List<EchDepartmentSalary> echDepartmentSalaryList = new ArrayList<EchDepartmentSalary>();
        final Map<String, List<EchDepartmentSalary>> stringListMap = new HashMap<String, List<EchDepartmentSalary>>();
        final List<Department> departmentList = this.departmentMapper.selectAll();
        for (final Department department : departmentList) {
            final EchDepartmentSalary echDepartmentSalary = new EchDepartmentSalary();
            echDepartmentSalary.setDepartment(department.getdName());
            EchSalary echSalary = this.salaryMapper.selectSalaryByDepartment(department.getdId(), date);
            if (echSalary == null) {
                echSalary = new EchSalary(0.0, 0.0, 0.0);
            }
            final List<Double> salary = new ArrayList<Double>();
            salary.add(echSalary.getMinSalary());
            salary.add(echSalary.getAvgSalary());
            salary.add(echSalary.getMaxSalary());
            echDepartmentSalary.setSalary(salary);
            echDepartmentSalaryList.add(echDepartmentSalary);
        }
        stringListMap.put("list", echDepartmentSalaryList);
        return stringListMap;
    }
    
    @Override
    public Map<String, List<EchSalaryPercent>> getSalaryPercent(final String date, final int state) {
        final List<EchSalaryPercent> echSalaryPercentList = new ArrayList<EchSalaryPercent>();
        final Map<String, List<EchSalaryPercent>> map = new HashMap<String, List<EchSalaryPercent>>();
        final List<Department> departmentList = this.departmentMapper.selectAll();
        for (final Department department : departmentList) {
            final EchSalaryPercent echSalaryPercent = new EchSalaryPercent();
            echSalaryPercent.setDepartment(department.getdName());
            Double allSalary = 0.0;
            if (state == 0) {
                allSalary = this.salaryMapper.selectAllSalaryByDepartment(department.getdId(), date);
            }
            else {
                allSalary = this.salaryMapper.selectAllSalaryByDepAndYear(department.getdId(), date);
            }
            if (allSalary == null) {
                allSalary = 0.0;
            }
            echSalaryPercent.setSalary(allSalary);
            echSalaryPercentList.add(echSalaryPercent);
        }
        map.put("list", echSalaryPercentList);
        return map;
    }
    
    @Override
    public Map<String, List<EchMonthSalary>> getMonthSalary() {
        final List<EchMonthSalary> echMonthSalaryList = new ArrayList<EchMonthSalary>();
        final Map<String, List<EchMonthSalary>> stringListMap = new HashMap<String, List<EchMonthSalary>>();
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        final Integer year = Integer.parseInt(sdf.format(new Date()));
        String date = null;
        for (int i = year - 2; i <= year; ++i) {
            final EchMonthSalary echMonthSalary = new EchMonthSalary();
            echMonthSalary.setYear(String.valueOf(i) + "\u9a9e\ufffd");
            final List<Double> salary = new ArrayList<Double>();
            for (int month = 1; month <= 12; ++month) {
                if (month < 10) {
                    date = String.valueOf(i) + "-0" + month;
                }
                else {
                    date = String.valueOf(i) + "-" + month;
                }
                Double ymSalary = this.salaryMapper.selectAllSalaryByDate(date);
                if (ymSalary == null) {
                    ymSalary = 0.0;
                }
                salary.add(ymSalary);
            }
            echMonthSalary.setSalary(salary);
            echMonthSalaryList.add(echMonthSalary);
        }
        stringListMap.put("list", echMonthSalaryList);
        return stringListMap;
    }
}
