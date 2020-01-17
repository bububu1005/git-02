package com.qf.controller;

import com.qf.entity.Order;
import com.qf.entity.User;
import com.qf.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping("/mymain")
    public String mymain(){
        //去mymain页面
        return "mymain/mymain";
    }

    @RequestMapping("/all")
    @ResponseBody
    public List<Order> all(HttpSession session){
        //显示order
        User user = (User)session.getAttribute("user");
        List<Order> all = orderService.getOrder(user.getId());
        return all;
    }

    @RequestMapping("/delete")
    public String delete(int id){
        //删除
        orderService.delOrderById(id);
        return "redirect:/order/mymain";
    }

    @RequestMapping("/add")
    @ResponseBody
    public int add(Integer getid, Integer backid ,Integer cid ,double oprice,HttpSession session){
        //添加订单
        User user = (User)session.getAttribute("user");
        int add = orderService.add(new Order(cid, user.getId(), getid, backid, oprice, "已预订"));
        return add;
    }

    @RequestMapping("/orderList")
    public String orderList(Model model){
        //order后端管理
        List<Order> orderList = orderService.getAllOrder();
        model.addAttribute("orderList",orderList);
        return "after/code/order_list";
    }

}
