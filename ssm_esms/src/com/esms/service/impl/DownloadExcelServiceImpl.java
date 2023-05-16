// 
// 
// 

package com.esms.service.impl;

import com.esms.po.Salary;
import java.util.List;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import java.io.IOException;
import com.esms.exception.CustomException;
import java.io.OutputStream;
import com.esms.utils.JXLUtils;
import java.util.Map;
import java.util.HashMap;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import com.esms.dao.SalaryMapper;
import org.springframework.stereotype.Service;
import com.esms.service.IDownloadExcelService;

@Service
public class DownloadExcelServiceImpl implements IDownloadExcelService
{
    @Autowired
    private SalaryMapper salaryMapper;
    
    @Override
    public void getSalaryExcel(final HttpServletRequest request, final HttpServletResponse response, final String eAccount, final Integer dId, final String sTime) throws Exception {
        final String excelName = "\u5bb8\u30e8\u796b\u741b\ufffd.xls";
        WritableWorkbook writableWorkbook = null;
        final Map map = new HashMap();
        map.put("eAccount", eAccount);
        map.put("dId", dId);
        map.put("sTime", sTime);
        final List<Salary> salaries = this.salaryMapper.selectByEaccountDIdDate(map);
        try {
            response.setHeader("Content-Disposition", "attachment;filename=" + new String(excelName.getBytes("gbk"), "ISO-8859-1"));
            writableWorkbook = JXLUtils.createSalaryExcel((OutputStream)response.getOutputStream(), salaries);
            writableWorkbook.write();
            writableWorkbook.close();
        }
        catch (IOException e) {
            e.printStackTrace();
            throw new CustomException("\u6d93\u5b2d\u6d47\u6fb6\u8fab\u89e6");
        }
        catch (WriteException e2) {
            e2.printStackTrace();
            throw new CustomException("\u6d93\u5b2d\u6d47\u6fb6\u8fab\u89e6");
        }
    }
}
