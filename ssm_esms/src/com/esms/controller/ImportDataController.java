// 
// 
// 

package com.esms.controller;

import org.springframework.web.bind.annotation.ResponseBody;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.esms.service.IImportDataService;
import org.springframework.stereotype.Controller;

@Controller
public class ImportDataController
{
    @Autowired
    private IImportDataService importDataService;
    
    @RequestMapping({ "toImportAttendance.do" })
    public String toImportAttendance() {
        return "admin/importData/importAttendanceTable.jsp";
    }
    
    @RequestMapping({ "toImportReissue.do" })
    public String toImportReissue() {
        return "admin/importData/importReissueTable.jsp";
    }
    
    @RequestMapping({ "/importAttendance.do" })
    @ResponseBody
    public Map<String, String> importAttendanceTable(@RequestParam("file") final MultipartFile excel) throws Exception {
        final Map<String, String> map = new HashMap<String, String>();
        if (!excel.isEmpty()) {
            final String result = this.importDataService.insertMATable(excel);
            map.put("result", result);
            return map;
        }
        map.put("result", "\u7035\u714e\u53c6\u9428\u52ec\u6783\u6d60\u6735\u7b09\u701b\u6a3a\u6e6a\u951b\u5c83\ue1ec\u95b2\u5d86\u67ca\u95ab\u590b\u5ae8\u93c2\u56e6\u6b22");
        return map;
    }
    
    @RequestMapping({ "/importReissue.do" })
    @ResponseBody
    public Map<String, String> importReissueTable(@RequestParam("file") final MultipartFile excel) throws Exception {
        final Map<String, String> map = new HashMap<String, String>();
        if (!excel.isEmpty()) {
            final String result = this.importDataService.insertReissueTable(excel);
            map.put("result", result);
            return map;
        }
        map.put("result", "\u7035\u714e\u53c6\u9428\u52ec\u6783\u6d60\u6735\u7b09\u701b\u6a3a\u6e6a\u951b\u5c83\ue1ec\u95b2\u5d86\u67ca\u95ab\u590b\u5ae8\u93c2\u56e6\u6b22");
        return map;
    }
}
