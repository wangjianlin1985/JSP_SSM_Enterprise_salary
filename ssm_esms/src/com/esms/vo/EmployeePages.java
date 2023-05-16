// 
// 
// 

package com.esms.vo;

import java.util.List;

public class EmployeePages
{
    Integer code;
    String msg;
    Integer count;
    List<EmployeeCustomVo> data;
    
    @Override
    public String toString() {
        return "EmployeePages{code=" + this.code + ", msg='" + this.msg + '\'' + ", count=" + this.count + ", data=" + this.data + '}';
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
    
    public List<EmployeeCustomVo> getData() {
        return this.data;
    }
    
    public void setData(final List<EmployeeCustomVo> data) {
        this.data = data;
    }
}
