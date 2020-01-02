package com.qf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;

import java.util.Random;

@Controller
public class VerificationCode {

    @RequestMapping("/getCode")
    public String getCode(){
        String code="";
        for (int i =0 ; i<6 ;i++){
            int num = new Random().nextInt(10);
            code+=num;
        }
        System.out.println(code);
        return code;
    }

    @RequestMapping("/sendCode")
    @ResponseBody
    public String sendCode(String phone){
        System.out.println(phone);
        String code = getCode();
        Jedis jedis=new Jedis("192.168.211.131",6379);
        jedis.setex("code",30,code);
        return "success";
    }

    @RequestMapping("/verificationCode")
    @ResponseBody
    public String verificationCode(String verification_code){
        System.out.println(verification_code);
        Jedis jedis = new Jedis("192.168.228.135",6379);
        String code = jedis.get("code");
        if(code.equals(verification_code)){
            return "success";
        }else{
            return "error";
        }
    }


}
