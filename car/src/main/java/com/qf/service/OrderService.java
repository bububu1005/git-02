package com.qf.service;

import com.qf.entity.Order;

import java.util.List;

public interface OrderService {

    List<Order> getOrder(Integer uid);

    int delOrderById(Integer id);

    int add(Order order);

    List<Order> getAllOrder();
}
