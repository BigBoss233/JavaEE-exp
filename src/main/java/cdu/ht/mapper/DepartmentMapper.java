package cdu.ht.mapper;

import cdu.ht.entity.Department;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


public interface DepartmentMapper {
    List<Department> findAll();
    void update(Department department);
    List<Department> findByName(String department);
    void insert(Department departemnt);
    Department findById(Integer id);
    void delById(Integer id);
}
