package com.lanou.action;

import com.lanou.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

/**
 * Created by dllo on 17/10/23.
 */

/**
 * @Controller :action层的注解
 * @Scope:action层中的对象定义需要声明为每次自动创建
 */
@Controller("userAction")
@Scope("prototype")
public class UserAction {
    //service层的访问对象
    /**
     * bean中的输出注入
     */
    @Qualifier("userService")
    @Autowired
    private UserService userService;
    /**
     * 登录方法
     * @return
     */
    public String login(){
        //调用service层的登录方法
        if (userService.login("张三","1234")){
            return "success";
        }else {
            return "error";
        }

    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }


}
