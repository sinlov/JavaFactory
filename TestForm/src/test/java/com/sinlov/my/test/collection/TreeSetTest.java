package com.sinlov.my.test.collection;

import org.junit.Before;
import org.junit.Test;
import test.TempTest;

import java.util.TreeSet;

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
 * Created by sinlov on 17/12/27.
 */
public class TreeSetTest extends TempTest {
    private static final String FIRST_MARK = "FIRST_MARK";
    private TreeSet<String> strTree;

    @Before
    public void setUp() throws Exception {
        strTree = new TreeSet<String>();
        strTree.add(FIRST_MARK);
        strTree.add(randomString(5));
        strTree.add(randomString(5));
        strTree.add(randomString(5));
        strTree.add(randomString(5));
        strTree.add(randomString(5));
    }

    @Test
    public void test_01_ceiling() throws Exception {
        String ceiling = strTree.ceiling(FIRST_MARK);
        System.out.println("ceiling = " + ceiling);
    }

    @Test
    public void test_02_cell() throws Exception {

    }
}
