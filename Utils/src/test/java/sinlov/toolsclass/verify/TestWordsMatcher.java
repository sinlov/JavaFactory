package sinlov.toolsclass.verify;

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
 * Created by sinlov on 17/5/18.
 */
public class TestWordsMatcher {

    @Test
    public void test() {
//        String testWord = "￥123,123.12";
        String testWord = "大大娃娃大";
//        boolean matches = testWord.matches("^￥([0-9]+|[0-9]{1,3}(,[0-9]{3})*)(.[0-9]{1,2})?$");
        boolean matches = testWord.matches("^[\\u4e00-\\u9fa5]+$");
        if (matches) {
            System.out.println("true testWord = " + testWord);
        } else {
            System.out.println("false testWord = " + testWord);
        }
    }
}
