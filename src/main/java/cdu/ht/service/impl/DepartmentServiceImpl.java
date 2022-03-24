package cdu.ht.service.impl;

import cdu.ht.mapper.DepartmentMapper;
import cdu.ht.entity.Department;
import cdu.ht.mapper.EmployeeMapper;
import cdu.ht.service.DepartmentService;
import cdu.ht.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentDao;
    @Autowired
    private EmployeeMapper employeeDao;
    @Override
    public List<Department> findAll() {
        return departmentDao.findAll();
    }

    @Override
    public void update(Department department) {
        departmentDao.update(department);
    }


    @Override
    public void insert(Department department) {
        departmentDao.insert(department);
    }

    @Override
    public void delById(Integer id) {
        employeeDao.delByDepId(id);
        departmentDao.delById(id);
    }

    @Override
    public List<Department> findByName(String name) {
        return departmentDao.findByName(name);
    }
}
