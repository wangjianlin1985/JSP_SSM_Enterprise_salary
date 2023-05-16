// 
// 
// 

package com.esms.utils;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
public class PageUtils
{
    @RequestMapping({ "/toPage.do" })
    public String toPage(final String url) {
        return url;
    }
}
