package cdu.ht.service;

import cdu.ht.entity.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> findAll();

    void update(Department department);

    void insert(Department departemnt);

    void delById(Integer id);

    List<Department> findByName(String name);
}
