package com.bu.controller;

import com.bu.entity.Customer;
import com.bu.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @RequestMapping("/getCustomer")
    public String getBook(Model model){
        List<Customer> customerList = customerService.getCustomer();
        model.addAttribute("customerList",customerList);
        return "after/customer_manager";
    }

    @RequestMapping("/delete")
    public String delete(Integer id){
        customerService.delete(id);
        return "redirect:/customer/getCustomer";
    }
        /*----------------*/
    @RequestMapping("/login")
    @ResponseBody
    public String login(Customer customer, HttpSession session){
        Customer customer1 = customerService.login(customer.getName(), customer.getPwd());
        if(customer1!=null){
            session.setAttribute("customer",customer1);
            return "success";
        }else{
            return "error";
        }
    }
    @RequestMapping("/register")
    public String register(Customer customer){
        customerService.add(customer);//此处可以使用cookie
        return "before/customer_login";
    }

}
