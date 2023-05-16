// 
// 
// 

package com.esms.vo;

import com.esms.po.MonthlyAttendance;
import java.util.List;

public class EmployeeMonthlyAttendancePages
{
    Integer code;
    String msg;
    Integer count;
    List<MonthlyAttendance> data;
    
    @Override
    public String toString() {
        return "EmployeeMonthlyAttendancePages{code=" + this.code + ", msg='" + this.msg + '\'' + ", count=" + this.count + ", data=" + this.data + '}';
    }
    
    public Integer getCode() {
        return this.code;
    }
    
    public void setCode(final Integer code) {
        this.code = code;
    }
    
    public String getMsg() {
        return this.msg;
    }
    
    public void setMsg(final String msg) {
        this.msg = msg;
    }
    
    public Integer getCount() {
        return this.count;
    }
    
    public void setCount(final Integer count) {
        this.count = count;
    }
    
    public List<MonthlyAttendance> getData() {
        return this.data;
    }
    
    public void setData(final List<MonthlyAttendance> data) {
        this.data = data;
    }
}
