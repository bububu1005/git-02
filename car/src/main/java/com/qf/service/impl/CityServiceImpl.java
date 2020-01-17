package com.qf.service.impl;

import com.qf.entity.City;
import com.qf.mapper.CityMapper;
import com.qf.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityMapper cityMapper;

    @Override
    public City getCityById(Integer id) {
        return cityMapper.getCityById(id);
    }

    @Override
    public List<City> getCityByPid(Integer pid) {
        return cityMapper.getCityByPid(pid);
    }

    @Override
    public int add(City city) {
        return cityMapper.add(city);
    }

    @Override
    public int update(City city) {
        return cityMapper.update(city);
    }
}
