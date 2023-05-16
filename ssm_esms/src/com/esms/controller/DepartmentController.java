// 
// 
// 

package com.esms.controller;

import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import com.esms.po.Department;
import com.esms.vo.DepartmentPages;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import com.esms.service.DepartmentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping({ "/department" })
public class DepartmentController
{
    @Autowired
    public DepartmentService departmentService;
    
    public DepartmentController() {
        this.departmentService = null;
    }
    
    @RequestMapping({ "/findSelective.do" })
    @ResponseBody
    public DepartmentPages findSelective(@RequestParam(value = "page", defaultValue = "1") final int pageNum, @RequestParam(value = "limit", defaultValue = "5") final int limit, @RequestParam(value = "d_name", defaultValue = "") final String d_name) throws Exception {
        final Department department = new Department();
        department.setdName(d_name);
        PageHelper.startPage(pageNum, limit);
        final List<Department> list = this.departmentService.findSelective(department);
        final PageInfo pageResult = new PageInfo((List)list);
        final DepartmentPages departmentPages = new DepartmentPages();
        departmentPages.setCode(0);
        departmentPages.setMsg("");
        departmentPages.setCount((int)pageResult.getTotal());
        departmentPages.setData(pageResult.getList());
        return departmentPages;
    }
    
    @RequestMapping({ "/add.do" })
    @ResponseBody
    public int add(final String d_name, final String d_remark) throws Exception {
        final Department department = this.departmentService.findByDname(d_name);
        if (department != null) {
            return department.getdId();
        }
        final Department d = new Department();
        d.setdId(null);
        d.setdName(d_name);
        d.setdRemark(d_remark);
        d.setdIsdel(1);
        this.departmentService.insertSelective(d);
        return 0;
    }
    
    @RequestMapping({ "/findByPrimaryKey.do" })
    @ResponseBody
    public Department findByPrimaryKey(final int id) throws Exception {
        final Department department = this.departmentService.selectByPrimaryKey(id);
        return department;
    }
    
    @RequestMapping({ "/updateByPrimaryKey.do" })
    @ResponseBody
    public int updateByPrimaryKey(final int id, final String d_name, final String d_remark) throws Exception {
        final Department department = this.departmentService.findByDname(d_name);
        if (department != null && !department.getdId().equals(id)) {
            return department.getdId();
        }
        final Department d = new Department();
        d.setdId(id);
        d.setdName(d_name);
        d.setdRemark(d_remark);
        d.setdIsdel(null);
        this.departmentService.updateByPrimaryKeySelective(d);
        return 0;
    }
    
    @RequestMapping({ "/findByDname.do" })
    @ResponseBody
    public int findByDname(final String d_name) {
        final Department department = this.departmentService.findByDname(d_name);
        if (department != null) {
            return department.getdId();
        }
        return 0;
    }
    
    @RequestMapping({ "/deleteByPrimaryKey.do" })
    @ResponseBody
    public int deleteByPrimaryKey(final int id) throws Exception {
        final Department department = new Department();
        department.setdId(id);
        department.setdIsdel(0);
        this.departmentService.updateByPrimaryKeySelective(department);
        return 1;
    }
    
    @RequestMapping({ "/deleteByQuery.do" })
    public void deleteByQuery(@RequestParam("arr") final int[] ids) {
        if (ids.length > 0) {
            this.departmentService.deleteByQuery(ids);
        }
    }
}
