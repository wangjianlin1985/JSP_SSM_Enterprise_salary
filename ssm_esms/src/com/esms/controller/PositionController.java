// 
// 
// 

package com.esms.controller;

import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import com.esms.po.Position;
import com.esms.vo.PositionPages;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import com.esms.service.PositionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping({ "/position" })
public class PositionController
{
    @Autowired
    public PositionService positionService;
    
    public PositionController() {
        this.positionService = null;
    }
    
    @RequestMapping({ "findSelective.do" })
    @ResponseBody
    public PositionPages findSelective(@RequestParam(value = "page", defaultValue = "1") final int pageNum, @RequestParam(value = "limit", defaultValue = "5") final int limit, @RequestParam(value = "p_name", defaultValue = "") final String p_name) throws Exception {
        final Position position = new Position();
        position.setpName(p_name);
        PageHelper.startPage(pageNum, limit);
        final List<Position> list = this.positionService.findSelective(position);
        final PageInfo pageResult = new PageInfo((List)list);
        final PositionPages positionPages = new PositionPages();
        positionPages.setCode(0);
        positionPages.setMsg("");
        positionPages.setCount((int)pageResult.getTotal());
        positionPages.setData(pageResult.getList());
        return positionPages;
    }
    
    @RequestMapping({ "/add.do" })
    @ResponseBody
    public int add(final String p_name, final String p_duty, final Double p_post_pay) throws Exception {
        final Position position = this.positionService.findByDname(p_name);
        if (position != null) {
            return position.getpId();
        }
        final Position p = new Position();
        p.setpId(null);
        p.setpName(p_name);
        p.setpDuty(p_duty);
        p.setpPostPay(p_post_pay);
        p.setpIsdel(1);
        this.positionService.insertSelective(p);
        return 0;
    }
    
    @RequestMapping({ "/findByPrimaryKey.do" })
    @ResponseBody
    public Position findByPrimaryKey(final int id) throws Exception {
        final Position position = this.positionService.findByPrimaryKey(id);
        return position;
    }
    
    @RequestMapping({ "/updateByPrimaryKey.do" })
    @ResponseBody
    public int updateByPrimaryKey(final int id, final String p_name, final String p_duty, final Double p_post_pay) throws Exception {
        final Position position = this.positionService.findByDname(p_name);
        System.out.println(p_name);
        System.out.println(position);
        System.out.println(position != null && !position.getpName().equals(p_name));
        if (position != null && !position.getpId().equals(id)) {
            return position.getpId();
        }
        final Position p = new Position();
        p.setpId(id);
        p.setpName(p_name);
        p.setpDuty(p_duty);
        p.setpPostPay(p_post_pay);
        p.setpIsdel(null);
        this.positionService.updateByPrimaryKeySelective(p);
        return 0;
    }
    
    @RequestMapping({ "/findByDname.do" })
    @ResponseBody
    public int findByDname(final String p_name) {
        final Position position = this.positionService.findByDname(p_name);
        if (position != null) {
            return position.getpId();
        }
        return 0;
    }
    
    @RequestMapping({ "/deleteByPrimaryKey.do" })
    @ResponseBody
    public int deleteByPrimaryKey(final int id) throws Exception {
        final Position position = new Position();
        position.setpId(id);
        this.positionService.deleteByPrimaryKey(id);
        return 1;
    }
    
    @RequestMapping({ "/deleteByQuery.do" })
    public void deleteByQuery(@RequestParam("arr") final int[] ids) {
        if (ids.length > 0) {
            this.positionService.deleteByQuery(ids);
        }
    }
}
