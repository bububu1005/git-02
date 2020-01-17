package com.qf.mapper;

import com.qf.entity.Car;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarMapper {

    List<Car> getCarByPrice();

    List<Car> getCarByNum();

    Car getCarById(Integer id);

    List<Car> getCar();

    int delete(Integer id);

    int add(Car car);

    int update(Car car);

    List<Car> getByLike(String name);

    int getCount();

}
