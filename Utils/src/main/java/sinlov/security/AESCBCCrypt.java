/**
 * All rights Reserved, Designed By Android Robot thanks coder!
 *
 * @Title: AESCBCCrypt.java
 * @Package mdl.sinlov.security
 * @Copyright: sinlov Co., Ltd. Copyright YYYY-YYYY,  All rights reserved.
 * @author: sinlov
 * @data: Nov 4, 2015 1:41:06 PM
 * @version: V1.0
 */
package sinlov.security;

import sinlov.utils.Base64;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.security.spec.AlgorithmParameterSpec;

/**
 * Android AES coder
 * Created by sinlov on Nov 4, 2015 1:41:06 PM
 */
public class AESCBCCrypt {

    public static final String CIPHER_TYPE_CBC_PKCS7_PADDING = "AES/CBC/PKCS7Padding";
    public static final String CHARACTER_SET_UTF_8 = "UTF-8";
    public static final String MESSAGE_DIGEST_SHA_256 = "SHA-256";
    public static final String SECRET_KEY_SPEC_ALGORITHM_AES = "AES";

    private static final int KEY_CHARACTER_SIZE = 16;

    private final String salt;
    private Key key;
    private Cipher cipher;
    private SecretKeySpec i;
    private AlgorithmParameterSpec spec;

    /**
     * hash password with SHA-256 and crop the output to 128-bit for key
     * @param salt String must be size 16
     * @throws Exception {@link NoSuchAlgorithmException} {@link UnsupportedEncodingException}
     * {@link NoSuchPaddingException}
     */
    public AESCBCCrypt(String salt) {
        this.salt = salt;
        if (KEY_CHARACTER_SIZE != salt.length()) {
            new Throwable("key character set error").printStackTrace();
        } else {
            MessageDigest digest;
            try {
                digest = MessageDigest.getInstance(MESSAGE_DIGEST_SHA_256);
                digest.update(this.salt.getBytes(CHARACTER_SET_UTF_8));
                byte[] keyBytes = new byte[32];
                System.arraycopy(digest.digest(), 0, keyBytes, 0, keyBytes.length);
                Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
                this.cipher = Cipher.getInstance(CIPHER_TYPE_CBC_PKCS7_PADDING);
                this.key = new SecretKeySpec(keyBytes, SECRET_KEY_SPEC_ALGORITHM_AES);
                this.spec = getIV();
            } catch (NoSuchAlgorithmException | UnsupportedEncodingException | NoSuchPaddingException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * encrypt code to AES
     * @param plainText {@link String}
     * @return {String}
     * @throws Exception
     * date: Nov 4, 2015 2:22:21 PM
     */
    public String encrypt(String plainText) throws Exception {
        cipher.init(Cipher.ENCRYPT_MODE, key, spec);
        byte[] encrypted = cipher.doFinal(plainText.getBytes(CHARACTER_SET_UTF_8));
        return new String(Base64.encode(encrypted,
                Base64.DEFAULT), CHARACTER_SET_UTF_8);
    }

    /**
     * Decrypt carpeted text
     * @param carpetedText {@link String}
     * @return {@link String}
     * @throws Exception
     */
    public String decrypt(String carpetedText) throws Exception {
        cipher.init(Cipher.DECRYPT_MODE, key, spec);
        byte[] bytes = Base64.decode(carpetedText, Base64.DEFAULT);
        byte[] decrypted = cipher.doFinal(bytes);
        return new String(decrypted, CHARACTER_SET_UTF_8);
    }

    private AlgorithmParameterSpec getIV() {
        byte[] iv = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,};
        IvParameterSpec ivParameterSpec;
        ivParameterSpec = new IvParameterSpec(iv);
        return ivParameterSpec;
    }
}