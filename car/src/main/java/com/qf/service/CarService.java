package com.qf.service;

import com.qf.entity.Car;

import java.util.List;

public interface CarService {

    List<Car> getCarByPrice();

    List<Car> getCarByNum();

    Car getCarById(Integer id);

    List<Car> getCar();

    int delete(Integer id);

    int add(Car car);

    int update(Car car);

}
