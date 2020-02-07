package com.bu.mapper;

import com.bu.entity.Admin;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminMapper {

    Admin login(Admin admin);

    int add(Admin admin);

}
