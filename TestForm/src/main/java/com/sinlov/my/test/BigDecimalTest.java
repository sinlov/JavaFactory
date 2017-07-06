package com.sinlov.my.test;

import java.math.BigDecimal;
import java.math.MathContext;

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
 * Created by sinlov on 17/7/5.
 */
public class BigDecimalTest {
    public static void main(String[] args) {
        double a1 = 25.10;
        BigDecimal a = new BigDecimal("25.10");
        System.out.println("a = " + a);
        BigDecimal b = new BigDecimal("12");
        System.out.println("b = " + b);
        BigDecimal remainder = a.remainder(BigDecimal.TEN, new MathContext(1));
        System.out.println("remainder = " + remainder);
        BigDecimal[] bigDecimals = a.divideAndRemainder(BigDecimal.TEN);
        System.out.println("bigDecimals[0] = " + bigDecimals[0]);
        System.out.println("bigDecimals[1] = " + bigDecimals[1]);
        double ad = a.doubleValue();
        java.text.DecimalFormat dJiao=new java.text.DecimalFormat("0.#");
        String formatJiao = dJiao.format(ad);
        BigDecimal formatBigJiao = new BigDecimal(formatJiao);
        System.out.println("formatBigJiao = " + formatBigJiao);


        double c = 3.154215;
        java.text.DecimalFormat myFormat = new java.text.DecimalFormat("0.00");
        String decimalFormat = myFormat.format(c);
        System.out.println("decimalFormat = " + decimalFormat);
        double f1 = 111231.5585;
        BigDecimal f = new BigDecimal(f1);
        //保留2位小数
        double letRoundHalfUp = f.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println("letRoundHalfUp = " + letRoundHalfUp);
    }
}
