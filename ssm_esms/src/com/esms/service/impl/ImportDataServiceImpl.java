// 
// 
// 

package com.esms.service.impl;

import com.esms.po.Salary;
import java.text.DateFormat;
import java.util.Iterator;
import java.util.List;
import java.text.SimpleDateFormat;
import com.esms.po.MonthlyAttendance;
import com.esms.utils.JXLUtils;
import java.io.IOException;
import java.io.File;
import org.springframework.web.multipart.MultipartFile;
import com.esms.dao.EmployeeMapper;
import com.esms.dao.SalaryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.esms.dao.MonthlyAttendanceMapper;
import org.springframework.stereotype.Service;
import com.esms.service.IImportDataService;

@Service
public class ImportDataServiceImpl implements IImportDataService
{
    @Autowired
    private MonthlyAttendanceMapper monthlyAttendanceMapper;
    @Autowired
    private SalaryMapper salaryMapper;
    @Autowired
    private EmployeeMapper employeeMapper;
    
    @Override
    public String insertMATable(final MultipartFile excel) throws Exception {
        final String fileName = excel.getOriginalFilename();
        if (fileName.endsWith(".xls")) {
            final String path = "D://ESMSexcel/monthly_attendance_table/";
            final File fileDirectory = new File(path);
            if (!fileDirectory.exists()) {
                fileDirectory.mkdirs();
            }
            final File file = new File(path, fileName);
            try {
                excel.transferTo(file);
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            final List<MonthlyAttendance> monthlyAttendanceList = JXLUtils.readMonthlyAttendanceTable(file);
            for (final MonthlyAttendance temp : monthlyAttendanceList) {
                final Integer count = this.employeeMapper.isExistEmployee(temp.getEmployee().geteAccount());
                if (count == 0) {
                    return "\u6d93\u5d85\u74e8\u9366\u3125\u61b3\u5bb8\u30e5\u4f10\u9359\u8702\u8d1f" + temp.getEmployee().geteAccount() + "\u951b\u5c83\ue1ec\u59ab\ufffd\u93cc\u30e5\ue1f1\u934f\u30e7\u6b91excel\u93c2\u56e6\u6b22";
                }
            }
            final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
            for (final MonthlyAttendance temp2 : monthlyAttendanceList) {
                final int eId = this.employeeMapper.selectEidByEaccount(temp2.getEmployee().geteAccount());
                temp2.getEmployee().seteId(eId);
                MonthlyAttendance mon = new MonthlyAttendance();
                mon = this.monthlyAttendanceMapper.selectByeIdAndDate(temp2.getEmployee().geteId(), dateFormat.format(temp2.getAttendanceTime()));
                if (mon == null) {
                    this.monthlyAttendanceMapper.insert(temp2);
                }
                else {
                    temp2.setMaId(mon.getMaId());
                    this.monthlyAttendanceMapper.updateByPrimaryKeySelective(temp2);
                }
            }
            return "\u7035\u714e\u53c6\u93b4\u612c\u59db";
        }
        return "\u9359\ue047\u5158\u7035\u714e\u53c6Microsoft Excel 97-2003 \u5bb8\u30e4\u7d94\u741b\ufffd (.xls)\u951b\u5c83\ue1ec\u59ab\ufffd\u93cc\u30e6\u6783\u6d60\u8235\u69f8\u935a\ufe3d\ue11c\u7ead\ufffd";
    }
    
    @Override
    public String insertReissueTable(final MultipartFile excel) throws Exception {
        final String fileName = excel.getOriginalFilename();
        if (fileName.endsWith(".xls")) {
            final String path = "D://ESMSexcel/monthly_reissue_table/";
            final File fileDirectory = new File(path);
            if (!fileDirectory.exists()) {
                fileDirectory.mkdirs();
            }
            final File file = new File(path, fileName);
            try {
                excel.transferTo(file);
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
            final List<Salary> salaryList = JXLUtils.readReissueTable(file);
            for (final Salary salary : salaryList) {
                final Integer count = this.employeeMapper.isExistEmployee(salary.getEmployee().geteAccount());
                if (count == 0) {
                    return "\u6d93\u5d85\u74e8\u9366\u3125\u61b3\u5bb8\u30e5\u4f10\u9359\u8702\u8d1f" + salary.getEmployee().geteAccount() + "\u951b\u5c83\ue1ec\u59ab\ufffd\u93cc\u30e5\ue1f1\u934f\u30e7\u6b91excel\u93c2\u56e6\u6b22";
                }
            }
            for (final Salary salary : salaryList) {
                final int eId = this.employeeMapper.selectEidByEaccount(salary.getEmployee().geteAccount());
                salary.getEmployee().seteId(eId);
                final Salary temp = this.salaryMapper.selectByEidAndTimeAndStatus(salary.getEmployee().geteId(), dateFormat.format(salary.getsTime()), 0);
                if (temp == null) {
                    salary.setBasePay(0.0);
                    salary.setFoodPay(0.0);
                    salary.setPostPay(0.0);
                    salary.setWorkingYearPay(0.0);
                    salary.setRankPay(0.0);
                    salary.setTrafficPay(0.0);
                    salary.setOvertimePay(0.0);
                    salary.setBusinessTravelPay(0.0);
                    salary.setFullAttendancePay(0.0);
                    salary.setPersionPay(0.0);
                    salary.setMedicalPay(0.0);
                    salary.setUnemploymentPay(0.0);
                    salary.setInjuryPay(0.0);
                    salary.setBirthPay(0.0);
                    salary.setHousingPay(0.0);
                    salary.setLatePay(0.0);
                    salary.setEarlyPay(0.0);
                    salary.setSickPay(0.0);
                    salary.setThingPay(0.0);
                    salary.setIndividualIncomeTax(0.0);
                    salary.setShouldPay(0.0);
                    salary.setActualPay(0.0);
                    salary.setsState(0);
                    this.salaryMapper.insertSelective(salary);
                }
                else {
                    salary.setsId(temp.getsId());
                    final double shouldPay = temp.getBasePay() + temp.getFoodPay() + temp.getPostPay() + temp.getWorkingYearPay() + temp.getRankPay() + temp.getTrafficPay() + temp.getOvertimePay() + temp.getBusinessTravelPay() + temp.getFullAttendancePay() + salary.getRissuePay();
                    final double insurances = temp.getPersionPay() + temp.getMedicalPay() + temp.getUnemploymentPay() + temp.getInjuryPay() + temp.getBirthPay() + temp.getHousingPay();
                    final double attendance = temp.getLatePay() + temp.getEarlyPay() + temp.getSickPay() + temp.getThingPay();
                    double incomeTax = 0.0;
                    final double taxable = shouldPay + insurances + attendance - temp.getBusinessTravelPay() - 3500.0;
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
            return "\u7035\u714e\u53c6\u93b4\u612c\u59db";
        }
        return "\u9359\ue047\u5158\u7035\u714e\u53c6Microsoft Excel 97-2003 \u5bb8\u30e4\u7d94\u741b\ufffd (.xls)\u951b\u5c83\ue1ec\u59ab\ufffd\u93cc\u30e6\u6783\u6d60\u8235\u69f8\u935a\ufe3d\ue11c\u7ead\ufffd";
    }
}
