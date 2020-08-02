package sinlov.security;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sinlov.utils.RandomString;

import java.util.Locale;

public class AES128Test {

    private String testKeyRight;
    private String testKeyError;

    private String url;

    @Before
    public void setUp() throws Exception {
        Locale local = new Locale("en", "US");
        Faker faker = new Faker(local);
        url = faker.company().url();
        testKeyRight = RandomString.generateString(16);
        testKeyError = RandomString.generateString(14);
    }

    @Test
    public void test_AES128_enctry_string() throws AES128.KeyLengthException {
        byte[] enRaw = AES128.encrypt(url, testKeyRight);
        Assert.assertNotNull("enRaw", enRaw);
        byte[] deRaw = AES128.decrypt(enRaw, testKeyRight);
        Assert.assertNotNull("deRaw", deRaw);
        Assert.assertEquals(url, new String(deRaw, AES128.CHARSET_DEFAULT));
    }
}
