package com.itcast.controller;

import com.itcast.domain.City;
import com.itcast.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/city")
public class CityController {
    @Autowired
    private CityService cityService;

    @RequestMapping("/findAll")
    public @ResponseBody List<City> findAll() throws Exception{
        List<City> citys = cityService.findAll();
        return citys;
    }
}
