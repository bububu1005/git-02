package com.qf;

import com.qf.entity.User;
import com.qf.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CarApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {

    }

}
