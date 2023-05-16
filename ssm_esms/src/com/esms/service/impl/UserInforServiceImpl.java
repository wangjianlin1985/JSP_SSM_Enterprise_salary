// 
// 
// 

package com.esms.service.impl;

import com.esms.po.Salary;
import java.util.List;
import com.esms.vo.EmployeeCustomVo;
import com.esms.po.Employee;
import com.esms.exception.CustomException;
import com.esms.utils.MD5Utils;
import com.esms.po.SystemManager;
import com.esms.dao.SalaryMapper;
import com.esms.dao.EmployeeCustomVoMapper;
import com.esms.dao.DepartmentMapper;
import com.esms.dao.PositionMapper;
import com.esms.dao.RankBonusMapper;
import com.esms.dao.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.esms.dao.SystemManagerMapper;
import org.springframework.stereotype.Service;
import com.esms.service.IUserInforService;

@Service
public class UserInforServiceImpl implements IUserInforService
{
    @Autowired
    private SystemManagerMapper systemManagerMapper;
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private RankBonusMapper rankBonusMapper;
    @Autowired
    private PositionMapper positionMapper;
    @Autowired
    private DepartmentMapper departmentMapper;
    @Autowired
    private EmployeeCustomVoMapper employeeCustomVoMapper;
    @Autowired
    private SalaryMapper salaryMapper;
    
    public UserInforServiceImpl() {
        this.systemManagerMapper = null;
        this.employeeMapper = null;
        this.rankBonusMapper = null;
        this.positionMapper = null;
        this.departmentMapper = null;
        this.employeeCustomVoMapper = null;
        this.salaryMapper = null;
    }
    
    @Override
    public void updateSystemManagePassword(final int id, final SystemManager systemManager) {
        this.systemManagerMapper.updateByPrimaryKey(systemManager);
    }
    
    @Override
    public void updateEmployeePassword(final int id, final String oldPassword, final String newPassword) throws CustomException {
        final Employee employee = this.employeeMapper.selectByPrimaryKey(id);
        final String encodeOld = MD5Utils.encodeByMD5(oldPassword);
        if (encodeOld.equals(employee.getePassword())) {
            final String encodeNew = MD5Utils.encodeByMD5(newPassword);
            employee.setePassword(encodeNew);
            this.employeeMapper.updateByPrimaryKeySelective(employee);
            return;
        }
        throw new CustomException("\u9358\u71b7\u7611\u942e\u4f80\u654a\u7487\ufffd");
    }
    
    @Override
    public EmployeeCustomVo getInforEmployee(final int id) {
        return this.employeeCustomVoMapper.selectEmployeeById(id);
    }
    
    @Override
    public int updateEmploueeById(final int id, final Employee employee) {
        final int i = this.employeeMapper.updateByPrimaryKeySelective(employee);
        if (i == 1) {
            return 1;
        }
        return 0;
    }
    
    @Override
    public List<Salary> getEmployeeSalaryList(final int eId, final String year) {
        if ("1".equals(year)) {
            return this.salaryMapper.selectByeId(eId);
        }
        return this.salaryMapper.selectEmployeeSalaryList(eId, year);
    }
}
