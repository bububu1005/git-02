package com.bu.service;

import com.bu.entity.Admin;

public interface AdminService {

    Admin login(Admin admin);

    int add(Admin admin);
}
