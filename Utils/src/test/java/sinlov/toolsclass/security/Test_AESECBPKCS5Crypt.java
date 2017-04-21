package sinlov.toolsclass.security;


import org.junit.Test;
import sinlov.security.AESECBPKCS5Crypt;
import sinlov.security.HexUtils;

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
 * Created by sinlov on 17/1/26.
 */
public class Test_AESECBPKCS5Crypt {
    @Test
    public void test_encode() throws Exception {
        AESECBPKCS5Crypt aescbcpkcs5Crypt = new AESECBPKCS5Crypt("c6*#e2&(g*UjX!h*");
        byte[] bytes = aescbcpkcs5Crypt.encryptByte("12345678");
        String res = HexUtils.bytes2HexStr(bytes);
        System.out.println("res = " + res);
    }
    @Test
    public void test_decode() throws Exception{
        AESECBPKCS5Crypt aescbcpkcs5Crypt = new AESECBPKCS5Crypt("c6*#e2&(g*UjX!h*");
        String decode = aescbcpkcs5Crypt.decrypt("a40ae5bb2cee4f408415da4737a8436344d72245282ce8a3737f6dc625291bc5eddb3b3a94e6bf67235453f93e97a60b457b4dc33219e7a775a90551f2e74c47");
        System.out.println("decode = " + decode);
    }
}
