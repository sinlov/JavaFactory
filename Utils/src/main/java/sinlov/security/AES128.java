package sinlov.security;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import static java.nio.charset.StandardCharsets.UTF_8;

public class AES128 {
    public static final Charset CHARSET_DEFAULT = UTF_8;
    private static final String AES_NAME = "AES";
    private static final String AES_MODE = "AES/ECB/PKCS5Padding";

    //byte: 80 122 35 96 40 58 55 70 ............................44 74( 65 num of   v12[64]=74
    //this byte[] as c++ char* char[]
    private static final String CONFUSION_SALT = "Pz#`(:7F-a%diHm<kQDTVEKXI68loAqwsGgC42!R^ju0h@xYc][}S9B{M~+t$.>,J";

    public static byte[] encrypt(String source, String keyStr) throws Exception {
        return encrypt(source, keyStr, CHARSET_DEFAULT);
    }

    public static byte[] encrypt(String source, String keyStr, Charset charset) throws Exception {
        return encrypt(source.getBytes(charset), keyStr, charset);
    }

    public static byte[] encrypt(byte[] source, String keyStr) throws Exception {
        return encrypt(source, keyStr, CHARSET_DEFAULT);
    }

    /**
     * 加密
     *
     * @param source
     * @param keyStr 原始秘钥字符串，注意不是最终的秘钥
     * @return 加密后的字节数组
     * @throws KeyLengthException 如果秘钥长度不为16则抛出
     */
    public static byte[] encrypt(byte[] source, String keyStr, Charset charset) throws Exception {
        byte[] key = getKey(keyStr, charset);
        if (key == null || key.length != 16) {
            throw new KeyLengthException();
        }
        Cipher cipher = Cipher.getInstance(AES_MODE);
        SecretKeySpec keySpec = new SecretKeySpec(key, AES_NAME);
        cipher.init(Cipher.ENCRYPT_MODE, keySpec);
        return cipher.doFinal(source);
    }

    public static byte[] decrypt(String encoded, String keyStr) throws Exception {
        return decrypt(encoded, keyStr, CHARSET_DEFAULT);
    }

    public static byte[] decrypt(String encoded, String keyStr, Charset charset) throws Exception {
        return decrypt(encoded.getBytes(charset), keyStr, charset);
    }

    public static byte[] decrypt(byte[] encoded, String keyStr) throws Exception {
        return decrypt(encoded, keyStr, CHARSET_DEFAULT);
    }

