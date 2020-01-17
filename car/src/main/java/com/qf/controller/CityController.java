package com.qf.controller;

import com.qf.entity.City;
import com.qf.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityService cityService;

    @RequestMapping("/goCar")
    public String goCar(){
        //去shortrent页面
        return "shortRent/shortrent";
    }

    @RequestMapping("/select")
    @ResponseBody
    public List<City> select(Integer pid, HttpSession session){
        //下拉框
        List<City> cityList = cityService.getCityByPid(pid);
        return cityList;
    }

    @RequestMapping("/citys")
    @ResponseBody
    public Map<String,City> citys(Integer getid, Integer backid){
        //取车地 还车地
        City getCity = cityService.getCityById(getid);
        City backCity = cityService.getCityById(backid);

        Map<String,City> citys=new HashMap<>();
        citys.put("getCity",getCity);
        citys.put("backCity",backCity);

        return citys;
    }

    @RequestMapping("/cityList")
    public String cityList(Model model){
        //后端管理city
        List<City> cityList = cityService.getCityByPid(null);
        model.addAttribute("cityList",cityList);
        return "after/code/city_list";
    }

    @RequestMapping("/add")
    public String add(City city){
        if(city.getId()!=null && !city.getId().equals("")){
            cityService.update(city);//修改city
        }else{
            cityService.add(city);//添加city
        }
        return "redirect:/city/cityList";
    }

    @RequestMapping("/getById")
    public String getById(Model model ,Integer id){
        //Byid查询city
        City city = cityService.getCityById(id);
        model.addAttribute("city",city);
        return "after/code/add_city";
    }



}
