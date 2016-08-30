package com.sinlov.my.test;

import sinlov.security.AESCBCCrypt;

/**
 * Test Security
 * Created by "sinlov" on 16/3/30.
 */
public class TestSecurity {

    public static void main(String[] args) {
        testAESCBC();
    }

    private static void testAESCBC() {
        String salt = "09hfr5yhguj*bvfr";
        System.out.println("Salt: " + salt);
        AESCBCCrypt aescbcCrypt = new AESCBCCrypt(salt);
        String testStr = "This is test AES code!";
        System.out.println("Begin: " + testStr);
        try {
            String encryptStr = aescbcCrypt.encrypt(testStr);
            System.out.println("Encrypt: " + encryptStr);
            String decrypt = aescbcCrypt.decrypt(encryptStr);
            System.out.println("Decrypt: " + decrypt);
            String response = "493a621d3a41b4893027acb4b15c84aed2a69b38276e145be62e1064871a9f61e6bfae9fd2956fd4df7f28d7373e748e2240fa19741b1d64309f5a305aaa73bb2982bfc65151407447bc5e166e83c4b2bbd1cbafd16dc77ccdcf529ac39356e59e339d18690409bc159cbf1a9561de1ceb9ac511383511fec82ea30acb51b76c9f0af285d739aee2ce24f09418eeb5ea96b93d11842158338830119643b2ac128d3c896767887d288feb0dfc8b22e38fdd45d295bee5429ec5a97a16f662d3bb86b9a349b03051df3d06d4987c8d8146f5b5e32568a734637bc24b1002faeb61186d012c3646e9d149dc6422d6e9ec8c8dc824558b437433ceb33d67c73a5503354c27202b2322e9824d3df33e879b96";
            AESCBCCrypt aescbcCryptRes = new AESCBCCrypt("c6*#e2&(g*UjX!h*");
            System.out.printf("Code is : " + aescbcCryptRes.decrypt(response));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
