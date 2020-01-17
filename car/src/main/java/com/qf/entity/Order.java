package com.qf.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order {
    private Integer id;
    private Integer cid;
    private Integer uid;
    private Integer getid;
    private Integer backid;
    private double oprice;
    private String status;
    private City getCity;
    private City backCity;
    private Car car;

    public Order(Integer cid, Integer uid, Integer getid, Integer backid, double oprice, String status) {
        this.cid = cid;
        this.uid = uid;
        this.getid = getid;
        this.backid = backid;
        this.oprice = oprice;
        this.status = status;
    }
}
