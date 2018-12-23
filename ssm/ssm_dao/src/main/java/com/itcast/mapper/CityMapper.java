package com.itcast.mapper;

import com.itcast.domain.City;

import java.util.List;

public interface CityMapper {

    List<City> findAll() throws Exception;
}
