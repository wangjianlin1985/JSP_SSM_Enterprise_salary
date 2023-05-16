// 
// 
// 

package com.esms.po;

public class Position
{
    private Integer pId;
    private String pName;
    private String pDuty;
    private Double pPostPay;
    private Integer pIsdel;
    
    public Integer getpId() {
        return this.pId;
    }
    
    public void setpId(final Integer pId) {
        this.pId = pId;
    }
    
    public String getpName() {
        return this.pName;
    }
    
    public void setpName(final String pName) {
        this.pName = ((pName == null) ? null : pName.trim());
    }
    
    public String getpDuty() {
        return this.pDuty;
    }
    
    public void setpDuty(final String pDuty) {
        this.pDuty = ((pDuty == null) ? null : pDuty.trim());
    }
    
    public Double getpPostPay() {
        return this.pPostPay;
    }
    
    public void setpPostPay(final Double pPostPay) {
        this.pPostPay = pPostPay;
    }
    
    public Integer getpIsdel() {
        return this.pIsdel;
    }
    
    public void setpIsdel(final Integer pIsdel) {
        this.pIsdel = pIsdel;
    }
    
    @Override
    public String toString() {
        return "Position{pId=" + this.pId + ", pName='" + this.pName + '\'' + ", pDuty='" + this.pDuty + '\'' + ", pPostPay=" + this.pPostPay + ", pIsdel=" + this.pIsdel + '}';
    }
}
