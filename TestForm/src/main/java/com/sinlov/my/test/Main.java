package com.sinlov.my.test;

/**
 * Created by sinlov on 16/7/28.
 */
public class Main {
    public static void main(String[] args) {
        UserInfo userInfo = new UserInfo();
        userInfo.set_id(1);
        userInfo.setName("My");
        userInfo.setClassName("mine");
        System.out.printf("userInfo: " + userInfo.toString());
    }
}
