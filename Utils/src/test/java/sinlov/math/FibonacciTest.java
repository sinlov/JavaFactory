package sinlov.math;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * Fibonacci Tester.
 *
 * @author sinlov
 * @version 1.0
 * @since <pre>06/15/2017</pre>
 */
public class FibonacciTest {

    public static final long taskUntilFinished = 3000l;
    public static final int RUN_COUNT = 1000;
    private long nowTimeCount = 0;
    private long fibonacciCount = 0;
    private long fibonacciStart = 5;
    private long timeMark = 0;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: fibonacci(long n)
     */
    @Test
    public void testFibonacci() throws Exception {
        timeMark = System.currentTimeMillis();
        int n = RUN_COUNT;
        for (int i = 1; i <= n; i++) {
            nowTimeCount = nowTimeCount + taskUntilFinished;
            if (nowTimeCount > fibonacciCount) {
                fibonacciCount = Fibonacci.fibonacci(fibonacciStart++) * 1000;
                System.out.println("i = " + i + " |nowTimeCount: " + nowTimeCount);
                System.out.println(Fibonacci.fibonacci(fibonacciStart));
                System.out.println(fibonacciCount);
            }
        }
        System.out.println("Time use: " + (System.currentTimeMillis() - timeMark));
    }

    /**
     * Method: fibonacciNormal(int n)
     */
    @Test
    public void testFibonacciNormal() throws Exception {
        int n = RUN_COUNT;
        for (int i = 1; i <= n; i++) {
            nowTimeCount = nowTimeCount + taskUntilFinished;
            if (nowTimeCount > fibonacciCount) {
                fibonacciCount = Fibonacci.fibonacciNormal(fibonacciStart++) * 1000;
                System.out.println("i = " + i + " |nowTimeCount: " + nowTimeCount);
                System.out.println(Fibonacci.fibonacciNormal(fibonacciStart));
                System.out.println(fibonacciCount);
            }
        }
    }


}
