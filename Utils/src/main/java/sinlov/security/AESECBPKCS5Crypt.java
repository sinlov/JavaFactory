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
public class AESECBPKCS5Crypt {
    public static final String CIPHER_TYPE_ECB_PKCS5_PADDING = "AES/ECB/PKCS5Padding";
    public static final String CHARACTER_SET_UTF_8 = "UTF-8";
    public static final String MESSAGE_DIGEST_MD5 = "MD5";
    public static final String SECRET_KEY_SPEC_ALGORITHM_AES = "AES";

    private static final int KEY_CHARACTER_SIZE = 16;

    private final String salt;
    private Key key;
    private Cipher cipher;
    private SecretKeySpec i;
    private AlgorithmParameterSpec spec;

    /**
     * hash password with SHA-256 and crop the output to 128-bit for key
     *
     * @param salt String must be size 16
     * @throws Exception {@link NoSuchAlgorithmException} {@link UnsupportedEncodingException}
     *                   {@link NoSuchPaddingException}
     */
    public AESECBPKCS5Crypt(String salt) {
        this.salt = salt;
        if (KEY_CHARACTER_SIZE != salt.length()) {
            new Throwable("key character set error").printStackTrace();
        } else {
            MessageDigest digest;
            try {
                digest = MessageDigest.getInstance(MESSAGE_DIGEST_MD5);
                digest.update(this.salt.getBytes(CHARACTER_SET_UTF_8));
                Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
                this.cipher = Cipher.getInstance(CIPHER_TYPE_ECB_PKCS5_PADDING);
                this.key = new SecretKeySpec(digest.digest(), 0, 16, SECRET_KEY_SPEC_ALGORITHM_AES);
            } catch (NoSuchAlgorithmException | UnsupportedEncodingException | NoSuchPaddingException e) {
                e.printStackTrace();
            }
        }
    }

    public byte[] encryptByte(String plainText) throws Exception {
        cipher.init(Cipher.ENCRYPT_MODE, key, spec);
        return cipher.doFinal(plainText.getBytes(CHARACTER_SET_UTF_8));
    }

    /**
     * encrypt code to AES
     *
     * @param plainText {@link String}
     * @return {String}
     * @throws Exception date: Nov 4, 2015 2:22:21 PM
     */
    public String encrypt(String plainText) throws Exception {
        return new String(Base64.encode(encryptByte(plainText),
                Base64.DEFAULT), CHARACTER_SET_UTF_8);
    }

    /**
     * Decrypt carpeted text
     *
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
