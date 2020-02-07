package com.bu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Book {
    private Integer id;
    private String bookname;
    private String author;
    private Double price;
    private Integer classid;
    private String descr;
    private String path;
    private Class aClass;
}
