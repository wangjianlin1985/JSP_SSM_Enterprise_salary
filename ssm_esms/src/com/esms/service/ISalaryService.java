// 
// 
// 

package com.esms.service;

import com.esms.vo.SalaryPages;
import com.esms.exception.CustomException;

public interface ISalaryService
{
    void insertSalaryByAcountAndDate(String p0, String p1) throws CustomException;
    
    void insertSalaryAllByDate(String p0) throws CustomException;
    
    SalaryPages selectSalaryByEaccountDIdDate(Integer p0, Integer p1, String p2, Integer p3, String p4);
    
    void deleteSalaryByEid(int[] p0);
    
    void updateSalaryBySid(int[] p0);
    
    SalaryPages selectSalaryByEaccountDIdDateState(int p0, int p1, String p2, Integer p3, String p4);
    
    void updateSalaryByEidAndRissuePay(int p0, double p1);
}
