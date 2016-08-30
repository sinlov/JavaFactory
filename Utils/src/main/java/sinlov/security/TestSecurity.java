package sinlov.security;

/**
 * Test Security
 * Created by "sinlov" on 16/3/30.
 */
public class TestSecurity {

    public static void main(String[] args) {
        testAESCBC();
    }

    private static void testAESCBC() {
        AESCBCCrypt aescbcCrypt = new AESCBCCrypt("09hfr5yhgujnbvfr");
        String testStr = "This is test AES code!";
        System.out.printf("Begin: " + testStr);
        try {
            String encryptStr = aescbcCrypt.encrypt(testStr);
            System.out.printf("Encrypt: " + encryptStr);
            String decrypt = aescbcCrypt.decrypt(encryptStr);
            System.out.printf("Decrypt: " + decrypt);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
