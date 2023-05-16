// 
// 
// 

package com.esms.controller;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import com.esms.po.WorkingYearsBonus;
import com.esms.vo.WokingYearsBonusPages;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import com.esms.service.IWorkYearService;
import org.springframework.stereotype.Controller;

@Controller
public class WorkYearController
{
    @Autowired
    private IWorkYearService service;
    
    @RequestMapping({ "/findWorkingYearBonusList.do" })
    @ResponseBody
    public WokingYearsBonusPages findAll(@RequestParam(value = "page", defaultValue = "1") final int pageNum, @RequestParam(value = "limit", defaultValue = "5") final int limit, @RequestParam(value = "year", defaultValue = "0") final int year) throws Exception {
        final WorkingYearsBonus wyb = new WorkingYearsBonus();
        wyb.setWybYear(year);
        PageHelper.startPage(pageNum, limit);
        final List<WorkingYearsBonus> list = this.service.findSelective(wyb);
        final PageInfo pageResult = new PageInfo((List)list);
        final WokingYearsBonusPages wybp = new WokingYearsBonusPages();
        wybp.setCode(0);
        wybp.setMsg("");
        wybp.setCount((int)pageResult.getTotal());
        wybp.setData(pageResult.getList());
        return wybp;
    }
    
    @RequestMapping({ "/addWorkingYearsBonus.do" })
    @ResponseBody
    public String doWorkYearBonus(final int year, final double bonus) {
        if (this.service.Count(year) > 0) {
            return "exist";
        }
        if (year >= 0 && bonus >= 0.0) {
            final WorkingYearsBonus wyb = new WorkingYearsBonus();
            wyb.setWybYear(year);
            wyb.setWybBonus(bonus);
            this.service.addWorkYearBonus(wyb);
            return "ok";
        }
        return "no";
    }
    
    @RequestMapping({ "/deleteRecord.do" })
    @ResponseBody
    public String doDelete(final int id) {
        if (this.service.moveWorkYearBonus(id)) {
            return "ok";
        }
        return "no";
    }
    
    @RequestMapping({ "/updateRecord.do" })
    @ResponseBody
    public String doUpdate(final int id, final int year, final double bonus) {
        final WorkingYearsBonus workingYearsBonus = this.service.findByYear(year);
        if (workingYearsBonus != null && !workingYearsBonus.getWybId().equals(id)) {
            return "exist";
        }
        final WorkingYearsBonus wyb = new WorkingYearsBonus();
        wyb.setWybId(id);
        wyb.setWybYear(year);
        wyb.setWybBonus(bonus);
        if (this.service.modifyWorkYearBonus(wyb)) {
            return "ok";
        }
        return "no";
    }
}
