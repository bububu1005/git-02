package com.qf.dao;

import com.qf.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

    int toLogin(User User);
    //注册
    int addUser(User user);

    int checkEmail(String email);

    User getUserByEmail(String email);
    //改密码
    int updatePwd(@Param("password") String password ,@Param("email") String email);
    //改user信息
    int updateUserByEmail(User user);
    //改图片
    int updateUserImg(@Param("imgUrl") String imgUrl ,@Param("email") String email);
    //Ajax判断原密码
    User getPwdByEmail(@Param("password") String password ,@Param("email") String email);
    //没用
    int updateUser(User user);
}
