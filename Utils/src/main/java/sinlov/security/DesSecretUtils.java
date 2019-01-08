package sinlov.security;

import java.io.UnsupportedEncodingException;
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by "sinlov" on 17/5/11.
 */
public final class DesSecretUtils {

    public static final String ALGORITHM_DES_PADDING_CBC_PKCS5 = "DES/CBC/PKCS5Padding";
    public static final String ALGORITHM_DES_PADDING_ECB_NoPadding = "DES/ECB/NoPadding";
    public static final String ALGORITHM_3DES_PADDING = "DESede/ECB/NoPadding";

    private static final String DEFAULT_CHART_SET = "UTF-8";
    private static final String ALGORITHM_DES = "DES";
    private static final byte[] ALGORITHM_DES_IV = "01234567".getBytes();

    private static final String ALGORITHM_3DES = "DESede";

    public static String padding(String str) {
        return padding(str, DEFAULT_CHART_SET);
    }

    public static String padding(String str, String chartSet) {
        try {
            byte[] oldByteArray = str.getBytes(chartSet);
            byte[] newByteArray = padding(oldByteArray, 8);
            return new String(newByteArray, chartSet);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static byte[] padding(byte[] wantPadding, int length) {
        int numberToPad = length - wantPadding.length % length;
        byte[] newByteArray = new byte[wantPadding.length + numberToPad];
        System.arraycopy(wantPadding, 0, newByteArray, 0,
                wantPadding.length);
        for (int i = wantPadding.length; i < newByteArray.length; ++i) {
            newByteArray[i] = 0;
        }
        return newByteArray;
    }

    /**
     * key must gather than 8byte and use chart {@link #DEFAULT_CHART_SET} and {@link #ALGORITHM_DES_PADDING_CBC_PKCS5}
     *
     * @param src      dataArray
     * @param cryptKey keyString
     * @return
     * @throws UnsupportedEncodingException
     */
    public static byte[] encryptDESCBC(byte[] src, String cryptKey) throws UnsupportedEncodingException {
        if (cryptKey == null) {
            throw new NullPointerException("des cryptKey must not null");
        } else {
            byte[] cryptBytes = cryptKey.getBytes(DEFAULT_CHART_SET);
            if (cryptBytes.length < 8) {
                throw new IllegalArgumentException("des cryptKey must gather than 8 byte");
            } else {
                return encryptDESCBC(src, cryptBytes, ALGORITHM_DES_PADDING_CBC_PKCS5);
            }
        }
    }

    /**
     * key must gather than 8byte and
     *
     * @param src        dataArray
     * @param cryptKey   keyArray
     * @param desPadding
     * @return can be null !
     */
    public static byte[] encryptDESCBC(byte[] src, byte[] cryptKey, String desPadding) {
        try {
            DESKeySpec dks = new DESKeySpec(cryptKey);
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM_DES);
            Key secretKey = keyFactory.generateSecret(dks);
            Cipher cipher = Cipher.getInstance(desPadding);
            IvParameterSpec iv = new IvParameterSpec(ALGORITHM_DES_IV);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);
            return cipher.doFinal(src);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static byte[] decodeDESCBC(byte[] src, String cryptKey) throws UnsupportedEncodingException {
        if (cryptKey == null) {
            throw new NullPointerException("des cryptKey must not null");
        } else {
            byte[] cryptBytes = cryptKey.getBytes(DEFAULT_CHART_SET);
            if (cryptBytes.length < 8) {
                throw new IllegalArgumentException("des cryptKey must gather than 8 byte");
            } else {
                return decodeDESCBC(src, cryptBytes, ALGORITHM_DES_PADDING_CBC_PKCS5);
            }
        }
    }

    public static byte[] decodeDESCBC(byte[] src, byte[] cryptKey, String desPadding) {
        try {
            DESKeySpec dks = new DESKeySpec(cryptKey);
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM_DES);
            Key secretKey = keyFactory.generateSecret(dks);
            Cipher cipher = Cipher.getInstance(desPadding);
            IvParameterSpec iv = new IvParameterSpec(ALGORITHM_DES_IV);
            cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);
            return cipher.doFinal(src);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static byte[] encodeDESECB(byte[] src, byte[] cryptKey, String desPadding) {
        try {
            DESKeySpec dks = new DESKeySpec(cryptKey);
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM_DES);
            Key secretKey = keyFactory.generateSecret(dks);
            Cipher cipher = Cipher.getInstance(desPadding);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return cipher.doFinal(src);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static byte[] decodeDESECB(byte[] src, byte[] cryptKey, String desPadding) {
        try {
            DESKeySpec dks = new DESKeySpec(cryptKey);
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM_DES);
            Key secretKey = keyFactory.generateSecret(dks);
            Cipher cipher = Cipher.getInstance(desPadding);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return cipher.doFinal(src);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * encrypt
     *
     * @param src      dataArray
     * @param cryptKey keyString
     * @return can be null !
     */
    public static byte[] encrypt3DES(byte[] src, String cryptKey) {
        try {
            return encrypt3DES(src, build3DesKey(cryptKey));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * encrypt
     *
     * @param src      dataArray
     * @param cryptKey keyByte
     * @return can be null !
     */
    public static byte[] encrypt3DES(byte[] src, byte[] cryptKey) {
        try {
            SecretKey desKey = new SecretKeySpec(cryptKey
                    , ALGORITHM_3DES);
            Cipher cipher = Cipher.getInstance(ALGORITHM_3DES_PADDING);
            cipher.init(Cipher.ENCRYPT_MODE, desKey);
            return cipher.doFinal(src);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * decrypt with 3DES
     *
     * @param src      dataArray
     * @param cryptKey {@link String} keyString
     * @return can be null !
     */
    public static byte[] decrypt3DES(byte[] src, String cryptKey) {
        try {
            return decrypt3DES(src, build3DesKey(cryptKey));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * decrypt with 3DES
     *
     * @param src      dataArray
     * @param cryptKey keyByte
     * @return can be null !
     */
    public static byte[] decrypt3DES(byte[] src, byte[] cryptKey) {
        try {
            DESedeKeySpec spec = new DESedeKeySpec(cryptKey);
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM_3DES);
            SecretKey desKey = keyFactory.generateSecret(spec);
            Cipher cipher = Cipher.getInstance(ALGORITHM_3DES_PADDING);
            cipher.init(Cipher.DECRYPT_MODE, desKey);
            return cipher.doFinal(src);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static byte[] encryptDoubleDes(byte[] src, byte[] cryptKey) {
        if (cryptKey.length != 32) {
            throw new IllegalArgumentException("double des key size must be 32!");
        }
        byte[] key21 = new byte[16];
        System.arraycopy(cryptKey, 0, key21, 0, 16);
        byte[] key22 = new byte[16];
        System.arraycopy(cryptKey, 16, key22, 0, 16);
        byte[] tmp1 = encodeDESECB(src, key21, ALGORITHM_DES_PADDING_ECB_NoPadding);
        byte[] tmp2 = decodeDESECB(tmp1, key22, ALGORITHM_DES_PADDING_ECB_NoPadding);
        return encodeDESECB(tmp2, key21, ALGORITHM_DES_PADDING_ECB_NoPadding);
    }

    public static byte[] decryptDoubleDes(byte[] src, byte[] cryptKey) {
        if (cryptKey.length != 32) {
            throw new IllegalArgumentException("double des key size must be 32!");
        }
        byte[] key21 = new byte[16];
        System.arraycopy(cryptKey, 0, key21, 0, 16);
        byte[] key22 = new byte[16];
        System.arraycopy(cryptKey, 16, key22, 0, 16);
        byte[] tmp1 = decodeDESECB(src, key21, ALGORITHM_DES_PADDING_ECB_NoPadding);
        byte[] tmp2 = encodeDESECB(tmp1, key22, ALGORITHM_DES_PADDING_ECB_NoPadding);
        return decodeDESECB(tmp2, key21, ALGORITHM_DES_PADDING_ECB_NoPadding);
    }


    /**
     * from keyString be 24B byte array, chart use UTF-8
     *
     * @param keyStr {@link String} keyString must be 24B
     * @return can return empty info in byte[24]
     * @throws Exception
     */
    public static byte[] build3DesKey(String keyStr) throws Exception {
        return build3DesKey(keyStr, DEFAULT_CHART_SET);
    }

    /**
     * from keyString be 24B byte array
     *
     * @param keyStr   {@link String} keyString must be 24B
     * @param chartSet {@link String} string chart
     * @return can return empty info in byte[24]
     * @throws Exception
     */
    public static byte[] build3DesKey(String keyStr, String chartSet) throws Exception {
        byte[] key = new byte[24];
        byte[] temp = keyStr.getBytes(chartSet);
        if (key.length > temp.length) {
            System.arraycopy(temp, 0, key, 0, temp.length);

        } else {
            System.arraycopy(temp, 0, key, 0, key.length);

        }
        return key;
    }

    private DesSecretUtils() {
    }
}
