// 
// 
// 

package com.esms.service;

import org.springframework.web.multipart.MultipartFile;

public interface IImportDataService
{
    String insertMATable(MultipartFile p0) throws Exception;
    
    String insertReissueTable(MultipartFile p0) throws Exception;
}
