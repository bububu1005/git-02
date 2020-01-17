package com.qf.service.impl;

import com.qf.entity.Order;
import com.qf.mapper.OrderMapper;
import com.qf.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<Order> getOrder(Integer uid) {
        return orderMapper.getOrder(uid);
    }

    @Override
    public int delOrderById(Integer id) {
        return orderMapper.delOrderById(id);
    }

    @Override
    public int add(Order order) {
        return orderMapper.add(order);
    }

    @Override
    public List<Order> getAllOrder() {
        return orderMapper.getAllOrder();
    }
}
