package com.bu.mapper;

import com.bu.entity.Class;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassMapper {

    List<Class> getAllClass();

    int add(Class aClass);

    int delete(Integer id);

    Class getById(Integer id);

    int update(Class aClass);
}
