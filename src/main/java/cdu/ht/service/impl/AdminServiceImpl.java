package cdu.ht.service.impl;

import cdu.ht.entity.Admin;
import cdu.ht.mapper.AdminMapper;
import cdu.ht.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin login(Admin admin) {
        return adminMapper.login(admin);
    }
}
