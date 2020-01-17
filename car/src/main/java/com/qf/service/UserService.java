package com.qf.service;

import com.qf.entity.User;

import java.util.List;

public interface UserService {
    User login(String tel,String Password);

   // int update(String tel,String email,String password,Integer id);
   int update(User user);

    int add(User user);

    User getById(Integer id);

    List<User> getUser();

    int delete(Integer id);
}
