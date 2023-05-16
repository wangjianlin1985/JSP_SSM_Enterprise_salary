// 
// 
// 

package com.esms.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

public class MonthlyAttendance
{
    private Integer maId;
    private Integer eId;
    private Employee employee;
    private Date attendanceTime;
    private Integer sickLeaveNum;
    private Double overtimeHour;
    private Double weekendHour;
    private Double holidayHour;
    private Integer lateNum;
    private Integer earlyNum;
    private Integer absenceNum;
    private Integer businessTravelNum;
    private Integer compassionateLeaveNum;
    
    public Integer getMaId() {
        return this.maId;
    }
    
    public void setMaId(final Integer maId) {
        this.maId = maId;
    }
    
    public Integer geteId() {
        return this.eId;
    }
    
    public void seteId(final Integer eId) {
        this.eId = eId;
    }
    
    public Employee getEmployee() {
        return this.employee;
    }
    
    public void setEmployee(final Employee employee) {
        this.employee = employee;
    }
    
    @JsonFormat(pattern = "yyyy-MM", timezone = "GMT+8")
    public Date getAttendanceTime() {
        return this.attendanceTime;
    }
    
    public void setAttendanceTime(final Date attendanceTime) {
        this.attendanceTime = attendanceTime;
    }
    
    public Integer getSickLeaveNum() {
        return this.sickLeaveNum;
    }
    
    public void setSickLeaveNum(final Integer sickLeaveNum) {
        this.sickLeaveNum = sickLeaveNum;
    }
    
    public Double getOvertimeHour() {
        return this.overtimeHour;
    }
    
    public void setOvertimeHour(final Double overtimeHour) {
        this.overtimeHour = overtimeHour;
    }
    
    public Double getWeekendHour() {
        return this.weekendHour;
    }
    
    public void setWeekendHour(final Double weekendHour) {
        this.weekendHour = weekendHour;
    }
    
    public Double getHolidayHour() {
        return this.holidayHour;
    }
    
    public void setHolidayHour(final Double holidayHour) {
        this.holidayHour = holidayHour;
    }
    
    public Integer getLateNum() {
        return this.lateNum;
    }
    
    public void setLateNum(final Integer lateNum) {
        this.lateNum = lateNum;
    }
    
    public Integer getEarlyNum() {
        return this.earlyNum;
    }
    
    public void setEarlyNum(final Integer earlyNum) {
        this.earlyNum = earlyNum;
    }
    
    public Integer getAbsenceNum() {
        return this.absenceNum;
    }
    
    public void setAbsenceNum(final Integer absenceNum) {
        this.absenceNum = absenceNum;
    }
    
    public Integer getBusinessTravelNum() {
        return this.businessTravelNum;
    }
    
    public void setBusinessTravelNum(final Integer businessTravelNum) {
        this.businessTravelNum = businessTravelNum;
    }
    
    public Integer getCompassionateLeaveNum() {
        return this.compassionateLeaveNum;
    }
    
    public void setCompassionateLeaveNum(final Integer compassionateLeaveNum) {
        this.compassionateLeaveNum = compassionateLeaveNum;
    }
    
    @Override
    public String toString() {
        return "MonthlyAttendance{maId=" + this.maId + ", eId=" + this.eId + ", employee=" + this.employee + ", attendanceTime=" + this.attendanceTime + ", sickLeaveNum=" + this.sickLeaveNum + ", overtimeHour=" + this.overtimeHour + ", weekendHour=" + this.weekendHour + ", holidayHour=" + this.holidayHour + ", lateNum=" + this.lateNum + ", earlyNum=" + this.earlyNum + ", absenceNum=" + this.absenceNum + ", businessTravelNum=" + this.businessTravelNum + ", compassionateLeaveNum=" + this.compassionateLeaveNum + '}';
    }
}
