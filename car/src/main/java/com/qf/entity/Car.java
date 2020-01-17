package com.qf.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Car {
    private Integer id;
    private String name;
    private String type;
    private Integer sitnum;
    private Integer cid;
    private double price;
    private Integer number;
    private String picture;
}
