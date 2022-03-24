package cdu.ht.service;

import cdu.ht.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EmployeeService {
    List<Employee> findAll(int page,int size);
    void update(Employee employee);
    void insert(Employee employee);
    void delById(Integer id);
    List<Employee> findByDepId(Integer dep_id,int page,int size);
    List<Employee> fuzzyFind(Employee employee, int page, int size);
}