    /**
     * 解密
     *
     * @param encoded
     * @param keyStr  原始秘钥字符串，注意不是最终的秘钥
     * @return 解密后的字节数组
     * @throws KeyLengthException 如果秘钥长度不为16则抛出
     */
    public static byte[] decrypt(byte[] encoded, String keyStr, Charset charset) throws Exception {
        byte[] key = getKey(keyStr, charset);
        if (key == null || key.length != 16) {
            throw new KeyLengthException();
        }
        Cipher cipher = Cipher.getInstance(AES_MODE);
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key, AES_NAME));
        return cipher.doFinal(encoded);
    }

    /**
     * Pass keyStr through SHA256 and then take 128bit as the secret key
     * if keyStr not 16 will return null
     *
     * @param keyStr  key string
     * @param charset charset
     * @return secret key
     */
    private static byte[] getKey(String keyStr, Charset charset) {
        byte[] raw = keyStr.getBytes(charset);
        if (raw.length < 16) {
            return null;
        }
        MessageDigest sha = null;
        try {
            // SHA-256 can replace to SHA-1
            sha = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] key = sha.digest(raw);
        key = Arrays.copyOf(key, 16); // use only first 128 bit
        return key;
    }

    /**
     * Returns the hexadecimal string of the byte array
     *
     * @param array byte array
     * @return hexadecimal string
     */
    public static String byte2Hex(byte[] array) {
        StringBuilder strHexString = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            String hex = Integer.toHexString(0xff & array[i]);
            if (hex.length() == 1) {
                strHexString.append('0');
            }
            strHexString.append(hex);
        }
        return strHexString.toString();
    }

    /**
     * confusion raw
     *
     * @param raw raw for confusion
     * @return confused bytes
     */
    public static byte[] confusion(byte[] raw) {
        int v13 = raw.length;
        byte[] ebbytes = raw;
        byte[] v11 = new byte[((v13 + 2) / 3) * 4];// Use byte array directly here
        for (int i = 0; i < v13; i += 3) {
            int v9 = 0;
            for (int j = i; j < i + 3; ++j) {
                v9 <<= 8;
                if (j < v13)
                    v9 |= ebbytes[j] & 0xFF;//unsigned char to int
            }
            byte[] v12 = CONFUSION_SALT.getBytes();
            //0
            v11[4 * (i / 3)] = v12[((v9 >> 18) & 0x3F)];
            //1
            v11[4 * (i / 3) + 1] = v12[((v9 >> 12) & 0x3F)];
            //2
            byte v7;
            if (i + 1 >= v13)
                v7 = v12[64];
            else {
                v7 = v12[((v9 >> 6) & 0x3F)];
            }
            v11[4 * (i / 3) + 2] = v7;
            //3
            byte v6;
            if (i + 2 >= v13)
                v6 = v12[64];
            else {
                v6 = v12[(v9 & 0x3F)];
            }
            v11[4 * (i / 3) + 3] = v6;
        }
        return v11;
    }

    public static byte[] disConfusion(byte[] confused) {
        int a1 = 0;
        byte v6 = 0;
        byte v7 = 0;
        byte v8 = 0;
        byte v9 = 0;
        byte v10 = 0;
        byte v11 = 0;
        byte v12 = 0;
        byte[] v15 = CONFUSION_SALT.getBytes(UTF_8);
        v15 = Arrays.copyOf(v15, v15.length + 1);
        v15[v15.length - 1] = 0;
        byte[] v16 = confused;
        int a3 = v16.length;
        int v14 = a3 / 4;
        a1 = 3 * ((int) a3 / 4);
        byte[] v13 = new byte[a1];
        for (int i = 0; i < v14; ++i) {
            //v6 = strchr(v15, *(char *)(v16 + 4 * i));
            int index1 = indexOfByte(v15, v16[4 * i]);
            if (index1 == -1) {
                return null;
            }
            v6 = v15[index1];
            v12 = (byte) ((4 * index1));
            int index2 = indexOfByte(v15, v16[4 * i + 1]);
            if (index2 == -1) {
                return null;
            }
            v7 = v15[index2];
            v11 = (byte) (index2);
            v13[3 * i] = (byte) (v12 + ((index2 & 0x30) >> 4));

            int index3 = indexOfByte(v15, v16[4 * i + 2]);
            if (index3 == -1) {
                return null;
            }
            v8 = v15[index3];
            if (index3 == 64) {
                a1 = 3 * i + 1;
                return Arrays.copyOf(v13, a1);
            }
            v10 = (byte) (index3);
            v13[3 * i + 1] = (byte) (16 * v11 + ((index3 & 0x3C) >> 2));
            int index4 = indexOfByte(v15, v16[4 * i + 3]);
            if (index4 == -1) {
                return null;
            }
            v9 = v15[index4];
            if (index4 == 64) {
                a1 = 3 * i + 2;
                return Arrays.copyOf(v13, a1);
            }
            v13[3 * i + 2] = (byte) ((v10 << 6) + index4);

        }
        return v13;
    }

    private static int indexOfByte(byte[] source, byte target) {
        for (int j = 0; j < source.length; j++) {
            if (source[j] == target) {
                return j;
            }
        }
        return -1;
    }

    public static class KeyLengthException extends Exception {
        public KeyLengthException() {
            super("key length exception not 16");
        }
    }

    private AES128() {
    }
}
