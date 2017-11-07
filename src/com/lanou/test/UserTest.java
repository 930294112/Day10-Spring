package com.lanou.test;

import com.lanou.action.UserAction;
import com.lanou.dao.UserDao;
import com.lanou.dao.impl.UserDaoImpl;
import com.lanou.service.UserService;
import com.lanou.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by dllo on 17/10/23.
 */
public class UserTest {
    @Test
    public void test(){
        //1.先获得action对象
        UserAction userAction = new UserAction();
        UserServiceImpl userService = new UserServiceImpl();
        UserDaoImpl userDao = new UserDaoImpl();
        userService.setUserDao(userDao);
        userAction.setUserService(userService);
        //2.调用action的登录方法:action-->service(impl)-->dao(impl)
        userAction.login();
    }

    /**
     * 测试xml注入的方式
     */
    @Test
    public void testXmlDI(){
        //启动Spring容器
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring-user.xml"});//加载多个Spring配置文件
        //通过Spring容器中的getBean方法返货action对象
        UserAction action = (UserAction) context.getBean("userAction");
        //调用action中登录的方法
        String result = action.login();
        System.out.println(result);
    }

    /**
     * 利用注解的方式实现ioc和DI(依赖注入)
     */
    @Test
    public void testAnnotation(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-user-annotation.xml");
        //获得action对象
        UserAction userAction = (UserAction) context.getBean("userAction");
        //调用action中的方法
        System.out.println(userAction.login());
    }
}
