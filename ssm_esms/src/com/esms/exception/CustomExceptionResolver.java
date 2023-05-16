// 
// 
// 

package com.esms.exception;

import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.servlet.HandlerExceptionResolver;

public class CustomExceptionResolver implements HandlerExceptionResolver
{
    public ModelAndView resolveException(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse, final Object o, final Exception e) {
        CustomException customException = null;
        if (e instanceof CustomException) {
            customException = (CustomException)e;
        }
        else {
            customException = new CustomException("\u7eef\u8364\u7cba\u9351\u8679\u5e47\u93c8\ue046\u7161\u95bf\u6b12\ue1e4!");
        }
        final String message = customException.getMessage();
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", (Object)message);
        modelAndView.setViewName("error/error.jsp");
        return modelAndView;
    }
}
