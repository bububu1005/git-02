package com.qf.mapper;

import com.qf.entity.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {

    List<Order> getOrder(Integer uid);

    int delOrderById(Integer id);

    int add(Order order);

    List<Order> getAllOrder();

}
