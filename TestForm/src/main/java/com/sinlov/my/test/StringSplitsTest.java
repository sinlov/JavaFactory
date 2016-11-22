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
    }
}
