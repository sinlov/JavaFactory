package com.sinlov.my.test;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * TestString Tester.
 *
 * @author sinlov
 * @version 1.0
 * @since <pre>08/26/2017</pre>
 */
public class TestStringTest {

    @BeforeClass
    public void before() throws Exception {
    }

    @AfterClass
    public void after() throws Exception {
    }

    @Test
    public void stringHashCode() {
        String first = "12323";
        System.out.println("first = " + first.hashCode());
        String second = "\"12323\"";
        System.out.println("second = " + second.hashCode());
        String firstRef = first;
        System.out.println("firstRef = " + firstRef.hashCode());
        String firstCopy = new String(first);
        System.out.println("firstCopy = " + firstCopy.hashCode());
        StringBuilder sbFirst = new StringBuilder(first);
        System.out.println("sbFirst = " + sbFirst.hashCode());
        StringBuilder sbSecond = new StringBuilder(second);
        System.out.println("sbSecond = " + sbSecond.hashCode());
    }
}
