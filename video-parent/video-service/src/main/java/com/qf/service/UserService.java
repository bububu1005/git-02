package com.qf.service;


import com.qf.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserService {

    boolean toLogin(User user);

    int addUser(User user);

    int checkEmail(String email);

    User getUserByEmail(String email);

    int updatePwd(String password ,String email);

    int updateUserByEmail(User user);

    int updateUserImg(String imgUrl, String email);

    User getPwdByEmail(String password ,String email);


}
