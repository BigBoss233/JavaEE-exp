package cdu.ht.mapper;

import cdu.ht.entity.Employee;

import java.util.List;

public interface EmployeeMapper {
    List<Employee> findAll();
    void update(Employee employee);
    void insert(Employee employee);
    void delById(Integer id);
    void delByDepId(Integer id);
    List<Employee> findByDepId(Integer dep_id);
    List<Employee> fuzzyFind(Employee employee);
}
