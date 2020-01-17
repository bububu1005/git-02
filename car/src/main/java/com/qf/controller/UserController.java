package com.qf.controller;

import com.qf.entity.City;
import com.qf.entity.User;
import com.qf.service.CityService;
import com.qf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private CityService cityService;

    @RequestMapping("/index")
    public String index(HttpSession session){
        //去登录前页面
        session.invalidate();
        return "pagehome/index";
    }

    @RequestMapping("/toLogin")
    public String toLogin(){
        //去登陆页面
        return "pagehome/login";
    }

    @RequestMapping("/login")
    @ResponseBody//登录
    public User login(String tel, String password, HttpSession session){
        User user = userService.login(tel, password);
        List<City> cityList = cityService.getCityByPid(0);
        session.setAttribute("cityList",cityList);
        session.setAttribute("user",user);
        return user;
    }

    @RequestMapping("/loginsuccess")
    public String loginsuccess() {
        //去登录成功页面
        return "pagehome/loginsuccess";
    }

    @RequestMapping("/goregister")
    public String goregister() {
        //去注册页面
        return "pagehome/register";
    }

    @RequestMapping("/register")
    @ResponseBody
    public int register(User user) {
        //注册
        int add = userService.add(user);
        return add;
    }

    @RequestMapping("/myinfo")
    public String myinfo(){
        //去myinfo
        return "mymain/myinfo";
    }

    @RequestMapping("/denglu")
    @ResponseBody
    public User denglu(HttpSession session){
        //判断登录   查询显示  回显
        User user = (User) session.getAttribute("user");
        User user1 = userService.getById(user.getId());
        return user1;
    }

    @RequestMapping("/update")
    @ResponseBody
    public Integer update(HttpSession session,String tel,String email,String password){
        //修改信息
        User user = (User) session.getAttribute("user");
//        int i = userService.update(tel,email,password, user.getId());
        int i = userService.update(new User(user.getId(), tel, password, email, null));
        return i;
    }

    /*--------------------------------------------*/

    @RequestMapping("/toafterLogin")
    public String toafterLogin(){
        //去后端管理登录
        return "after/code/login";
    }

    @RequestMapping("/afterLogin")
    public String afterLogin(String tel, String password, HttpSession session){
        //去后端管理
        User user = userService.login(tel, password);
        session.setAttribute("user1",user);
        return "redirect:/car/all";
    }

    @RequestMapping("/userList")
    public String userList(Model model){
        //去后端user
        List<User> userList = userService.getUser();
        model.addAttribute("userList",userList);
        return "after/code/user_list";
    }

    @RequestMapping("/addUser")
    public String addUser(Model model,User user){
        if(user.getId()!=null && !user.getId().equals("")){
            userService.update(user);//添加user
        }else {
            userService.add(user);//修改
        }
        return "redirect:/user/userList";
    }

    @RequestMapping("/delUser")
    public String delUser(Integer id){
        //删除user
        userService.delete(id);
        return "redirect:/user/userList";
    }

    @RequestMapping("/getUserById")
    public String getUserById(Model model,Integer id){
        //查询user ById
        User user = userService.getById(id);
        model.addAttribute("user",user);
        model.addAttribute("uid",user.getId());
        return "after/code/add_user";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        //退出登录
        session.invalidate();
        return "after/code/login";
    }
}
