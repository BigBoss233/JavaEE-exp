package cdu.ht.mapper;

import cdu.ht.entity.Admin;
import org.apache.ibatis.annotations.Mapper;


public interface AdminMapper {
    Admin login(Admin admin);
}
