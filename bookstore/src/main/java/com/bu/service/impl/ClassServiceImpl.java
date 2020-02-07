package com.bu.service.impl;

import com.bu.entity.Class;
import com.bu.mapper.ClassMapper;
import com.bu.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {
    @Autowired
    private ClassMapper classMapper;

    @Override
    public List<Class> getAllClass() {
        return classMapper.getAllClass();
    }

    @Override
    public int add(Class aClass) {
        return classMapper.add(aClass);
    }

    @Override
    public int delete(Integer id) {
        return classMapper.delete(id);
    }

    @Override
    public Class getById(Integer id) {
        return classMapper.getById(id);
    }

    @Override
    public int update(Class aClass) {
        return classMapper.update(aClass);
    }
}
