// 
// 
// 

package com.esms.po;

public class Department
{
    private Integer dId;
    private String dName;
    private String dRemark;
    private Integer dIsdel;
    
    public Integer getdId() {
        return this.dId;
    }
    
    public void setdId(final Integer dId) {
        this.dId = dId;
    }
    
    public String getdName() {
        return this.dName;
    }
    
    public void setdName(final String dName) {
        this.dName = ((dName == null) ? null : dName.trim());
    }
    
    public String getdRemark() {
        return this.dRemark;
    }
    
    public void setdRemark(final String dRemark) {
        this.dRemark = ((dRemark == null) ? null : dRemark.trim());
    }
    
    public Integer getdIsdel() {
        return this.dIsdel;
    }
    
    public void setdIsdel(final Integer dIsdel) {
        this.dIsdel = dIsdel;
    }
    
    @Override
    public String toString() {
        return "Department{dId=" + this.dId + ", dName='" + this.dName + '\'' + ", dRemark='" + this.dRemark + '\'' + ", dIsdel=" + this.dIsdel + '}';
    }
}
