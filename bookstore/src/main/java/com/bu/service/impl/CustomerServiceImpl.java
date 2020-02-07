package com.bu.service.impl;

import com.bu.entity.Customer;
import com.bu.mapper.CustomerMapper;
import com.bu.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public List<Customer> getCustomer() {
        return customerMapper.getCustomer();
    }

    @Override
    public int delete(Integer id) {
        return customerMapper.delete(id);
    }

    @Override
    public Customer login(String name, String pwd) {
        return customerMapper.login(name,pwd);
    }

    @Override
    public int add(Customer customer) {
        return customerMapper.add(customer);
    }
}
