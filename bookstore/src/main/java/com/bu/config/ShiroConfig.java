/*
package com.bu.config;

import com.bu.utils.myRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

@Configuration
public class ShiroConfig {

    @Bean
    public myRealm creatShiroRealm(){
        //创建Realm
        myRealm myRealm = new myRealm();
        return myRealm;
    }

    @Bean
    public DefaultWebSecurityManager creatSecurityManager(){
        //创建securityManager
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //引入realm
        securityManager.setRealm(creatShiroRealm());
        return securityManager;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilter(){
        //shiro过滤器
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //引入安全管理器
        shiroFilterFactoryBean.setSecurityManager(creatSecurityManager());
        //未认证跳转登录页面
        shiroFilterFactoryBean.setLoginUrl("/admin/login");
        shiroFilterFactoryBean.setLoginUrl("/customer/login");
        //设置未授权跳转页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/customer/error");
        //有顺序的map集合
        LinkedHashMap<String,String> linkedHashMap =new LinkedHashMap<>();
        //可以匿名访问
        linkedHashMap.put("/js/**","anon");
        linkedHashMap.put("/css/**","anon");
        linkedHashMap.put("/admin/login","anon");
        linkedHashMap.put("/customer/login","anon");

        //配置授权过滤器，设置未授权访问URL
        linkedHashMap.put("","");
        //配置退出
        //linkedHashMap.put("/admin/logout","logout");
        //linkedHashMap.put("/customer/logout","logout");

        //需要认证才能访问


        shiroFilterFactoryBean.setFilterChainDefinitionMap(linkedHashMap);
        return shiroFilterFactoryBean;
    }

}
*/
