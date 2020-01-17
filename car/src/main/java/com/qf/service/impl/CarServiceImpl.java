package com.qf.service.impl;

import com.qf.entity.Car;
import com.qf.mapper.CarMapper;
import com.qf.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarMapper carMapper;

    @Override
    public List<Car> getCarByPrice() {
        return carMapper.getCarByPrice();
    }

    @Override
    public List<Car> getCarByNum() {
        return carMapper.getCarByNum();
    }

    @Override
    public Car getCarById(Integer id) {
        return carMapper.getCarById(id);
    }

    @Override
    public List<Car> getCar() {
        return carMapper.getCar();
    }

    @Override
    public int delete(Integer id) {
        return carMapper.delete(id);
    }

    @Override
    public int add(Car car) {
        return carMapper.add(car);
    }

    @Override
    public int update(Car car) {
        return carMapper.update(car);
    }



}
