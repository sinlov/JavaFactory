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
    public static final String HEX_MUST_BE = "^[a-zA-Z].*";

    private static void testMatches(String match, String testHexStr) {
        if (testHexStr.matches(match)) {
            System.out.println(testHexStr);
        } else {
            System.out.println("not match " + match + " |test str: " + testHexStr);
        }
    }

    public static void main(String[] args) {
        String testHexStr = "0x1f23a457";
        String testUserNameStr = "wx1f23a457@d56";
        testMatches(HEX_STR, testHexStr);
        testMatches(HEX_MUST_BE, testUserNameStr);
        String test = "{\"data\":{\"id\":1,\"email\":\"root@yougam.com\",\"username\":\"root\",\"nickname\":\"牛魔王23\",\"realname\":\"root\",\"avatar\":\"/1/9d1ab7389302a5ebe62afae3c080002dea0cb653c653d77f.png\",\"avatarLarge\":\"/1/9d1ab7389302a5ebe62afae3c080002dea0cb653c653d77f_large.jpg\",\"avatarMedium\":\"/1/9d1ab7389302a5ebe62afae3c080002dea0cb653c653d77f_medium.jpg\",\"avatarSmall\":\"/1/9d1ab7389302a5ebe62afae3c080002dea0cb653c653d77f_small.jpg\",\"birth\":1212,\"created\":1471232601,\"updated\":1473061313,\"lastSigninTime\":1477970885,\"lastSigninIp\":\"10.8.240.67\",\"topicTime\":1473854141,\"topicCount\":7,\"topicLastNid\":1,\"topicLastNode\":\"新游\",\"replyTime\":1473069213,\"replyCount\":6,\"replyLastTid\":1,\"favoriteCount\":1},\"msg\":\"success\",\"status\":1}";
    }
}
