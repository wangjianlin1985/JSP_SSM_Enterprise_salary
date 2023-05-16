// 
// 
// 

package com.esms.vo;

import com.esms.po.RankBonus;
import java.util.List;

public class RankBonusPages
{
    Integer code;
    String msg;
    Integer count;
    List<RankBonus> data;
    
    @Override
    public String toString() {
        return "RankBonusPages{code=" + this.code + ", msg='" + this.msg + '\'' + ", count=" + this.count + ", data=" + this.data + '}';
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
    
    public List<RankBonus> getData() {
        return this.data;
    }
    
    public void setData(final List<RankBonus> data) {
        this.data = data;
    }
    
    public Integer getCode() {
        return this.code;
    }
    
    public void setCode(final Integer code) {
        this.code = code;
    }
}
