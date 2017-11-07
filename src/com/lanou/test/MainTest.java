package com.lanou.test;

import com.lanou.domain.HelloWord;
import com.lanou.domain.HelloWordFactory2;
import com.lanou.domain.Person;
import com.lanou.domain.Student;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by dllo on 17/10/23.
 */
public class MainTest {

    private ApplicationContext applicationContext;

    @Before
    public void init(){
        //获得Spring容器对象
        applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");

    }

    /**
     * 测试最基础的IOC inverse Of control
     * 1.在Spring配置文件中定义的bean默认情况下会在new applicationContext容器对象时
     * 调用bean默认无参的构造方法创建对象,并将对象后加入到spring容器中,以供后序的getBean()方法调用
     * 2.加入Spring容器的对象默认情况下是单列模式,即整个应用只创建一次该对象
     */
    @Test
    public void testHello(){
        //从容器中获得id为helloWord的对象
       HelloWord helloWord = (HelloWord) applicationContext.getBean("helloWord");
       //调用sayHello方法
        helloWord.sayHello();
        System.out.println("第一次调用:"+ helloWord.hashCode());

        //再次获取
        HelloWord helloWord1 = (HelloWord)applicationContext.getBean("helloWord");
        System.out.println("第二次调用:" + helloWord1.hashCode());
    }

    /**
     * 静态工厂设计模式的测试
     */
    @Test
    public void testFactory(){
        //通过工厂类id获得bean对象
        HelloWord helloWord = (HelloWord) applicationContext.getBean("helloWordFactory");
        //调用bean中的方法
        helloWord.sayHello();
    }

    /**
     * 通过实例工厂的方式获得helloword对象
     */
    @Test
    public void testFactory2(){
        //先获得实例工厂类对象
        HelloWordFactory2 helloWordFactory2 = (HelloWordFactory2) applicationContext.getBean("helloWordFactory2");
        //通过实例工厂类对象获得HelloWord对象
        HelloWord helloWord = helloWordFactory2.getInstance();
        helloWord.sayHello();
    }

    /**
     * 实例工厂模式的完整写法
     * 1.实例工厂对象的创建,需要在Spring配置文件中先配置实例工厂类对象,
     * 2在配置具体的bean引用,其中Factory-bean:指向示例工厂类的bean id
     * 3Factory-method:指向实例工厂类获得bean的方法,例如:getInstance方法
     * 4在代码中就可以直接获得bean对象,不用在获得实例工厂类的对象
     * 5实例工厂模式会先进入工厂的无参构造方法,然后才能进入某个bean对象的构造方法,即此模式创建了两个对像,而静态工厂的模式只会创建一个对象
     */
    @Test
    public void testFactory3(){
        HelloWord helloWord = (HelloWord) applicationContext.getBean("helloWord2");
        helloWord.sayHello();
    }

    /**
     * 测试加载属性 lazy-init
     */
    @Test
    public void testLazy(){
        Person person = (Person) applicationContext.getBean("person");
        person.test();//调用普通方法

        //关闭Spring容器 触发bean中的destroy方法
        ((ClassPathXmlApplicationContext) applicationContext).close();

    }

    /**
     * 测试依赖注入
     */
    @Test
    public void testDI(){
        /*1.测试通过构造方法注入*/
        Student student = (Student) applicationContext.getBean("student");
        System.out.println(student);
//        输出引入其他对象的属性
        System.out.println(student.getPerson());
    }
}
