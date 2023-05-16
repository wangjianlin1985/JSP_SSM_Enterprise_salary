// 
// 
// 

package com.esms.controller;

import com.esms.vo.RankBonusPages;
import java.util.List;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.esms.po.RankBonus;
import org.springframework.beans.factory.annotation.Autowired;
import com.esms.service.IRankBonusService;
import org.springframework.stereotype.Controller;

@Controller
public class RankBonusController
{
    @Autowired
    private IRankBonusService service;
    
    public void setiRankBonusService(final IRankBonusService iRankBonusService) {
        this.service = iRankBonusService;
    }
    
    @RequestMapping({ "/insertRankBonus.do" })
    @ResponseBody
    public String doInsertRankBonus(final int bonus, final String name) {
        if (this.service.CountByName(name) > 0) {
            return "exist";
        }
        if (!name.equals("") && bonus >= 0) {
            final RankBonus rb = new RankBonus();
            rb.setRankName(name);
            rb.setRbBonus(bonus);
            this.service.addRankBonus(rb);
            return "ok";
        }
        return "no";
    }
    
    @RequestMapping({ "/findAll.do" })
    public String doFindAll(@RequestParam(value = "pn", defaultValue = "1") final Integer pn, final Model model) {
        final int pageSize = 10;
        PageHelper.startPage((int)pn, pageSize);
        final List<RankBonus> rbs = this.service.findAll();
        System.out.println(rbs + "=================================");
        final PageInfo page = new PageInfo((List)rbs, 5);
        model.addAttribute("pageInfo", (Object)page);
        return "admin/rank-list.jsp";
    }
    
    @RequestMapping({ "/findRankBonusList.do" })
    @ResponseBody
    public RankBonusPages findSelective(@RequestParam(value = "page", defaultValue = "1") final int pageNum, @RequestParam(value = "limit", defaultValue = "10") final int limit, @RequestParam(value = "rb_name", defaultValue = "") final String rb_name) throws Exception {
        final RankBonus rb = new RankBonus();
        rb.setRankName(rb_name);
        PageHelper.startPage(pageNum, limit);
        final List<RankBonus> list = this.service.findSelective(rb);
        final PageInfo pageResult = new PageInfo((List)list);
        final RankBonusPages rankBonusPages = new RankBonusPages();
        rankBonusPages.setCode(0);
        rankBonusPages.setMsg("");
        rankBonusPages.setCount((int)pageResult.getTotal());
        rankBonusPages.setData(pageResult.getList());
        return rankBonusPages;
    }
    
    @RequestMapping({ "rankBonusDelete.do" })
    @ResponseBody
    public String doDelete(final int id) {
        if (this.service.CountByRbid(id) > 0) {
            return "exist";
        }
        if (this.service.moveRankBonus(id)) {
            return "ok";
        }
        return "no";
    }
    
    @RequestMapping({ "/updateRankBonus.do" })
    @ResponseBody
    public String doUpdate(final int id, final String rank, final int bonus) {
        final RankBonus rankBonus = this.service.findByName(rank);
        if (rankBonus != null && !rankBonus.getRbId().equals(id)) {
            return "exist";
        }
        final RankBonus rb = new RankBonus();
        rb.setRbId(id);
        rb.setRbBonus(bonus);
        rb.setRankName(rank);
        if (this.service.modifyRankName(rb)) {
            return "ok";
        }
        return "no";
    }
}
