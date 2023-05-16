// 
// 
// 

package com.esms.po;

public class SystemManager
{
    private Integer smId;
    private String smAccount;
    private String smPassword;
    
    public Integer getSmId() {
        return this.smId;
    }
    
    public void setSmId(final Integer smId) {
        this.smId = smId;
    }
    
    public String getSmAccount() {
        return this.smAccount;
    }
    
    public void setSmAccount(final String smAccount) {
        this.smAccount = ((smAccount == null) ? null : smAccount.trim());
    }
    
    public String getSmPassword() {
        return this.smPassword;
    }
    
    public void setSmPassword(final String smPassword) {
        this.smPassword = ((smPassword == null) ? null : smPassword.trim());
    }
    
    @Override
    public String toString() {
        return "SystemManager{smId=" + this.smId + ", smAccount='" + this.smAccount + '\'' + ", smPassword='" + this.smPassword + '\'' + '}';
    }
}
