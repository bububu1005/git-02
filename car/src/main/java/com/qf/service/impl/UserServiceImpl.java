package com.qf.service.impl;

import com.qf.entity.User;
import com.qf.mapper.UserMapper;
import com.qf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User login(String tel, String Password) {
        return userMapper.login(tel,Password);
    }

    /*@Override
    public int update(String tel,String email,String password,Integer id) {
        return userMapper.update(tel,email,password,id);
    }*/
    @Override
    public int update(User user) {
        return userMapper.update(user);
    }

    @Override
    public int add(User user) {
        return userMapper.add(user);
    }

    @Override
    public User getById(Integer id) {
        return userMapper.getById(id);
    }

    @Override
    public List<User> getUser() {
        return userMapper.getUser();
    }

    @Override
    public int delete(Integer id) {
        return userMapper.delete(id);
    }
}
