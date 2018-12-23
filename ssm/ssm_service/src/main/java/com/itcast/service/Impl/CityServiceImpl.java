package com.itcast.service.Impl;

import com.itcast.domain.City;
import com.itcast.mapper.CityMapper;
import com.itcast.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityMapper cityMapper;

    @Override
    public List<City> findAll() throws Exception {
        return cityMapper.findAll();
    }
}
