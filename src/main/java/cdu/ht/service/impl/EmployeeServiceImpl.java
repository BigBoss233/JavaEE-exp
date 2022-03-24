package cdu.ht.service.impl;

import cdu.ht.mapper.DepartmentMapper;
import cdu.ht.mapper.EmployeeMapper;
import cdu.ht.entity.Employee;
import cdu.ht.service.EmployeeService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeDao;
    @Autowired
    private DepartmentMapper departmentDao;

    @Override
    public List<Employee> findAll(int page,int size) {
        PageHelper.startPage(page,size);
        List<Employee> employees = employeeDao.findAll();
        for(Employee employee0:employees){
            String name = departmentDao.findById(employee0.getDep_id()).getName();
            employee0.setDep_name(name);
        }
        return employees;
    }
    @Override
    public void update(Employee employee) {
        employeeDao.update(employee);
    }

    @Override
    public void insert(Employee employee) {
        employeeDao.insert(employee);
    }

    @Override
    public void delById(Integer id) {
        employeeDao.delById(id);
    }
    @Override
    public List<Employee> findByDepId(Integer dep_id,int page,int size) {
        PageHelper.startPage(page,size);
        return employeeDao.findByDepId(dep_id);
    }

    @Override
    public List<Employee> fuzzyFind(Employee employee, int page, int size) {
        PageHelper.startPage(page,size);
        List<Employee> employees= employeeDao.fuzzyFind(employee);
        for(Employee employee0:employees){
            employee0.setDep_name(departmentDao.findById(employee0.getDep_id()).getName());
        }
        return employees;
    }
}
