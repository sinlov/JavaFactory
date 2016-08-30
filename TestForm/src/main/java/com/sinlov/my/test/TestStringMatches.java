package com.sinlov.my.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by "sinlov" on 16/6/20.
 */
public class TestStringMatches {
    private static final String MATCHES_URL = "^https?://(([a-zA-Z0-9_-])+(\\.)?)*(:\\d+)?(/((\\.)?(\\?)?=?&?[a-zA-Z0-9_-](\\?)?)*)*$";
    private static final String MATCHES_URL_HTTP = "^http://[\\w\\.\\-]+(?:/|(?:/[\\w\\.\\-]+)*)?$";
    private static final String MATCHES_URL_SHOT = "[http|https|ftp]+[://]+[0-9A-Za-z/[-|:]_#[?][=][.][&]]*";
    private static final String MATCHES_NUMBER = "^\\d+$";

    public static void main(String[] args) {
        String testURL_1 = "http://7xq9mm.com1.z0.glb.clouddn.com/0eaa9c87430845c198b701b6db748027";
        String testURL_2 = "http://7xq9mm.com1.z0.glb.clouddn.com/o_1akllp7dp1d8i8b0hrh12r219te2d.apk";
        String testURL_3 = "http://7xq9mm.com1.z0.glb.clouddn.com/o_1aklt7ih6162jin9togra47eg2d.jpg";
        String testURL_4 = "http://www.sogou.com/web?query=java+url%E6%AD%A3%E5%88%99%E8%A1%A8%E8%BE%BE%E5%BC%8F&ie=utf8&_ast=1466386304&_asf=null&w=01025001&p=40040100&dp=1&cid=&cid=&oq=java+URL+z&ri=1&sourceid=sugg&suguuid=a0877f9e-d4cd-4858-83a8-02cf977c5685&stj=1%3B0%3B0%3B0&stj2=0&stj0=1&stj1=0&hp=0&hp1=&sut=5706&sst0=1466390213443&lkt=10%2C1466390209397%2C1466390211559";
        String testURL_5 = "http://10.8.240.80:8082/app-debug.apk";
        System.out.println(testURL_1.matches(MATCHES_URL));
        System.out.println(testURL_2.matches(MATCHES_URL));
        System.out.println(testURL_3.matches(MATCHES_URL));
        System.out.println(testURL_4.matches(MATCHES_URL));
        System.out.println(testURL_5.matches(MATCHES_URL));

        System.out.println("-------------");

        System.out.println(testURL_1.matches(MATCHES_URL_SHOT));
        System.out.println(testURL_2.matches(MATCHES_URL_SHOT));
        System.out.println(testURL_3.matches(MATCHES_URL_SHOT));
        System.out.println(testURL_4.matches(MATCHES_URL_SHOT));
        System.out.println(testURL_5.matches(MATCHES_URL_SHOT));
        System.out.println("=========");

        System.out.println("1234".matches(MATCHES_NUMBER));
    }
}
