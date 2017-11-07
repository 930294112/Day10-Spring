package com.lanou.domain;

/**
 * Created by dllo on 17/10/23.
 */
public class Person {
    public Person() {
        System.out.println("Person无参构造方法");
    }

    //在对象构建之后调用初始化方法
    public void init(){
        System.out.println("init");
    }

    //只针对单列模式 singleton
    public void destroy(){
        System.out.println("destroy");
    }
    public void test(){
        System.out.println("你好");
    }
}
