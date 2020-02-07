package com.bu.service;

import com.bu.entity.Order;

import java.util.List;

public interface OrderService {

    List<Order> getOrder(Integer cid);

    int getCountByCid(Integer cid);

    int delete(Integer id);

    int deleteAll(Integer cid);

    Order getByBidCid(Integer cid,Integer bid);

    int update(Integer id);

    int add(Integer cid,Integer bid);
}
