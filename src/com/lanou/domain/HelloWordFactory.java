package com.lanou.domain;

/**
 * Created by dllo on 17/10/23.
 */
public class HelloWordFactory {
    public HelloWordFactory() {
        System.out.println("静态工厂的无参构造方法");
    }

    /**
     * 静态工厂设计模式
     * 通过静态方法获取某个对象
     * @return
     */
    public static HelloWord getInstance(){
        return new HelloWord();
    }
}
