// 
// 
// 

package com.esms.controller;

import com.esms.vo.SalaryPages;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.esms.exception.CustomException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import com.esms.service.impl.SalaryServiceImpl;
import org.springframework.stereotype.Controller;

@Controller
public class SalaryController
{
    @Autowired
    private SalaryServiceImpl salaryService;
    
    public SalaryController() {
        this.salaryService = null;
    }
    
    @RequestMapping({ "salarySettlementByAcount.do" })
    @ResponseBody
    public Map<String, String> salarySettlementByAcount(final String eAccount, final String date) {
        final Map<String, String> stringMap = new HashMap<String, String>();
        try {
            this.salaryService.insertSalaryByAcountAndDate(eAccount, date);
            stringMap.put("msg", "\u5bb8\u30e8\u796b\u7f01\u64b6\u757b\u7039\u5c7e\u579a");
            return stringMap;
        }
        catch (CustomException e) {
            stringMap.put("msg", e.getMessage());
            return stringMap;
        }
    }
    
    @RequestMapping({ "salarySettlementAll.do" })
    @ResponseBody
    public Map<String, String> salarySettlementAll(final String date) {
        final Map<String, String> stringMap = new HashMap<String, String>();
        try {
            this.salaryService.insertSalaryAllByDate(date);
            stringMap.put("msg", "\u5bb8\u30e8\u796b\u7f01\u64b6\u757b\u7039\u5c7e\u579a");
            return stringMap;
        }
        catch (CustomException e) {
            stringMap.put("msg", e.getMessage());
            return stringMap;
        }
    }
    
    @RequestMapping({ "deleteSalaryByEid.do" })
    @ResponseBody
    public int deleteSalaryByEid(@RequestParam("arr") final int[] ids) {
        this.salaryService.deleteSalaryByEid(ids);
        return 1;
    }
    
    @RequestMapping({ "issueSalaryByEid.do" })
    @ResponseBody
    public void issueSalaryByEid(@RequestParam("arr") final int[] ids) {
        this.salaryService.updateSalaryBySid(ids);
    }
    
    @RequestMapping(value = { "selectSalaryByEaccountDIdDate.do" }, produces = { "application/json;charset=utf-8" })
    @ResponseBody
    public String selectSalaryByEaccountDIdDate(@RequestParam(value = "page", defaultValue = "1") final int pageNum, @RequestParam(value = "limit", defaultValue = "5") final int limit, final String eAccount, final Integer dId, final String sTime) {
        final SalaryPages salaryPages = this.salaryService.selectSalaryByEaccountDIdDate(pageNum, limit, eAccount, dId, sTime);
        JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM";
        return JSON.toJSONString((Object)salaryPages, new SerializerFeature[] { SerializerFeature.WriteDateUseDateFormat });
    }
    
    @RequestMapping(value = { "selectSalaryByEaccountDIdDateState.do" }, produces = { "application/json;charset=utf-8" })
    @ResponseBody
    public String selectSalaryByEaccountDIdDateState(@RequestParam(value = "page", defaultValue = "1") final int pageNum, @RequestParam(value = "limit", defaultValue = "5") final int limit, final String eAccount, final Integer dId, final String sTime) {
        final SalaryPages salaryPages = this.salaryService.selectSalaryByEaccountDIdDateState(pageNum, limit, eAccount, dId, sTime);
        JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM";
        return JSON.toJSONString((Object)salaryPages, new SerializerFeature[] { SerializerFeature.WriteDateUseDateFormat });
    }
    
    @RequestMapping({ "updateSalaryByEidAndRissuePay.do" })
    @ResponseBody
    public void updateSalaryByEidAndRissuePay(final int sId, final double rissuePay) {
        this.salaryService.updateSalaryByEidAndRissuePay(sId, rissuePay);
    }
}
