package sinlov.toolsclass.verify;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * WordsMatcher Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>五月 21, 2017</pre>
 */
public class WordsMatcherTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: checkChinese(String words)
     */
    @Test
    public void testCheckChinese() throws Exception {
        assert WordsMatcher.checkChinese("我的");
//        assert WordsMatcher.checkChinese("123");
    }

    /**
     * Method: checkChineseWeak(String words)
     */
    @Test
    public void testCheckChineseWeak() throws Exception {
        assert WordsMatcher.checkChineseWeak("我的 ");
    }

    /**
     * Method: isDataFormat(String words)
     */
    @Test
    public void testIsDataFormat() throws Exception {
        assert WordsMatcher.isDataFormat("2017-05-01");
//        assert WordsMatcher.isDataFormat("2017-5-41");
    }


} 
