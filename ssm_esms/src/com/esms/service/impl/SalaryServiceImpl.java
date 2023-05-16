// 
// 
// 

package com.esms.service.impl;

import java.util.Map;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import java.util.HashMap;
import com.esms.vo.SalaryPages;
import java.util.Date;
import java.text.DateFormat;
import com.esms.po.MonthlyAttendance;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import com.esms.po.Salary;
import java.util.List;
import com.esms.po.Employee;
import com.esms.exception.CustomException;
import com.esms.dao.DepartmentMapper;
import com.esms.dao.KeyValueMapper;
import com.esms.dao.WorkingYearsBonusMapper;
import com.esms.dao.PositionMapper;
import com.esms.dao.RankBonusMapper;
import com.esms.dao.EmployeeMapper;
import com.esms.dao.MonthlyAttendanceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.esms.dao.SalaryMapper;
import org.springframework.stereotype.Service;
import com.esms.service.ISalaryService;

@Service
public class SalaryServiceImpl implements ISalaryService
{
    @Autowired
    private SalaryMapper salaryMapper;
    @Autowired
    private MonthlyAttendanceMapper monthlyAttendanceMapper;
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private RankBonusMapper rankBonusMapper;
    @Autowired
    private PositionMapper positionMapper;
    @Autowired
    private WorkingYearsBonusMapper workingYearsBonusMapper;
    @Autowired
    private KeyValueMapper keyValueMapper;
    @Autowired
    private DepartmentMapper departmentMapper;
    
    public SalaryServiceImpl() {
        this.salaryMapper = null;
        this.monthlyAttendanceMapper = null;
        this.employeeMapper = null;
        this.rankBonusMapper = null;
        this.positionMapper = null;
        this.workingYearsBonusMapper = null;
        this.keyValueMapper = null;
        this.departmentMapper = null;
    }
    
    @Override
    public void insertSalaryByAcountAndDate(final String eAccount, final String date) throws CustomException {
        Employee employee = null;
        employee = this.employeeMapper.selectByAccount(eAccount);
        if (employee == null) {
            throw new CustomException("\u59dd\u3085\u4f10\u9359\u8702\u7b09\u701b\u6a3a\u6e6a");
        }
        if (this.salaryMapper.selectByEidAndTimeAndStatus(employee.geteId(), date, 1) != null) {
            throw new CustomException("\u93c8\ue100\u4f10\u9359\u98ce\u6b91\u59dd\u3086\u6e40\u5bb8\u30e8\u796b\u5bb8\u63d2\u5f42\u93c0\u6485\u7d1d\u6d93\u5d88\u5158\u9366\u3127\u7ca8\u7ee0\ufffd");
        }
        this.insertSalay(employee, date);
    }
    
    @Override
    public void insertSalaryAllByDate(final String date) throws CustomException {
        final List<Salary> salaryList = this.salaryMapper.selectByeTimeAndStatus(date, 1);
        if (salaryList.size() >= 1) {
            throw new CustomException("\u59dd\u3086\u6e40\u5bb8\u30e8\u796b\u5bb8\u63d2\u5f42\u93c0\ufffd,\u6d93\u5d88\u5158\u9366\u3128\u7e58\u741b\u5c7d\u4f10\u74a7\u52ed\u7ca8\u7ee0\ufffd");
        }
        List<Employee> employeeList = null;
        employeeList = this.employeeMapper.selectAll();
        for (final Employee employee : employeeList) {
            this.insertSalay(employee, date);
        }
    }
    
