// 
// 
// 

package com.esms.utils;

import jxl.write.WriteException;
import java.util.Iterator;
import jxl.write.WritableSheet;
import jxl.write.Number;
import jxl.write.DateTime;
import jxl.write.DateFormats;
import jxl.write.WritableCell;
import jxl.format.CellFormat;
import jxl.write.Label;
import jxl.format.Colour;
import jxl.write.BorderLineStyle;
import jxl.write.Border;
import jxl.write.VerticalAlignment;
import jxl.write.Alignment;
import jxl.write.WritableCellFormat;
import jxl.write.WritableWorkbook;
import java.io.OutputStream;
import com.esms.po.Salary;
import java.util.Date;
import jxl.Cell;
import jxl.Sheet;
import jxl.DateCell;
import com.esms.po.Employee;
import java.util.ArrayList;
import jxl.read.biff.BiffException;
import java.io.IOException;
import jxl.Workbook;
import com.esms.po.MonthlyAttendance;
import java.util.List;
import java.io.File;

public class JXLUtils
{
    public static List<MonthlyAttendance> readMonthlyAttendanceTable(final File file) throws Exception {
        Workbook workbook = null;
        try {
            workbook = Workbook.getWorkbook(file);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (BiffException e2) {
            e2.printStackTrace();
        }
        final Sheet sheet = workbook.getSheet(0);
        final List<MonthlyAttendance> monthlyAttendanceList = new ArrayList<MonthlyAttendance>();
        for (int i = 1; i < sheet.getRows(); ++i) {
            final MonthlyAttendance monthlyAttendance = new MonthlyAttendance();
            for (int j = 1; j < sheet.getColumns(); ++j) {
                final Cell cell = sheet.getCell(j, i);
                switch (j) {
                    case 1: {
                        final Employee employee = new Employee();
                        employee.seteAccount(cell.getContents());
                        monthlyAttendance.setEmployee(employee);
                        break;
                    }
                    case 2: {
                        monthlyAttendance.setSickLeaveNum(Integer.parseInt(cell.getContents()));
                        break;
                    }
                    case 3: {
                        monthlyAttendance.setOvertimeHour(Double.parseDouble(cell.getContents()));
                        break;
                    }
                    case 4: {
                        monthlyAttendance.setWeekendHour(Double.parseDouble(cell.getContents()));
                        break;
                    }
                    case 5: {
                        monthlyAttendance.setHolidayHour(Double.parseDouble(cell.getContents()));
                        break;
                    }
                    case 6: {
                        try {
                            monthlyAttendance.setLateNum(Integer.parseInt(cell.getContents().replace(" ", "")));
                        }
                        catch (Exception e3) {
                            e3.printStackTrace();
                            monthlyAttendance.setLateNum(0);
                        }
                        break;
                    }
                    case 7: {
                        try {
                            monthlyAttendance.setEarlyNum(Integer.parseInt(cell.getContents().replace(" ", "")));
                        }
                        catch (Exception e3) {
                            e3.printStackTrace();
                            monthlyAttendance.setEarlyNum(0);
                        }
                        break;
                    }
                    case 8: {
                        try {
                            monthlyAttendance.setAbsenceNum(Integer.parseInt(cell.getContents().replace(" ", "")));
                        }
                        catch (Exception e3) {
                            e3.printStackTrace();
                            monthlyAttendance.setAbsenceNum(0);
                        }
                        break;
                    }
                    case 9: {
                        try {
                            monthlyAttendance.setCompassionateLeaveNum(Integer.parseInt(cell.getContents().replace(" ", "")));
                        }
                        catch (Exception e3) {
                            e3.printStackTrace();
                            monthlyAttendance.setCompassionateLeaveNum(0);
                        }
                        break;
                    }
                    case 10: {
                        try {
                            monthlyAttendance.setBusinessTravelNum(Integer.parseInt(cell.getContents().replace(" ", "")));
                        }
                        catch (Exception e3) {
                            e3.printStackTrace();
                            monthlyAttendance.setBusinessTravelNum(0);
                        }
                        break;
                    }
                    case 11: {
                        final DateCell dc = (DateCell)cell;
                        final Date date = dc.getDate();
                        monthlyAttendance.setAttendanceTime(date);
                        break;
                    }
                }
            }
            monthlyAttendanceList.add(monthlyAttendance);
        }
        workbook.close();
        return monthlyAttendanceList;
    }
    
    public static List<Salary> readReissueTable(final File file) {
        Workbook workbook = null;
        try {
            workbook = Workbook.getWorkbook(file);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (BiffException e2) {
            e2.printStackTrace();
        }
        final Sheet sheet = workbook.getSheet(0);
        System.out.println("\u741b\u5c8b\u7d30" + sheet.getRows());
        System.out.println("\u9352\u694b\u7d30" + sheet.getColumns());
        final List<Salary> salaryList = new ArrayList<Salary>();
        for (int i = 1; i < sheet.getRows(); ++i) {
            final Salary salary = new Salary();
            for (int j = 1; j < sheet.getColumns(); ++j) {
                final Cell cell = sheet.getCell(j, i);
                System.out.print(String.valueOf(cell.getContents()) + " ");
                switch (j) {
                    case 1: {
                        final Employee employee = new Employee();
                        employee.seteAccount(cell.getContents());
                        salary.setEmployee(employee);
                        break;
                    }
                    case 2: {
                        salary.setRissuePay(Double.parseDouble(cell.getContents()));
                        break;
                    }
                    case 3: {
                        final DateCell dc = (DateCell)cell;
                        final Date date = dc.getDate();
                        salary.setsTime(date);
                        break;
                    }
                }
            }
            System.out.println(salary);
            salaryList.add(salary);
        }
        workbook.close();
        return salaryList;
    }
    
    public static WritableWorkbook createSalaryExcel(final OutputStream output, final List<Salary> salaries) throws IOException, WriteException {
        final WritableWorkbook writableWorkbook = Workbook.createWorkbook(output);
        final WritableSheet sheet = writableWorkbook.createSheet("\u5bb8\u30e8\u796b\u741b\ufffd", 0);
        final CellFormat cf = writableWorkbook.getSheet(0).getCell(1, 0).getCellFormat();
        final WritableCellFormat wc = new WritableCellFormat();
        wc.setAlignment(Alignment.CENTRE);
        wc.setVerticalAlignment(VerticalAlignment.CENTRE);
        wc.setBorder(Border.ALL, BorderLineStyle.THIN);
        wc.setBackground(Colour.WHITE);
        for (int i = 0; i < 5; ++i) {
            sheet.mergeCells(i, 0, i, 1);
        }
        sheet.mergeCells(5, 0, 8, 0);
        sheet.mergeCells(9, 0, 12, 0);
        sheet.mergeCells(13, 0, 18, 0);
        sheet.mergeCells(19, 0, 23, 0);
        final Label eAccount = new Label(0, 0, "\u935b\u6a3a\u4f10\u5bb8\u30e5\u5f7f", (CellFormat)wc);
        sheet.addCell((WritableCell)eAccount);
        final Label eName = new Label(1, 0, "\u935b\u6a3a\u4f10\u6fee\u64b3\u6095", (CellFormat)wc);
        sheet.addCell((WritableCell)eName);
        final Label department = new Label(2, 0, "\u93b5\ufffd\u705e\u70ba\u5134\u95c2\ufffd", (CellFormat)wc);
        sheet.addCell((WritableCell)department);
        final Label date = new Label(3, 0, "\u93c3\u30e6\u6e61", (CellFormat)wc);
        sheet.addCell((WritableCell)date);
        final Label basePay = new Label(4, 0, "\u9369\u70d8\u6e70\u5bb8\u30e8\u796b", (CellFormat)wc);
        sheet.addCell((WritableCell)basePay);
        final Label subsidy = new Label(5, 0, "\u741b\u30e8\u521b", (CellFormat)wc);
        sheet.addCell((WritableCell)subsidy);
        final Label foodPay = new Label(5, 1, "\u6901\u6130\u30ae\u741b\u30e8\u521b", (CellFormat)wc);
        sheet.addCell((WritableCell)foodPay);
        final Label postPay = new Label(6, 1, "\u5b80\u693e\u7d85\u741b\u30e8\u521b", (CellFormat)wc);
        sheet.addCell((WritableCell)postPay);
        final Label trafficPay = new Label(7, 1, "\u6d5c\u3089\ufffd\u6c33\u02c9\u7490\ufffd", (CellFormat)wc);
        sheet.addCell((WritableCell)trafficPay);
        final Label businessTravePay = new Label(8, 1, "\u9351\u54c4\u6a0a\u741b\u30e8\u521b", (CellFormat)wc);
        sheet.addCell((WritableCell)businessTravePay);
        final Label bonus = new Label(9, 0, "\u6fc2\u682d\u567e", (CellFormat)wc);
        sheet.addCell((WritableCell)bonus);
        final Label wokingYearsPay = new Label(9, 1, "\u5bb8\u30e9\u7dde\u6fc2\u682d\u567e", (CellFormat)wc);
        sheet.addCell((WritableCell)wokingYearsPay);
        final Label rankPay = new Label(10, 1, "\u9471\u5c80\u041e\u6fc2\u682d\u567e", (CellFormat)wc);
        sheet.addCell((WritableCell)rankPay);
        final Label overtimePay = new Label(11, 1, "\u9354\u72b5\u5f6e\u6fc2\u682d\u567e", (CellFormat)wc);
        sheet.addCell((WritableCell)overtimePay);
        final Label fullAttendancePay = new Label(12, 1, "\u934f\u3125\u5adf\u6fc2\u682d\u567e", (CellFormat)wc);
        sheet.addCell((WritableCell)fullAttendancePay);
        final Label risks = new Label(13, 0, "\u6d5c\u65c8\u6ad3\u6d93\ufffd\u95b2\ufffd", (CellFormat)wc);
        sheet.addCell((WritableCell)risks);
        final Label persionPay = new Label(13, 1, "\u934f\u660f\ufffd\u4f77\u7e5a\u95c4\ufffd", (CellFormat)wc);
        sheet.addCell((WritableCell)persionPay);
        final Label medicalPay = new Label(14, 1, "\u9356\u8364\u679f\u6dc7\u6fcb\u6ad3", (CellFormat)wc);
        sheet.addCell((WritableCell)medicalPay);
        final Label unemploymentPay = new Label(15, 1, "\u6fb6\u53d8\u7b1f\u6dc7\u6fcb\u6ad3", (CellFormat)wc);
        sheet.addCell((WritableCell)unemploymentPay);
        final Label injuryPay = new Label(16, 1, "\u5bb8\u30e4\u6fc0\u6dc7\u6fcb\u6ad3", (CellFormat)wc);
        sheet.addCell((WritableCell)injuryPay);
        final Label birthPay = new Label(17, 1, "\u9422\u71bb\u505b\u6dc7\u6fcb\u6ad3", (CellFormat)wc);
        sheet.addCell((WritableCell)birthPay);
        final Label housingPay = new Label(18, 1, "\u6d63\u5fd4\u57e7\u934f\ue102\u041d\u95b2\ufffd", (CellFormat)wc);
        sheet.addCell((WritableCell)housingPay);
        final Label deduction = new Label(19, 0, "\u5bb8\u30e8\u796b\u93b5\uff49\ue582", (CellFormat)wc);
        sheet.addCell((WritableCell)deduction);
        final Label latePay = new Label(19, 1, "\u6769\u71b7\u57cc\u93b5\uff49\ue582", (CellFormat)wc);
        sheet.addCell((WritableCell)latePay);
        final Label earlyPay = new Label(20, 1, "\u93c3\u2545\ufffd\ufffd\u93b5\uff49\ue582", (CellFormat)wc);
        sheet.addCell((WritableCell)earlyPay);
        final Label sickPay = new Label(21, 1, "\u9425\u546d\u4ea3\u93b5\uff49\ue582", (CellFormat)wc);
        sheet.addCell((WritableCell)sickPay);
        final Label thingPay = new Label(22, 1, "\u6d5c\u5b2a\u4ea3\u93b5\uff49\ue582", (CellFormat)wc);
        sheet.addCell((WritableCell)thingPay);
        final Label individualIncomeTax = new Label(23, 1, "\u6d93\ue043\u6c49\u93b5\ufffd\u5bf0\u6943\u25e3", (CellFormat)wc);
        sheet.addCell((WritableCell)individualIncomeTax);
        final Label rissuePay = new Label(24, 0, "\u741b\u30e5\u5f42\u5bb8\u30e8\u796b", (CellFormat)wc);
        sheet.addCell((WritableCell)rissuePay);
        sheet.mergeCells(24, 0, 24, 1);
        final Label shouldPay = new Label(25, 0, "\u6434\u65bf\u5f42\u5bb8\u30e8\u796b", (CellFormat)wc);
        sheet.addCell((WritableCell)shouldPay);
        sheet.mergeCells(25, 0, 25, 1);
        final Label actualPay = new Label(26, 0, "\u7039\u70b2\u5f42\u5bb8\u30e8\u796b", (CellFormat)wc);
        sheet.addCell((WritableCell)actualPay);
        sheet.mergeCells(26, 0, 26, 1);
        final Label sState = new Label(27, 0, "\u9418\u8235\ufffd\ufffd", (CellFormat)wc);
        sheet.mergeCells(27, 0, 27, 1);
        sheet.addCell((WritableCell)sState);
        final WritableCellFormat cf2 = new WritableCellFormat(DateFormats.FORMAT1);
        int row = 1;
        for (final Salary salary : salaries) {
            ++row;
            sheet.addCell((WritableCell)new Label(0, row, salary.getEmployee().geteAccount()));
            sheet.addCell((WritableCell)new Label(1, row, salary.getEmployee().geteName()));
            sheet.addCell((WritableCell)new Label(2, row, salary.getDepartment().getdName()));
            sheet.addCell((WritableCell)new DateTime(3, row, salary.getsTime(), (CellFormat)cf2));
            sheet.addCell((WritableCell)new Number(4, row, (double)salary.getBasePay()));
            sheet.addCell((WritableCell)new Number(5, row, (double)salary.getFoodPay()));
            sheet.addCell((WritableCell)new Number(6, row, (double)salary.getPostPay()));
            sheet.addCell((WritableCell)new Number(7, row, (double)salary.getTrafficPay()));
            sheet.addCell((WritableCell)new Number(8, row, (double)salary.getBusinessTravelPay()));
            sheet.addCell((WritableCell)new Number(9, row, (double)salary.getWorkingYearPay()));
            sheet.addCell((WritableCell)new Number(10, row, (double)salary.getRankPay()));
            sheet.addCell((WritableCell)new Number(11, row, (double)salary.getOvertimePay()));
            sheet.addCell((WritableCell)new Number(12, row, (double)salary.getFullAttendancePay()));
            sheet.addCell((WritableCell)new Number(13, row, (double)salary.getPersionPay()));
            sheet.addCell((WritableCell)new Number(14, row, (double)salary.getMedicalPay()));
            sheet.addCell((WritableCell)new Number(15, row, (double)salary.getUnemploymentPay()));
            sheet.addCell((WritableCell)new Number(16, row, (double)salary.getInjuryPay()));
            sheet.addCell((WritableCell)new Number(17, row, (double)salary.getBirthPay()));
            sheet.addCell((WritableCell)new Number(18, row, (double)salary.getHousingPay()));
            sheet.addCell((WritableCell)new Number(19, row, (double)salary.getLatePay()));
            sheet.addCell((WritableCell)new Number(20, row, (double)salary.getEarlyPay()));
            sheet.addCell((WritableCell)new Number(21, row, (double)salary.getSickPay()));
            sheet.addCell((WritableCell)new Number(22, row, (double)salary.getThingPay()));
            sheet.addCell((WritableCell)new Number(23, row, (double)salary.getIndividualIncomeTax()));
            sheet.addCell((WritableCell)new Number(24, row, (double)salary.getRissuePay()));
            sheet.addCell((WritableCell)new Number(25, row, (double)salary.getShouldPay()));
            sheet.addCell((WritableCell)new Number(26, row, (double)salary.getActualPay()));
            if (salary.getsState() == 0) {
                sheet.addCell((WritableCell)new Label(27, row, "\u93c8\ue044\u5f42"));
            }
            else {
                sheet.addCell((WritableCell)new Label(27, row, "\u5bb8\u63d2\u5f42"));
            }
        }
        return writableWorkbook;
    }
}
