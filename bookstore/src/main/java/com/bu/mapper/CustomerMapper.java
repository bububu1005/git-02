package com.bu.mapper;

import com.bu.entity.Customer;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerMapper {

    List<Customer> getCustomer();

    int delete(Integer id);

    Customer login(@Param("name") String name,@Param("pwd") String pwd);

    int add(Customer customer);
}
