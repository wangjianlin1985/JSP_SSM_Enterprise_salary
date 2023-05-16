// 
// 
// 

package com.esms.service.impl;

import com.esms.po.SystemManager;
import com.esms.exception.CustomException;
import com.esms.utils.MD5Utils;
import com.esms.po.Employee;
import com.esms.dao.SystemManagerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.esms.dao.EmployeeMapper;
import org.springframework.stereotype.Service;
import com.esms.service.ILoginService;

@Service
public class LoginServiceImpl implements ILoginService
{
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private SystemManagerMapper systemManagerMapper;
    
    public LoginServiceImpl() {
        this.employeeMapper = null;
        this.systemManagerMapper = null;
    }
    
    @Override
    public Employee findEmployeeByIdAndPassword(final String account, final String password) throws CustomException {
        final String encode = MD5Utils.encodeByMD5(password);
        final Employee employee = new Employee();
        employee.seteAccount(account);
        employee.setePassword(encode);
        employee.seteIsdel(1);
        final Employee employee2 = this.employeeMapper.selectByAccountAndPassword(employee);
        if (employee2 == null) {
            throw new CustomException("\u5bb8\u30e5\u5f7f\u93b4\u6827\u7611\u942e\u4f80\u654a\u7487\ufffd");
        }
        return employee2;
    }
    
    @Override
    public SystemManager findSystemManagerByIdAndPassword(final String account, final String password) throws CustomException {
        final String encode = MD5Utils.encodeByMD5(password);
        final SystemManager systemManager = new SystemManager();
        systemManager.setSmAccount(account);
        systemManager.setSmPassword(encode);
        final SystemManager systemManager2 = this.systemManagerMapper.selectByAccountAndPassword(systemManager);
        if (systemManager2 == null) {
            throw new CustomException("\u7ee0\uff04\u608a\u935b\u6a3f\u5904\u9359\u950b\u57a8\u7035\u55d9\u721c\u95bf\u6b12\ue1e4");
        }
        return systemManager2;
    }
    
    @Override
    public Employee findEmployeeById(final int id) {
        return this.employeeMapper.selectByPrimaryKey(id);
    }
    
    @Override
    public SystemManager findSystemManagerById(final int id) {
        return this.systemManagerMapper.selectByPrimaryKey(id);
    }
}
