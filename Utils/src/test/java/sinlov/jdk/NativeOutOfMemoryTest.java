package sinlov.jdk;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * NativeOutOfMemory Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>五月 21, 2017</pre>
 */
public class NativeOutOfMemoryTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: countNowMaxThreadCount()
     */
    @Test(expected = OutOfMemoryError.class)
    public void testCountNowMaxThreadCount() throws Exception {
        NativeOutOfMemory noo = new NativeOutOfMemory();
        noo.countNowMaxThreadCount();
    }

    /**
     * Method: run()
     */
    @Test
    public void testRun() throws Exception {
//TODO: Test goes here... 
    }


} 
