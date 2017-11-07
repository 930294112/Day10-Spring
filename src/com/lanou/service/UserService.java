package com.lanou.service;

/**
 * Created by dllo on 17/10/23.
 */
public interface UserService {
    /**
     * 登录
     * @param name
     * @param password
     * @return
     */
    boolean login(String name,String password);
}