    private void insertSalay(final Employee employee, final String date) {
        final MonthlyAttendance monthlyAttendance = this.monthlyAttendanceMapper.selectByeIdAndDate(employee.geteId(), date);
        final Salary salarySelect = this.salaryMapper.selectByEidAndTimeAndStatus(employee.geteId(), date, 0);
        final Salary salary = new Salary();
        final DateFormat format1 = new SimpleDateFormat("yyyy-MM");
        Date dateNew = null;
        salary.setEmployee(employee);
        salary.setDepartment(this.departmentMapper.selectByPrimaryKey(employee.getdId()));
        try {
            dateNew = format1.parse(date);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        salary.setsTime(dateNew);
        final Double basePay = employee.geteBasePay();
        salary.setBasePay(basePay);
        if (monthlyAttendance != null) {
            final double late_buckle_pay = this.keyValueMapper.selectBykvKey("late_buckle_pay").getKvValue();
            final double early_buckle_pay = this.keyValueMapper.selectBykvKey("early_buckle_pay").getKvValue();
            final double missionallowance = this.keyValueMapper.selectBykvKey("missionallowance").getKvValue();
            final double full_attendance_pay = this.keyValueMapper.selectBykvKey("full_attendance_pay").getKvValue();
            salary.setLatePay(monthlyAttendance.getLateNum() * late_buckle_pay);
            salary.setEarlyPay(monthlyAttendance.getEarlyNum() * early_buckle_pay);
            final double x = basePay / 21.75 / 8.0;
            final double overTimePay = x * monthlyAttendance.getOvertimeHour() * 1.5 + x * monthlyAttendance.getWeekendHour() * 2.0 + x * monthlyAttendance.getHolidayHour() * 3.0;
            salary.setOvertimePay(overTimePay);
            if (monthlyAttendance.getSickLeaveNum() > 3) {
                salary.setSickPay((monthlyAttendance.getSickLeaveNum() - 3) * -30.0);
            }
            else {
                salary.setSickPay(0.0);
            }
            if (monthlyAttendance.getSickLeaveNum() > 2) {
                salary.setThingPay((monthlyAttendance.getCompassionateLeaveNum() - 2) * -50.0);
            }
            else {
                salary.setThingPay(0.0);
            }
            salary.setBusinessTravelPay(monthlyAttendance.getCompassionateLeaveNum() * missionallowance);
            if (monthlyAttendance.getAbsenceNum() < 1) {
                salary.setFullAttendancePay(full_attendance_pay);
            }
            else {
                salary.setFullAttendancePay(0.0);
            }
        }
        else {
            salary.setLatePay(0.0);
            salary.setEarlyPay(0.0);
            salary.setOvertimePay(0.0);
            salary.setSickPay(0.0);
            salary.setThingPay(0.0);
            salary.setBusinessTravelPay(0.0);
            salary.setFullAttendancePay(0.0);
        }
        final double food_pay = this.keyValueMapper.selectBykvKey("food_pay").getKvValue();
        final double traffic_pay = this.keyValueMapper.selectBykvKey("traffic_pay").getKvValue();
        salary.setFoodPay(food_pay);
        salary.setTrafficPay(traffic_pay);
        salary.setPostPay(this.positionMapper.selectByPrimaryKey(employee.getpId()).getpPostPay());
        salary.setRankPay((double)this.rankBonusMapper.selectByPrimaryKey(employee.geteRank()).getRbBonus());
        final long datesum = dateNew.getTime() - employee.geteEntryTime().getTime();
        final int years = (int)(datesum / 31536000L / 1000L);
        try {
            salary.setWorkingYearPay(this.workingYearsBonusMapper.findByYear(years).getWybBonus());
        }
        catch (Exception e2) {
            salary.setWorkingYearPay(0.0);
        }
        salary.setPersionPay(-(basePay * 0.08));
        salary.setMedicalPay(-(basePay * 0.02 + 10.0));
        salary.setUnemploymentPay(-(basePay * 0.01));
        salary.setInjuryPay(0.0);
        salary.setBirthPay(0.0);
        salary.setHousingPay(-(basePay * 0.08));
        if (salarySelect != null) {
            salary.setRissuePay(salarySelect.getRissuePay());
        }
        else {
            salary.setRissuePay(0.0);
        }
        final double shouldPay = salary.getBasePay() + salary.getFoodPay() + salary.getPostPay() + salary.getWorkingYearPay() + salary.getRankPay() + salary.getTrafficPay() + salary.getOvertimePay() + salary.getBusinessTravelPay() + salary.getFullAttendancePay() + salary.getRissuePay();
        final double insurances = salary.getPersionPay() + salary.getMedicalPay() + salary.getUnemploymentPay() + salary.getInjuryPay() + salary.getBirthPay() + salary.getHousingPay();
        final double attendance = salary.getLatePay() + salary.getEarlyPay() + salary.getSickPay() + salary.getThingPay();
        double incomeTax = 0.0;
        final double taxable = shouldPay + insurances + attendance - salary.getBusinessTravelPay() - 3500.0;
        if (0.0 < taxable && taxable <= 1500.0) {
            incomeTax = taxable * 0.03;
        }
        else if (1500.0 < taxable && taxable <= 4500.0) {
            incomeTax = taxable * 0.1 - 105.0;
        }
        else if (4500.0 < taxable && taxable <= 9000.0) {
            incomeTax = taxable * 0.2 - 555.0;
        }
        else if (9000.0 < taxable && taxable <= 35000.0) {
            incomeTax = taxable * 0.25 - 1005.0;
        }
        else if (35000.0 < taxable && taxable <= 55000.0) {
            incomeTax = taxable * 0.3 - 2755.0;
        }
        else if (55000.0 < taxable && taxable <= 80000.0) {
            incomeTax = taxable * 0.35 - 5505.0;
        }
        else if (80000.0 < taxable) {
            incomeTax = taxable * 0.45 - 13505.0;
        }
        salary.setIndividualIncomeTax(-incomeTax);
        salary.setShouldPay(shouldPay);
        salary.setActualPay(shouldPay + insurances + attendance - incomeTax);
        salary.setsState(0);
        if (salarySelect != null) {
            salary.setsId(salarySelect.getsId());
            this.salaryMapper.updateByPrimaryKeySelective(salary);
        }
        else {
            this.salaryMapper.insertSelective(salary);
        }
    }
    
    @Override
    public SalaryPages selectSalaryByEaccountDIdDate(final Integer pageNum, final Integer limit, final String eAccount, final Integer dId, final String sTime) {
        final Map<String, Object> map = new HashMap<String, Object>();
        map.put("eAccount", eAccount);
        map.put("dId", dId);
        map.put("sTime", sTime);
        PageHelper.startPage((int)pageNum, (int)limit);
        final List<Salary> salaries = this.salaryMapper.selectByEaccountDIdDate(map);
        final PageInfo pageResult = new PageInfo((List)salaries);
        return new SalaryPages(0, "", (int)pageResult.getTotal(), pageResult.getList());
    }
    
    @Override
    public void deleteSalaryByEid(final int[] ids) {
        for (final int i : ids) {
            this.salaryMapper.deleteByPrimaryKey(i);
        }
    }
    
    @Override
    public void updateSalaryBySid(final int[] ids) {
        final Salary salary = new Salary();
        for (final int i : ids) {
            salary.setsId(i);
            salary.setsState(1);
            this.salaryMapper.updateByPrimaryKeySelective(salary);
        }
    }
    
    @Override
    public SalaryPages selectSalaryByEaccountDIdDateState(final int pageNum, final int limit, final String eAccount, final Integer dId, final String sTime) {
        final Map<String, Object> map = new HashMap<String, Object>();
        map.put("eAccount", eAccount);
        map.put("dId", dId);
        map.put("sTime", sTime);
        PageHelper.startPage(pageNum, limit);
        final List<Salary> salaries = this.salaryMapper.selectByEaccountDIdDateState(map);
        final PageInfo pageResult = new PageInfo((List)salaries);
        return new SalaryPages(0, "", (int)pageResult.getTotal(), pageResult.getList());
    }
    
    @Override
    public void updateSalaryByEidAndRissuePay(final int sId, final double rissuePay) {
        final Salary salary = this.salaryMapper.selectByPrimaryKey(sId);
        salary.setRissuePay(rissuePay);
        final double shouldPay = salary.getBasePay() + salary.getFoodPay() + salary.getPostPay() + salary.getWorkingYearPay() + salary.getRankPay() + salary.getTrafficPay() + salary.getOvertimePay() + salary.getBusinessTravelPay() + salary.getFullAttendancePay() + salary.getRissuePay();
        final double insurances = salary.getPersionPay() + salary.getMedicalPay() + salary.getUnemploymentPay() + salary.getInjuryPay() + salary.getBirthPay() + salary.getHousingPay();
        final double attendance = salary.getLatePay() + salary.getEarlyPay() + salary.getSickPay() + salary.getThingPay();
        double incomeTax = 0.0;
        final double taxable = shouldPay + insurances + attendance - salary.getBusinessTravelPay() - 3500.0;
        if (0.0 < taxable && taxable <= 1500.0) {
            incomeTax = taxable * 0.03;
        }
        else if (1500.0 < taxable && taxable <= 4500.0) {
            incomeTax = taxable * 0.1 - 105.0;
        }
        else if (4500.0 < taxable && taxable <= 9000.0) {
            incomeTax = taxable * 0.2 - 555.0;
        }
        else if (9000.0 < taxable && taxable <= 35000.0) {
            incomeTax = taxable * 0.25 - 1005.0;
        }
        else if (35000.0 < taxable && taxable <= 55000.0) {
            incomeTax = taxable * 0.3 - 2755.0;
        }
        else if (55000.0 < taxable && taxable <= 80000.0) {
            incomeTax = taxable * 0.35 - 5505.0;
        }
        else if (80000.0 < taxable) {
            incomeTax = taxable * 0.45 - 13505.0;
        }
        salary.setIndividualIncomeTax(-incomeTax);
        salary.setShouldPay(shouldPay);
        salary.setActualPay(shouldPay + insurances + attendance - incomeTax);
        this.salaryMapper.updateByPrimaryKeySelective(salary);
    }
}
