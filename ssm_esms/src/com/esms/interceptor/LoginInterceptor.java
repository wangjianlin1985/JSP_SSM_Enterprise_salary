// 
// 
// 

package com.esms.interceptor;

import org.springframework.web.servlet.ModelAndView;
import com.esms.po.SystemManager;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptor implements HandlerInterceptor
{
    public boolean preHandle(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse, final Object o) throws Exception {
        final String string = (String)httpServletRequest.getSession().getAttribute("employeeId");
        final SystemManager systemManager = (SystemManager)httpServletRequest.getSession().getAttribute("admin");
        if (string != null) {
            return true;
        }
        if (string == null) {
            httpServletResponse.sendRedirect("/");
            return false;
        }
        if (systemManager != null) {
            return true;
        }
        httpServletResponse.sendRedirect("/admin.do");
        return false;
    }
    
    public void postHandle(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse, final Object o, final ModelAndView modelAndView) throws Exception {
    }
    
    public void afterCompletion(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse, final Object o, final Exception e) throws Exception {
    }
}
