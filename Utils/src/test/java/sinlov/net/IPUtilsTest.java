package sinlov.net;

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
 * Created by sinlov on 2018/3/13 in 00:03.
 */
public class IPUtilsTest {

    @Test
    public void testPublicIPAtChina() throws Exception {
        String result = IPUtils.publicIPAtChina();
        Assert.assertNotEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    public void testPublicIPAtChina2() throws Exception {
        String result = IPUtils.publicIPAtChina("UTF-8");
        Assert.assertNotEquals("replaceMeWithExpectedResult", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme