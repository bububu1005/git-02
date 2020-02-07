package com.bu.controller;

import com.bu.entity.Customer;
import com.bu.entity.Order;
import com.bu.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping("/getOrder")
    public String getOrder(Model model, HttpSession session){
        Customer customer = (Customer) session.getAttribute("customer");
        List<Order> orderList = orderService.getOrder(customer.getId());
        double price = 0;
        int num =0;
        for(Order order:orderList){
            price+=order.getBook().getPrice();
            num+=order.getNum();
        }
        System.out.println(num);
        //int num = orderService.getCountByCid(customer.getId());
        model.addAttribute("orderList",orderList);
        model.addAttribute("num",num);
        model.addAttribute("price",price);
        return "before/shopcar";
    }

    @RequestMapping("/delete")
    public String delete(Integer id){
        orderService.delete(id);
        return "redirect:/order/getOrder";
    }

    @RequestMapping("/deleteAll")
    public String deleteAll(HttpSession session){
        //清空购物车
        Customer customer = (Customer) session.getAttribute("customer");
        orderService.deleteAll(customer.getId());
        return "redirect:/order/getOrder";
    }

    @RequestMapping("/addCar")
    public String toAddCar(Integer bid,HttpSession session){
        //加入购物车
        Customer customer = (Customer) session.getAttribute("customer");
        Order order = orderService.getByBidCid(customer.getId(), bid);
        if(order!=null){
            orderService.update(order.getId());
        }else {
            orderService.add(customer.getId(),bid);
        }
        return "redirect:/order/getOrder";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "before/customer_login";
    }
}
