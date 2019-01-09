package sinlov.security;

import org.junit.Assert;
import org.junit.Test;

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
 * Created by sinlov on 2019/1/8.
 */
public class DesSecretUtilsTest {

    @Test
    public void testPadding() throws Exception {
        String result = DesSecretUtils.padding("str");
        Assert.assertEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    public void testPadding2() throws Exception {
        String result = DesSecretUtils.padding("str", "chartSet");
        Assert.assertEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    public void testPadding3() throws Exception {
        byte[] result = DesSecretUtils.padding(new byte[]{(byte) 0}, 0);
        Assert.assertArrayEquals(new byte[]{(byte) 0}, result);
    }

    @Test
    public void testEncryptDESCBC() throws Exception {
        String old = "123c24wgfsq3ragq234wgwt25123123";
        byte[] result = DesSecretUtils.encryptDESCBC(old.getBytes(), "eaab78a5c2db84de");
        String hex = HexUtils.bytes2HexStr(result);
        System.out.println("hex = " + hex);
        Assert.assertNotNull(hex);
//        Assert.assertArrayEquals(new byte[]{(byte) 0}, result);
    }

    @Test
    public void testEncryptDESCBC2() throws Exception {
        byte[] result = DesSecretUtils.encryptDESCBC(new byte[]{(byte) 0}, new byte[]{(byte) 0}, "desPadding");
        Assert.assertArrayEquals(new byte[]{(byte) 0}, result);
    }

    @Test
    public void testDecodeDESCBC() throws Exception {
        byte[] result = DesSecretUtils.decodeDESCBC(new byte[]{(byte) 0}, "cryptKey");
        Assert.assertArrayEquals(new byte[]{(byte) 0}, result);
    }

    @Test
    public void testDecodeDESCBC2() throws Exception {
        byte[] result = DesSecretUtils.decodeDESCBC(new byte[]{(byte) 0}, new byte[]{(byte) 0}, "desPadding");
        Assert.assertArrayEquals(new byte[]{(byte) 0}, result);
    }

    @Test
    public void testEncodeDESECB() throws Exception {
        byte[] result = DesSecretUtils.encodeDESECB(new byte[]{(byte) 0}, new byte[]{(byte) 0}, "desPadding");
        Assert.assertArrayEquals(new byte[]{(byte) 0}, result);
    }

    @Test
    public void testDecodeDESECB() throws Exception {
        byte[] result = DesSecretUtils.decodeDESECB(new byte[]{(byte) 0}, new byte[]{(byte) 0}, "desPadding");
        Assert.assertArrayEquals(new byte[]{(byte) 0}, result);
    }

    @Test
    public void testEncrypt3DES() throws Exception {
        byte[] result = DesSecretUtils.encrypt3DES(new byte[]{(byte) 0}, "cryptKey");
        Assert.assertArrayEquals(new byte[]{(byte) 0}, result);
    }

    @Test
    public void testEncrypt3DES2() throws Exception {
        byte[] result = DesSecretUtils.encrypt3DES(new byte[]{(byte) 0}, new byte[]{(byte) 0});
        Assert.assertArrayEquals(new byte[]{(byte) 0}, result);
    }

    @Test
    public void testDecrypt3DES() throws Exception {
        byte[] result = DesSecretUtils.decrypt3DES(new byte[]{(byte) 0}, "cryptKey");
        Assert.assertArrayEquals(new byte[]{(byte) 0}, result);
    }

    @Test
    public void testDecrypt3DES2() throws Exception {
        byte[] result = DesSecretUtils.decrypt3DES(new byte[]{(byte) 0}, new byte[]{(byte) 0});
        Assert.assertArrayEquals(new byte[]{(byte) 0}, result);
    }

    @Test
    public void testEncryptDoubleDes() throws Exception {
        byte[] result = DesSecretUtils.encryptDoubleDes(new byte[]{(byte) 0}, new byte[]{(byte) 0});
        Assert.assertArrayEquals(new byte[]{(byte) 0}, result);
    }

    @Test
    public void testDecryptDoubleDes() throws Exception {
        byte[] result = DesSecretUtils.decryptDoubleDes(new byte[]{(byte) 0}, new byte[]{(byte) 0});
        Assert.assertArrayEquals(new byte[]{(byte) 0}, result);
    }

    @Test
    public void testBuild3DesKey() throws Exception {
        byte[] result = DesSecretUtils.build3DesKey("keyStr");
        Assert.assertArrayEquals(new byte[]{(byte) 0}, result);
    }

    @Test
    public void testBuild3DesKey2() throws Exception {
        byte[] result = DesSecretUtils.build3DesKey("keyStr", "chartSet");
        Assert.assertArrayEquals(new byte[]{(byte) 0}, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme