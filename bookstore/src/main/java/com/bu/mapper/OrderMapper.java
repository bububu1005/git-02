package com.bu.mapper;

import com.bu.entity.Order;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {

    List<Order> getOrder(Integer cid);

    int getCountByCid(Integer cid);

    int delete(Integer id);

    int deleteAll(Integer cid);

    Order getByBidCid(@Param("cid") Integer cid,@Param("bid") Integer bid);

    int update(Integer id);

    int add(@Param("cid") Integer cid,@Param("bid") Integer bid);

}
