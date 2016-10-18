package com.sinlov.my.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by "sinlov" on 16/3/23.
 */
public class StringTest {
    private static String REG_CHINESE = "[\\u4E00-\\u9FA5]";
    public static final String ONE = "1";

    public static boolean checkChinese(String words) {
        String[] array = words.trim().split("");
        List<String> ll = Arrays.asList(array);
        List<String> al = new ArrayList<>(ll);
        al.remove(0);
        for (int i = 0; i < al.size() - 1; i++) {
            if (!al.get(i).matches(REG_CHINESE)) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkChineseWeak(String words) {
        String[] aryStr = words.split("");
        for (int i = 0; i < aryStr.length - 1; i++) {
            String a = aryStr[i];
            if (!a.equals("")) {
                if (!a.matches(REG_CHINESE)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String words = "显示非是否是否方式方式是非   ";
        System.out.printf("Words length: " + words.trim().length() + "\n");

        if (checkChineseWeak(words.trim())) {
            System.out.printf("是中文");
        } else {
            System.out.printf("不是中文");
        }
        String a = "123456789012345";
        System.out.printf("\n" + a.substring(6, 7));
        System.out.printf("\n" + a.substring(0, 6));
        System.out.printf("\n" + Short.MAX_VALUE);
        System.out.printf("\n" + Short.MAX_VALUE * 2);
        System.out.printf("\n" + Integer.MAX_VALUE);
//        System.out.printf("\n" + Integer.valueOf(""));
//        System.out.printf("substring" + words.substring(0, 30));
        String number_one = "1";
        System.out.printf("\nis string == int: " + (ONE == number_one));
    }
}
