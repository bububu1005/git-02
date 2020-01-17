package com.qf.mapper;

import com.qf.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    User login(@Param("tel") String tel, @Param("password")String Password);

//    int update(@Param("tel") String tel,@Param("email")String email,@Param("password")String password, @Param("id")Integer id);
    int update(User user);
    int add(User user);

    User getById(Integer id);

    List<User> getUser();

    int delete(Integer id);

}
