// 
// 
// 

package com.esms.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

public class Salary
{
    private Integer sId;
    private Integer eId;
    private Employee employee;
    private Integer dId;
    private Department department;
    private Date sTime;
    private Integer sState;
    private Double basePay;
    private Double foodPay;
    private Double postPay;
    private Double workingYearPay;
    private Double rankPay;
    private Double trafficPay;
    private Double persionPay;
    private Double medicalPay;
    private Double unemploymentPay;
    private Double injuryPay;
    private Double birthPay;
    private Double housingPay;
    private Double latePay;
    private Double earlyPay;
    private Double overtimePay;
    private Double sickPay;
    private Double thingPay;
    private Double businessTravelPay;
    private Double fullAttendancePay;
    private Double rissuePay;
    private Double individualIncomeTax;
    private Double shouldPay;
    private Double actualPay;
    
    public Integer getsId() {
        return this.sId;
    }
    
    public void setsId(final Integer sId) {
        this.sId = sId;
    }
    
    public Integer geteId() {
        return this.eId;
    }
    
    public void seteId(final Integer eId) {
        this.eId = eId;
    }
    
    public Integer getdId() {
        return this.dId;
    }
    
    public void setdId(final Integer dId) {
        this.dId = dId;
    }
    
    public Department getDepartment() {
        return this.department;
    }
    
    public void setDepartment(final Department department) {
        this.department = department;
    }
    
    public Employee getEmployee() {
        return this.employee;
    }
    
    public void setEmployee(final Employee employee) {
        this.employee = employee;
    }
    
    @JsonFormat(pattern = "yyyy-MM", timezone = "GMT+8")
    public Date getsTime() {
        return this.sTime;
    }
    
    public void setsTime(final Date sTime) {
        this.sTime = sTime;
    }
    
    public Integer getsState() {
        return this.sState;
    }
    
    public void setsState(final Integer sState) {
        this.sState = sState;
    }
    
    public Double getBasePay() {
        return this.basePay;
    }
    
    public void setBasePay(final Double basePay) {
        this.basePay = basePay;
    }
    
    public Double getFoodPay() {
        return this.foodPay;
    }
    
    public void setFoodPay(final Double foodPay) {
        this.foodPay = foodPay;
    }
    
    public Double getPostPay() {
        return this.postPay;
    }
    
    public void setPostPay(final Double postPay) {
        this.postPay = postPay;
    }
    
    public Double getWorkingYearPay() {
        return this.workingYearPay;
    }
    
    public void setWorkingYearPay(final Double workingYearPay) {
        this.workingYearPay = workingYearPay;
    }
    
    public Double getRankPay() {
        return this.rankPay;
    }
    
    public void setRankPay(final Double rankPay) {
        this.rankPay = rankPay;
    }
    
    public Double getTrafficPay() {
        return this.trafficPay;
    }
    
    public void setTrafficPay(final Double trafficPay) {
        this.trafficPay = trafficPay;
    }
    
    public Double getPersionPay() {
        return this.persionPay;
    }
    
    public void setPersionPay(final Double persionPay) {
        this.persionPay = persionPay;
    }
    
    public Double getMedicalPay() {
        return this.medicalPay;
    }
    
    public void setMedicalPay(final Double medicalPay) {
        this.medicalPay = medicalPay;
    }
    
    public Double getUnemploymentPay() {
        return this.unemploymentPay;
    }
    
    public void setUnemploymentPay(final Double unemploymentPay) {
        this.unemploymentPay = unemploymentPay;
    }
    
    public Double getInjuryPay() {
        return this.injuryPay;
    }
    
    public void setInjuryPay(final Double injuryPay) {
        this.injuryPay = injuryPay;
    }
    
    public Double getBirthPay() {
        return this.birthPay;
    }
    
    public void setBirthPay(final Double birthPay) {
        this.birthPay = birthPay;
    }
    
    public Double getHousingPay() {
        return this.housingPay;
    }
    
    public void setHousingPay(final Double housingPay) {
        this.housingPay = housingPay;
    }
    
    public Double getLatePay() {
        return this.latePay;
    }
    
    public void setLatePay(final Double latePay) {
        this.latePay = latePay;
    }
    
    public Double getEarlyPay() {
        return this.earlyPay;
    }
    
    public void setEarlyPay(final Double earlyPay) {
        this.earlyPay = earlyPay;
    }
    
    public Double getOvertimePay() {
        return this.overtimePay;
    }
    
    public void setOvertimePay(final Double overtimePay) {
        this.overtimePay = overtimePay;
    }
    
    public Double getSickPay() {
        return this.sickPay;
    }
    
    public void setSickPay(final Double sickPay) {
        this.sickPay = sickPay;
    }
    
    public Double getThingPay() {
        return this.thingPay;
    }
    
    public void setThingPay(final Double thingPay) {
        this.thingPay = thingPay;
    }
    
    public Double getBusinessTravelPay() {
        return this.businessTravelPay;
    }
    
    public void setBusinessTravelPay(final Double businessTravelPay) {
        this.businessTravelPay = businessTravelPay;
    }
    
    public Double getFullAttendancePay() {
        return this.fullAttendancePay;
    }
    
    public void setFullAttendancePay(final Double fullAttendancePay) {
        this.fullAttendancePay = fullAttendancePay;
    }
    
    public Double getRissuePay() {
        return this.rissuePay;
    }
    
    public void setRissuePay(final Double rissuePay) {
        this.rissuePay = rissuePay;
    }
    
    public Double getIndividualIncomeTax() {
        return this.individualIncomeTax;
    }
    
    public void setIndividualIncomeTax(final Double individualIncomeTax) {
        this.individualIncomeTax = individualIncomeTax;
    }
    
    public Double getShouldPay() {
        return this.shouldPay;
    }
    
    public void setShouldPay(final Double shouldPay) {
        this.shouldPay = shouldPay;
    }
    
    public Double getActualPay() {
        return this.actualPay;
    }
    
    public void setActualPay(final Double actualPay) {
        this.actualPay = actualPay;
    }
    
    @Override
    public String toString() {
        return "Salary{sId=" + this.sId + ", eId=" + this.eId + ", employee=" + this.employee + ", dId=" + this.dId + ", department=" + this.department + ", sTime=" + this.sTime + ", sState=" + this.sState + ", basePay=" + this.basePay + ", foodPay=" + this.foodPay + ", postPay=" + this.postPay + ", workingYearPay=" + this.workingYearPay + ", rankPay=" + this.rankPay + ", trafficPay=" + this.trafficPay + ", persionPay=" + this.persionPay + ", medicalPay=" + this.medicalPay + ", unemploymentPay=" + this.unemploymentPay + ", injuryPay=" + this.injuryPay + ", birthPay=" + this.birthPay + ", housingPay=" + this.housingPay + ", latePay=" + this.latePay + ", earlyPay=" + this.earlyPay + ", overtimePay=" + this.overtimePay + ", sickPay=" + this.sickPay + ", thingPay=" + this.thingPay + ", businessTravelPay=" + this.businessTravelPay + ", fullAttendancePay=" + this.fullAttendancePay + ", rissuePay=" + this.rissuePay + ", individualIncomeTax=" + this.individualIncomeTax + ", shouldPay=" + this.shouldPay + ", actualPay=" + this.actualPay + '}';
    }
}
