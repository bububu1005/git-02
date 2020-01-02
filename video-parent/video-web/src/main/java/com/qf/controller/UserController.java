package com.qf.controller;

import com.qf.entity.User;
import com.qf.service.UserService;
import com.qf.videos.utils.ImageCut;
import com.qf.videos.utils.MailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.Request;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/loginUser")
    @ResponseBody
    public String toLogin(User user, HttpServletRequest request){
        if(userService.toLogin(user)){
            request.getSession().setAttribute("userAccount",user.getEmail());
            return "success";
        }else{
            return "error";
        }
    }
    @RequestMapping("/forgetPassword")
    public String forgetPassword(){
        return "/jsp/before/forget_password.jsp";
    }

    @RequestMapping("/sendEmail")
    @ResponseBody
    public String sendEmail( HttpServletRequest request){
        /*发邮件*/
        String email = request.getParameter("email");
        request.getSession().setAttribute("email",email);
        MailUtils.sendMail(email,MailUtils.getValidateCode(6),"辣鸡信息");
        return "success";
    }

    @RequestMapping("/validateEmailCode")
    public String validateEmailCode(){

        return "/jsp/before/reset_password.jsp";
    }

    @RequestMapping("/resetPassword")
    public String resetPassword(String password,HttpSession session){
        /*用邮箱 改密码*/
        String email = (String) session.getAttribute("email");
        userService.updatePwd(password,email);
        return "/jsp/before/index.jsp";
    }

    @RequestMapping("/insertUser")
    @ResponseBody
    public String addUser(User user ,HttpSession session){
        /*注册*/
        userService.addUser(user);
        session.setAttribute("userAccount",user.getEmail());
        return "success";
    }
    @RequestMapping("/validateEmail")
    @ResponseBody
    public String validateEmail(String email){
            /* 注册时  查邮箱名*/
        if(userService.checkEmail(email)>0){
            return "error";
        }else {
            return "success";
        }
    }

    @RequestMapping("/showMyProfile")
    public String showMyProfile(Model model, HttpServletRequest request){
        /*点击头像  根据邮箱查询*/
        String userAccount = (String) request.getSession().getAttribute("userAccount");
        User user = userService.getUserByEmail(userAccount);
        model.addAttribute("user",user);
        return "/jsp/before/my_profile.jsp";
    }

    @RequestMapping("/changeProfile")
    public String changeProfile(Model model, HttpSession session){
        /*改资料*/
        String userAccount = (String) session.getAttribute("userAccount");
        User user = userService.getUserByEmail(userAccount);
        model.addAttribute("user",user);
        return "/jsp/before/my_profile.jsp";
    }

    @RequestMapping("/updateUser")
    public String updateUser(User user){
        /*改user信息*/
        userService.updateUserByEmail(user);
        return "redirect:/user/changeProfile";
    }

    @RequestMapping("/changeAvatar")
    public String changeAvatar(Model model , HttpSession session){
        /*去 改头像*/
        String userAccount = (String) session.getAttribute("userAccount");
        User user = userService.getUserByEmail(userAccount);
        model.addAttribute("user",user);

        return "/jsp/before/change_avatar.jsp";
    }

    @RequestMapping("/upLoadImage")
    public String upLoadImage(MultipartFile image_file, Model model ,HttpServletRequest request ,
    double x1,double y1 ,double x2, double y2) throws IOException{
        /*上传图片*/
        String path="G:\\JAVA\\a\\tomcat\\apache-tomcat-8.5.43-windows-x64 -file\\apache-tomcat-8.5.43\\webapps\\images\\";
        File file=new File(path);
        String fileName=image_file.getOriginalFilename();
        fileName= UUID.randomUUID().toString()+fileName;
        image_file.transferTo(new File(file,fileName));

        int x11 = (int) x1;
        int y11 = (int) y1;
        int x22 = (int) x2;
        int y22 = (int) y2;
        String imgUrl=path+fileName;
        new ImageCut().cutImage(imgUrl,x11,y11,x22,y22);

        String userAccount = (String) request.getSession().getAttribute("userAccount");
        userService.updateUserImg(fileName,userAccount);

        return "redirect:/user/showMyProfile";
    }

    @RequestMapping("/passwordSafe")
    public String passwordSafe(HttpSession session, Model model){
        /*密码安全*/
        String userAccount = (String) session.getAttribute("userAccount");
        User user = userService.getUserByEmail(userAccount);
        model.addAttribute("user",user);
        return "/jsp/before/password_safe.jsp";
    }

    @RequestMapping("/validatePassword")
    @ResponseBody
    public String validatePassword(String password ,HttpSession session){
        /*Ajax判断原密码*/
        String userAccount = (String) session.getAttribute("userAccount");
        if(userService.getPwdByEmail(password ,userAccount)!=null){
            return "success";
        }else{
            return "error";
        }
    }

    @RequestMapping("/updatePassword")
    public String updatePassword(String newPassword,HttpSession session){
        /*个人信息 更改密码*/
        String userAccount = (String) session.getAttribute("userAccount");
        userService.updatePwd(newPassword,userAccount);
        return "redirect:/user/showMyProfile";
    }
    @RequestMapping("/loginOut")
    public String loginOut(HttpSession session){
        /*退出登录*/
        session.invalidate();
        return "/jsp/before/index.jsp";
    }
    @RequestMapping("/loginOut2")
    public String loginOut2(HttpSession session){
        /*退出登录*/
        return "/jsp/before/index.jsp";
    }
}
