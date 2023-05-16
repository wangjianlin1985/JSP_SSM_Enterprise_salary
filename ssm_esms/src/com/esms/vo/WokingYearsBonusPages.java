// 
// 
// 

package com.esms.vo;

import java.util.List;

public class WokingYearsBonusPages
{
    Integer code;
    String msg;
    Integer count;
    List<WokingYearsBonusPages> data;
    
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
    
    public List<WokingYearsBonusPages> getData() {
        return this.data;
    }
    
    public void setData(final List<WokingYearsBonusPages> data) {
        this.data = data;
    }
    
    @Override
    public String toString() {
        return "WokingYearsBonusPages{code=" + this.code + ", msg='" + this.msg + '\'' + ", count=" + this.count + ", data=" + this.data + '}';
    }
}
