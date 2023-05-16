// 
// 
// 

package com.esms.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

public class Employee
{
    private Integer eId;
    private String eAccount;
    private String ePassword;
    private String eName;
    private String eIdcard;
    private String eSex;
    private String eDagree;
    private Date eBirthday;
    private String eEmail;
    private String ePhone;
    private String eHometown;
    private Integer eRank;
    private String eHeadPath;
    private String eUrgentPerson;
    private String eUrgentPhone;
    private Integer pId;
    private Integer dId;
    private Double eBasePay;
    private Integer eIsdel;
    private Date eEntryTime;
    private Date eLeaveTime;
    
    public Integer geteId() {
        return this.eId;
    }
    
    public void seteId(final Integer eId) {
        this.eId = eId;
    }
    
    public String geteAccount() {
        return this.eAccount;
    }
    
    public void seteAccount(final String eAccount) {
        this.eAccount = ((eAccount == null) ? null : eAccount.trim());
    }
    
    public String getePassword() {
        return this.ePassword;
    }
    
    public void setePassword(final String ePassword) {
        this.ePassword = ((ePassword == null) ? null : ePassword.trim());
    }
    
    public String geteName() {
        return this.eName;
    }
    
    public void seteName(final String eName) {
        this.eName = ((eName == null) ? null : eName.trim());
    }
    
    public String geteIdcard() {
        return this.eIdcard;
    }
    
    public void seteIdcard(final String eIdcard) {
        this.eIdcard = ((eIdcard == null) ? null : eIdcard.trim());
    }
    
    public String geteSex() {
        return this.eSex;
    }
    
    public void seteSex(final String eSex) {
        this.eSex = eSex;
    }
    
    public String geteDagree() {
        return this.eDagree;
    }
    
    public void seteDagree(final String eDagree) {
        this.eDagree = ((eDagree == null) ? null : eDagree.trim());
    }
    
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public Date geteBirthday() {
        return this.eBirthday;
    }
    
    public void seteBirthday(final Date eBirthday) {
        this.eBirthday = eBirthday;
    }
    
    public String geteEmail() {
        return this.eEmail;
    }
    
    public void seteEmail(final String eEmail) {
        this.eEmail = ((eEmail == null) ? null : eEmail.trim());
    }
    
    public String getePhone() {
        return this.ePhone;
    }
    
    public void setePhone(final String ePhone) {
        this.ePhone = ((ePhone == null) ? null : ePhone.trim());
    }
    
    public String geteHometown() {
        return this.eHometown;
    }
    
    public void seteHometown(final String eHometown) {
        this.eHometown = ((eHometown == null) ? null : eHometown.trim());
    }
    
    public Integer geteRank() {
        return this.eRank;
    }
    
    public void seteRank(final Integer eRank) {
        this.eRank = eRank;
    }
    
    public String geteHeadPath() {
        return this.eHeadPath;
    }
    
    public void seteHeadPath(final String eHeadPath) {
        this.eHeadPath = ((eHeadPath == null) ? null : eHeadPath.trim());
    }
    
    public String geteUrgentPerson() {
        return this.eUrgentPerson;
    }
    
    public void seteUrgentPerson(final String eUrgentPerson) {
        this.eUrgentPerson = ((eUrgentPerson == null) ? null : eUrgentPerson.trim());
    }
    
    public String geteUrgentPhone() {
        return this.eUrgentPhone;
    }
    
    public void seteUrgentPhone(final String eUrgentPhone) {
        this.eUrgentPhone = ((eUrgentPhone == null) ? null : eUrgentPhone.trim());
    }
    
    public Integer getpId() {
        return this.pId;
    }
    
    public void setpId(final Integer pId) {
        this.pId = pId;
    }
    
    public Integer getdId() {
        return this.dId;
    }
    
    public void setdId(final Integer dId) {
        this.dId = dId;
    }
    
    public Double geteBasePay() {
        return this.eBasePay;
    }
    
    public void seteBasePay(final Double eBasePay) {
        this.eBasePay = eBasePay;
    }
    
    public Integer geteIsdel() {
        return this.eIsdel;
    }
    
    public void seteIsdel(final Integer eIsdel) {
        this.eIsdel = eIsdel;
    }
    
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public Date geteEntryTime() {
        return this.eEntryTime;
    }
    
    public void seteEntryTime(final Date eEntryTime) {
        this.eEntryTime = eEntryTime;
    }
    
    public Date geteLeaveTime() {
        return this.eLeaveTime;
    }
    
    public void seteLeaveTime(final Date eLeaveTime) {
        this.eLeaveTime = eLeaveTime;
    }
    
    @Override
    public String toString() {
        return "Employee{eId=" + this.eId + ", eAccount='" + this.eAccount + '\'' + ", ePassword='" + this.ePassword + '\'' + ", eName='" + this.eName + '\'' + ", eIdcard='" + this.eIdcard + '\'' + ", eSex=" + this.eSex + ", eDagree='" + this.eDagree + '\'' + ", eBirthday=" + this.eBirthday + ", eEmail='" + this.eEmail + '\'' + ", ePhone='" + this.ePhone + '\'' + ", eHometown='" + this.eHometown + '\'' + ", eRank=" + this.eRank + ", eHeadPath='" + this.eHeadPath + '\'' + ", eUrgentPerson='" + this.eUrgentPerson + '\'' + ", eUrgentPhone='" + this.eUrgentPhone + '\'' + ", pId=" + this.pId + ", dId=" + this.dId + ", eBasePay=" + this.eBasePay + ", eIsdel=" + this.eIsdel + ", eEntryTime=" + this.eEntryTime + ", eLeaveTime=" + this.eLeaveTime + '}';
    }
}
