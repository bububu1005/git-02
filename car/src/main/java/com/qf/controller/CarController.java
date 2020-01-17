package com.qf.controller;

import com.qf.entity.Car;
import com.qf.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/car")
public class CarController {
    @Autowired
    private CarService carService;

    @RequestMapping("/number")
    @ResponseBody
    public List<Car> number(){
        //热度查
        List<Car> carByNum = carService.getCarByNum();
        return carByNum;
    }

    @RequestMapping("/price")
    @ResponseBody
    public List<Car> price(){
        //价格查
        List<Car> carByPrice = carService.getCarByPrice();
        return carByPrice;
    }

    @RequestMapping("/findcar")
    @ResponseBody
    public Car findcar(Integer cid){
        //查车
        Car car = carService.getCarById(cid);
        return car;
    }

    @RequestMapping("/all")
    public String all(Model model){
        //显示car
        List<Car> carList = carService.getCar();
        model.addAttribute("carList",carList);
        return "after/code/car_list";
    }

    @RequestMapping("/delete")
    public String delete(Integer id){
        //删除
        int i = carService.delete(id);
        return "redirect:/car/all";
    }

    @RequestMapping("/batchDelete")
    public String batchDelete(String ids){
        //批量删除
        String[] strid = ids.split(",");
        for(String i : strid){
            carService.delete(Integer.parseInt(i));
        }
        return "redirect:/car/all";
    }

    @RequestMapping("/add")
    public String add(Car car){
        if(car.getId()!=null && !car.getId().equals("")){
            carService.update(car);//修改
        }else {
            carService.add(car);//添加
        }
        return "redirect:/car/all";
    }

    @RequestMapping("/getById")
    public String getById(Integer id,Model model){
        //查询ById
        Car car = carService.getCarById(id);
        model.addAttribute("car",car);
        model.addAttribute("cid",car.getId());
        return "after/code/add_car";
    }


}
