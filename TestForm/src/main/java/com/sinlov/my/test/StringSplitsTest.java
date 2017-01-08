package com.sinlov.my.test;

/**
 * <pre>
 *     sinlov
 *
 *     /\__/\
 *    /`    '\
 *  ≈≈≈ 0  0 ≈≈≈ Hello world!
 *    \  --  /
 *   /        \
 *  /          \
 * |            |
 *  \  ||  ||  /
 *   \_oo__oo_/≡≡≡≡≡≡≡≡o
 *
 * </pre>
 * Created by sinlov on 16/11/22.
 */
public class StringSplitsTest {
    public static void main(String[] args) {
        String vmHard = "vbox86||ttVM_x86||nox||android_x86||universal";
        String[] splits = vmHard.split("\\|\\|");
        System.out.println(splits.length);
        for (String split : splits) {
            System.out.println(split);
        }
        String test_file_name = "pl_channel_channel_10.txt";
        if(test_file_name.contains(".")){
            System.out.println("this file is error");
        }
        String[] split = test_file_name.split("pl_channel_");
        for (String s : split) {
            System.out.println("channel_test: " + s);
        }
        System.out.println("");
    }
}
