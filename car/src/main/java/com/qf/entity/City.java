package com.qf.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class City {
    private Integer id;
    private String name;
    private Integer pid;
    private String getCity;
    private String backCity;
}
