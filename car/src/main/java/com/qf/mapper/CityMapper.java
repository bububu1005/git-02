package com.qf.mapper;

import com.qf.entity.City;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityMapper {

    City getCityById(Integer id);

    List<City> getCityByPid(Integer pid);

    int add(City city);

    int update(City city);


}
