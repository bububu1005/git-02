package com.qf.dao;

import com.qf.entity.Admin;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AdminDao {

    int toLogin(Admin admin);
}
