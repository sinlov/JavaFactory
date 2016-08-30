package sinlov.security;

import sinlov.utils.Base64;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.Arrays;

/**
 * AESUtil
 * Created by "sinlov" on 16/3/30.
 */
public class AESUtil {

    public static void main(String args[]) {
        long startTime = System.currentTimeMillis();
        String encodeStr = AESUtil.encode("1234", "你要去哪儿test123");
        System.out.println("encoder:" + encodeStr);
        String decodeStr = AESUtil.decode("1234", encodeStr);
        System.out.println("decoder:" + decodeStr);
    }


    /**
     * Encodes a String in AES-256 with a given key
     *
     * @param keyString
     * @param stringToEncode
     * @return String Base64 and AES encoded String
     */
    public static String encode(String keyString, String stringToEncode) throws NullPointerException {
        if (keyString.length() == 0 || keyString == null) {
            throw new NullPointerException("Please give Password");
        }
        if (stringToEncode.length() == 0 || stringToEncode == null) {
            throw new NullPointerException("Please give text");
        }
        try {
            SecretKeySpec skeySpec = getKey(keyString);
            byte[] clearText = stringToEncode.getBytes("UTF8");
            // IMPORTANT TO GET SAME RESULTS ON iOS and ANDROID
            final byte[] iv = new byte[16];
            Arrays.fill(iv, (byte) 0x00);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
            /**
             * 这个地方调用BouncyCastleProvider
             *
             *让java支持PKCS7Padding
             */
            Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
            // Cipher is not thread safe
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, ivParameterSpec);
            return Base64.encodeToString(cipher.doFinal(clearText), Base64.DEFAULT);
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        }
        return "";
    }


    /**
     * Decodes a String using AES-256 and Base64
     *
     * @param password
     * @param text
     * @return desoded String
     */
    public static String decode(String password, String text) throws NullPointerException {
        if (password.length() == 0 || password == null) {
            throw new NullPointerException("Please give Password");
        }
        if (text.length() == 0 || text == null) {
            throw new NullPointerException("Please give text");
        }
        try {
            SecretKey key = getKey(password);
            // IMPORTANT TO GET SAME RESULTS ON iOS and ANDROID
            final byte[] iv = new byte[16];
            Arrays.fill(iv, (byte) 0x00);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
            byte[] encrypedPwdBytes = Base64.decode(text, Base64.DEFAULT);
            // cipher is not thread safe
            /**
             * 这个地方调用BouncyCastleProvider
             *让java支持PKCS7Padding
             */
            Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            cipher.init(Cipher.DECRYPT_MODE, key, ivParameterSpec);
            byte[] decrypedValueBytes = (cipher.doFinal(encrypedPwdBytes));
            String decrypedValue = new String(decrypedValueBytes);
            //Log.d(LOG_TAG, "Decrypted: " + text + " -> " + decrypedValue);
            return decrypedValue;
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        }
        return "";
    }


    /**
     * Generates a SecretKeySpec for given password
     *
     * @param password
     * @return SecretKeySpec
     * @throws UnsupportedEncodingException
     */
    private static SecretKeySpec getKey(String password) throws UnsupportedEncodingException {
        // You can change it to 128 if you wish
        int keyLength = 256;
        byte[] keyBytes = new byte[keyLength / 8];
        // explicitly fill with zeros
        Arrays.fill(keyBytes, (byte) 0x0);
        // if password is shorter then key length, it will be zero-padded
        // to key length
        byte[] passwordBytes = password.getBytes("UTF-8");
        int length = passwordBytes.length < keyBytes.length ? passwordBytes.length : keyBytes.length;
        System.arraycopy(passwordBytes, 0, keyBytes, 0, length);
        SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");
        return key;
    }
}
