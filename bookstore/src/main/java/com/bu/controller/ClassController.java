package com.bu.controller;

import com.bu.entity.Class;
import com.bu.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/aClass")
public class ClassController {
    @Autowired
    private ClassService classService;

    @RequestMapping("/getClass")
    public String getClass(Model model){
        List<Class> allClass = classService.getAllClass();
        model.addAttribute("classList",allClass);
        return "after/class_manager";
    }

    @RequestMapping("/toAdd")
    public String toAdd(Model model,Integer id){
        if(id!=null) {
            Class aClass = classService.getById(id);
            model.addAttribute("aClass", aClass);
        }else{
            Class aClass = new Class();
            model.addAttribute("aClass", aClass);
        }
        return "after/add_class";
    }

    @RequestMapping("/add")
    public String add(Model model,Class aClass){
        if(aClass.getId()!=null && !aClass.getId().equals("")){
            classService.update(aClass);
        }else{
            classService.add(aClass);
        }
        return "redirect:/aClass/getClass";
    }

    @RequestMapping("/delete")
    public String delete(Integer id){
        classService.delete(id);
        return "redirect:/aClass/getClass";
    }
}
