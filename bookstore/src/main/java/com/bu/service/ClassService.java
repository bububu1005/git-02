package com.bu.service;

import com.bu.entity.Class;

import java.util.List;

public interface ClassService {

    List<Class> getAllClass();

    int add(Class aClass);

    int delete(Integer id);

    Class getById(Integer id);

    int update(Class aClass);
}
