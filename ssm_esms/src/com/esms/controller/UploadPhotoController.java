// 
// 
// 

package com.esms.controller;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Map;
import java.text.DateFormat;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.io.IOException;
import java.io.File;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.stereotype.Controller;

@Controller
public class UploadPhotoController
{
    @RequestMapping({ "uploadPhoto.do" })
    @ResponseBody
    public Object updateHeadPhoto(@RequestParam(value = "file", required = false) final MultipartFile file, final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        String prefix = "";
        String dateStr = "";
        final OutputStream out = null;
        final InputStream fileInput = null;
        final double index = 1000.0 * Math.random();
        final DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            if (file != null) {
                final String originalName = file.getOriginalFilename();
                prefix = originalName.substring(originalName.lastIndexOf(".") + 1);
                dateStr = format.format(new Date());
                String filepath = String.valueOf(request.getServletContext().getRealPath("/img/head/")) + dateStr + index + "." + prefix;
                filepath = filepath.replace("\\", "/");
                final File files = new File(filepath);
                System.out.println(filepath);
                if (!files.getParentFile().exists()) {
                    files.getParentFile().mkdirs();
                }
                file.transferTo(files);
            }
        }
        catch (Exception ex) {}
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (fileInput != null) {
                    fileInput.close();
                }
            }
            catch (IOException ex2) {}
        }
        try {
            if (out != null) {
                out.close();
            }
            if (fileInput != null) {
                fileInput.close();
            }
        }
        catch (IOException ex3) {}
        Map<String, Object> map2 = new HashMap<String, Object>();
        map2 = new HashMap<String, Object>();
        map2.put("src", "/ssm_esms/img/head/" + dateStr + index + "." + prefix);
        map2.put("code", 0);
        map2.put("msg", "");
        map2.put("data", map2);
        return map2;
    }
}
