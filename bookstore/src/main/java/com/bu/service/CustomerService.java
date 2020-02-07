package com.bu.service;

import com.bu.entity.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getCustomer();

    int delete(Integer id);

    Customer login(String name,String pwd);

    int add(Customer customer);
}
