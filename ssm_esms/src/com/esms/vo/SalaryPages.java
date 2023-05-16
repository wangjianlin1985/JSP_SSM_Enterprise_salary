// 
// 
// 

package com.esms.vo;

import com.esms.po.Salary;
import java.util.List;

public class SalaryPages
{
    Integer code;
    String msg;
    Integer count;
    List<Salary> data;
    
    public SalaryPages() {
    }
    
    public SalaryPages(final Integer code, final String msg, final Integer count, final List<Salary> data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
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
    
    public List<Salary> getData() {
        return this.data;
    }
    
    public void setData(final List<Salary> data) {
        this.data = data;
    }
}
