package com.bu.service.impl;

import com.bu.entity.Order;
import com.bu.mapper.OrderMapper;
import com.bu.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<Order> getOrder(Integer cid) {
        return orderMapper.getOrder(cid);
    }

    @Override
    public int getCountByCid(Integer cid) {
        return orderMapper.getCountByCid(cid);
    }

    @Override
    public int delete(Integer id) {
        return orderMapper.delete(id);
    }

    @Override
    public int deleteAll(Integer cid) {
        return orderMapper.deleteAll(cid);
    }

    @Override
    public Order getByBidCid(Integer cid, Integer bid) {
        return orderMapper.getByBidCid(cid,bid);
    }

    @Override
    public int update(Integer id) {
        return orderMapper.update(id);
    }

    @Override
    public int add(Integer cid, Integer bid) {
        return orderMapper.add(cid,bid);
    }
}
