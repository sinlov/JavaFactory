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
 * Created by sinlov on 16/10/21.
 */
public class MatchesTest {

    public static final String HEX_STR = "[0-9a-fA-Fx]{10}";

    private static void testMatches(String match, String testHexStr) {
        if (testHexStr.matches(match)) {
            System.out.println(testHexStr);
        } else {
            System.out.println("not match " + match);
        }
    }

    public static void main(String[] args) {
        String testHexStr = "0x1f23a457";
        testMatches(HEX_STR, testHexStr);
    }
}
