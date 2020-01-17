package com.qf.service;

import com.qf.entity.City;

import java.util.List;

public interface CityService {
    City getCityById(Integer id);

    List<City> getCityByPid(Integer pid);

    int add(City city);

    int update(City city);

}
