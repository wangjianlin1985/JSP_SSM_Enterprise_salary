// 
// 
// 

package com.esms.controller;

import com.esms.po.SystemManager;
import com.esms.po.Employee;
import com.esms.exception.CustomException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import java.io.IOException;
import javax.servlet.ServletException;
import com.esms.utils.CaptchaUtil;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import com.esms.service.impl.LoginServiceImpl;
import org.springframework.stereotype.Controller;

@Controller
public class LoginController
{
    @Autowired
    private LoginServiceImpl loginService;
    
    public LoginController() {
        this.loginService = null;
    }
    
    @RequestMapping({ "/changeCode.do" })
    @ResponseBody
    public void getIdentifyingCode(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        CaptchaUtil.outputCaptcha(request, response);
    }
    
    @RequestMapping({ "/" })
    public String getLoginPage() {
        return "employee/login.html";
    }
    
    @RequestMapping({ "/admin.do" })
    public String getAdminLoginPage() {
        return "admin/adminLogin.html";
    }
    
    @RequestMapping({ "/employeeLogin.do" })
    @ResponseBody
    public Map<String, String> employeeLogin(final Model model, final HttpSession httpSession, final String username, final String password, final String identifyingcode) {
        final String code = (String)httpSession.getAttribute("identifyingCode");
        final HashMap<String, String> map = new HashMap<String, String>();
        if (identifyingcode.equalsIgnoreCase(code)) {
            Employee employee = null;
            try {
                employee = this.loginService.findEmployeeByIdAndPassword(username, password);
            }
            catch (CustomException e) {
                map.put("msg", e.getMessage());
                map.put("status", "500");
                return map;
            }
            httpSession.setAttribute("employeeId", (Object)employee.geteId());
            map.put("url", "/ssm_esms/loginSuccess.do");
            map.put("msg", "\u93b4\u612c\u59db");
            map.put("status", "200");
            return map;
        }
        map.put("msg", "\u6960\u5c83\u7609\u942e\u4f80\u654a\u7487\ufffd");
        map.put("status", "0");
        return map;
    }
    
    @RequestMapping({ "/loginSuccess.do" })
    public String loginSucceses(final Model model) throws Exception {
        return "employee/index.html";
    }
    
    @RequestMapping({ "/adminLogin.do" })
    @ResponseBody
    public Map<String, String> adminLogin(final Model model, final HttpSession httpSession, final String username, final String password, final String identifyingcode) {
        final String code = (String)httpSession.getAttribute("identifyingCode");
        final HashMap<String, String> map = new HashMap<String, String>();
        if (identifyingcode.equalsIgnoreCase(code)) {
            SystemManager manager = null;
            try {
                manager = this.loginService.findSystemManagerByIdAndPassword(username, password);
            }
            catch (CustomException e) {
                map.put("msg", e.getMessage());
                map.put("status", "500");
                return map;
            }
            httpSession.setAttribute("admin", (Object)manager);
            map.put("url", "toPage.do?url=admin/index.html");
            map.put("msg", "\u93b4\u612c\u59db");
            map.put("status", "200");
            return map;
        }
        map.put("msg", "\u6960\u5c83\u7609\u942e\u4f80\u654a\u7487\ufffd");
        map.put("status", "0");
        return map;
    }
    
    @RequestMapping({ "/getAdminAccount.do" })
    @ResponseBody
    public String getAdminAccount(final HttpSession httpSession) {
        final SystemManager systemManager = (SystemManager)httpSession.getAttribute("admin");
        return systemManager.getSmAccount();
    }
    
    @RequestMapping({ "/getEmployeeAccount.do" })
    @ResponseBody
    public Map<String, String> getEmployeeAccount(final HttpSession httpSession) {
        final Integer id = (Integer)httpSession.getAttribute("employeeId");
        final Employee employee = this.loginService.findEmployeeById(id);
        final HashMap<String, String> map = new HashMap<String, String>();
        map.put("account", employee.geteAccount());
        map.put("name", employee.geteName());
        return map;
    }
    
    @RequestMapping({ "/logout.do" })
    public String logout(final HttpSession httpSession) {
        httpSession.removeAttribute("employeeId");
        return "redirect:/";
    }
    
    @RequestMapping({ "/logoutAdmin.do" })
    public String logoutAdmin(final HttpSession httpSession) {
        httpSession.removeAttribute("admin");
        return "redirect:/admin.do";
    }
}
