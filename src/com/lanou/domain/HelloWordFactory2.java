package com.lanou.domain;

/**
 * Created by dllo on 17/10/23.
 */
public class HelloWordFactory2 {
    public HelloWordFactory2() {
        System.out.println("实例方法无参构造方法");
    }

    /**
     * 实例工厂返回 返回某个对象
     * @return
     */
    public HelloWord getInstance(){
        return new HelloWord();
    }
}
