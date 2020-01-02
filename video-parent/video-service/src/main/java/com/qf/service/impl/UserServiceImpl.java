package com.qf.service.impl;

import com.qf.dao.UserDao;
import com.qf.entity.User;
import com.qf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public boolean toLogin(User user) {
        if(userDao.toLogin(user)==1){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public int addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public int checkEmail(String email) {
        return userDao.checkEmail(email);
    }

    @Override
    public User getUserByEmail(String email) {
        return userDao.getUserByEmail(email);
    }

    @Override
    public int updatePwd(String password, String email) {
        return userDao.updatePwd(password,email);
    }

    @Override
    public int updateUserByEmail(User user) {
        return userDao.updateUserByEmail(user);
    }

    @Override
    public int updateUserImg(String imgUrl, String email) {
        return userDao.updateUserImg(imgUrl,email);
    }

    @Override
    public User getPwdByEmail(String password ,String email) {
        return userDao.getPwdByEmail(password ,email);
    }
}
