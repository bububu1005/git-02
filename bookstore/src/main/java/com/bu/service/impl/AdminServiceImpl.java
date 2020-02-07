package com.bu.service.impl;

import com.bu.entity.Admin;
import com.bu.mapper.AdminMapper;
import com.bu.service.AdminService;
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

    @Override
    public int add(Admin admin) {
        return adminMapper.add(admin);
    }
}
