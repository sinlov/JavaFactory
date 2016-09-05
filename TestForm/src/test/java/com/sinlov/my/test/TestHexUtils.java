package com.sinlov.my.test;

import static org.junit.Assert.*;

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
 * Created by sinlov on 16/9/5.
 */
public class TestHexUtils {

    public static final String TEST_STR = "*f*#&&11(g*Uj!hg";

    @Test
    public void testHexStr2Bytes() {
        byte[] datas = TEST_STR.getBytes();
        System.out.println("Datas: " + HexUtils.bytes2HexStr(datas));
        for (byte data :
                datas) {
            System.out.println("str to bytes: " + HexUtils.byte2HexStr(data));
        }
    }
}
