// 
// 
// 

package com.esms.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import com.esms.service.IDownloadExcelService;
import org.springframework.stereotype.Controller;

@Controller
public class DownloadExcelController
{
    @Autowired
    private IDownloadExcelService downloadExcelService;
    
    @RequestMapping({ "downloadExcel.do" })
    public void downloadExcel(final HttpServletRequest request, final HttpServletResponse response, final String eAccount, final Integer dId, final String sTime) throws Exception {
        this.downloadExcelService.getSalaryExcel(request, response, eAccount, dId, sTime);
    }
}
