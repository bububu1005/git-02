package com.bu.controller;

import com.bu.entity.Admin;
import com.bu.service.AdminService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("/login")
    @ResponseBody
    public String login(Admin admin, HttpSession session){
        /*//存储输入的用户名密码
        UsernamePasswordToken token = new UsernamePasswordToken(admin.getName(), admin.getPwd());
        //主体对象
        Subject subject = SecurityUtils.getSubject();
        try {
            //登陆判断
            subject.login(token);
            //认证成功跳转到主页
            System.out.println("111");
            Admin admin1 = adminService.login(admin);
            session.setAttribute("admin",admin1);
            return "success";
        }catch (UnknownAccountException e) {
            return "error";
        }*/
        Admin admin1 = adminService.login(admin);
        if(admin1!=null){
            session.setAttribute("admin",admin1);
            return "success";
            }else{
                return "error";
            }
    }

    @RequestMapping("/register")
    public String register(Admin admin){
        adminService.add(admin);//此处可以使用cookie
        return "after/admin_login";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "after/admin_login";
    }
}
