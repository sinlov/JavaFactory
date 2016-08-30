package com.sinlov.my.test;

/**
 * Created by sinlov on 16/7/28.
 *
 */
public class StringCopy {
    private static String chars = "sunmingkaihf";

    public static void main(String[] args) {
        String chars1 = new String(chars);
        String chars2 = null;
        String chars3 = null;
        if (chars1.length() > 3) {
            chars2 = chars.substring(8, chars1.length());
            chars3 = chars.substring(0, 3);
        }

        if (chars2.equals(chars3)) {
            System.out.print("true");
        }
    }
}
