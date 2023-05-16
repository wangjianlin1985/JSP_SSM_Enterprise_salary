// 
// 
// 

package com.esms.service;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

public interface IDownloadExcelService
{
    void getSalaryExcel(HttpServletRequest p0, HttpServletResponse p1, String p2, Integer p3, String p4) throws Exception;
}
