package com.sinlov.my.test;

import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

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
public class BigIntegerTest {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
//
//        //读到EOF
//        while (cin.hasNext()) {
//        }
        //读入BigInteger
//        BigInteger a = cin.nextBigInteger();
        double start = 25.12;
        BigInteger a = new BigInteger("25");
        System.out.println("a = " + a);
        //构造方法
        //将十进制字符串转化为BigInteger
        //public BigInteger(String val)
        BigInteger b = new BigInteger("3");
        System.out.println("b = " + b);
        //byte范围-128到+127 8为2进制数 c为767（1011111111）
        //public BigInteger(byte[] val)
        byte[] bt = new byte[]{2, -1};
        BigInteger c = new BigInteger(bt);
        System.out.println("c = " + c);
        //将radix进制的字符串转化为BigInteger
        //public BigInteger(String val, int radix)
//        BigInteger d = new BigInteger("3", 2);
        //随机生成 0到2的numBits次方 -1的随机数
        //public BigInteger(int numBits, Random rnd)
        BigInteger e = new BigInteger(10, new Random());
        System.out.println("e = " + e);
        //signum为符号位 1为正 0为0 -1为负
        //public BigInteger(int signum, byte[] magnitude)
        BigInteger f = new BigInteger(-1, bt);
        System.out.println("f = " + f);
        //随机生成一个 长度为bitLength的 可能性大于(1-1/(2的certainty次方))是素数 的数
        //public BigInteger(int bitLength, int certainty, Random rnd)
        BigInteger g = new BigInteger(10, 1, new Random());
        System.out.println("g = " + g);


        //常量
        //0
        //public static final BigInteger ZERO
        a = BigInteger.ZERO;
        System.out.println("BigInteger.ZERO = " + a);
        //1
        //public static final BigInteger ONE
        a = BigInteger.ONE;
        System.out.println("BigInteger.ONE = " + a);
        //10
        //public static final BigInteger TEN
        a = BigInteger.TEN;
        System.out.println("BigInteger.TEN = " + a);

        //静态方法
        //随机生成一个 长度为bitLength的可能是素数的数
        //public static BigInteger probablePrime(int bitLength, Random rnd)
        BigInteger.probablePrime(10, new Random());
        System.out.println("BigInteger.probablePrime 10 = " + a);
        //值等于val的值
        //public static BigInteger valueOf(long val)
        BigInteger.valueOf(10);
        System.out.println("BigInteger.valueOf 10 = " + a);

        //加法a+b
        //public BigInteger add(BigInteger val)
        a.add(b);
        System.out.println("BigInteger.add b = " + a + " |b = " + b);
        //减法a-b
        //public BigInteger subtract(BigInteger val)
        a.subtract(b);
        System.out.println("BigInteger.subtract b = " + a + " |b = " + b);
        //乘法a*b
        //public BigInteger subtract(BigInteger val)
        a.multiply(b);
        System.out.println("BigInteger.multiply b = " + a + " |b = " + b);
        //除法a/b
        //public BigInteger divide(BigInteger val)
        a.divide(b);
        System.out.println("BigInteger.divide b = " + a + " |b = " + b);
        //取模a%b b需大于0 5mod3=2 -5mod3=1
        //public BigInteger mod(BigInteger m)
        a.mod(b);
        System.out.println("BigInteger.mod %b = " + a + " |b = " + b);
        //求余 5rem3=2 -5rem3=-2 5rem-3=2 -5rem-3=-2
        //public BigInteger remainder(BigInteger val)
        a.remainder(b);
        System.out.println("BigInteger.remainder rem = " + a + " |b = " + b);
        //[0]为a/b [1]为a%b
        //public BigInteger[] divideAndRemainder(BigInteger val)
        a.divideAndRemainder(b);
        System.out.println("BigInteger.divideAndRemainder [0]为a/b [1]为a%b  = " + a + " |b = " + b);

        //a==b?
        //public boolean equals(Object x)
        a.equals(b);
        //a的正负 正为1 0为0 负为-1
        System.out.println("BigInteger.equals 正为1 0为0 负为-1 = " + a + " |b = " + b);
        //public int signum()
        a.signum();
        //绝对值|a|
        System.out.println("BigInteger.signum 绝对值|a  = " + a + " |b = " + b);
        //public BigInteger abs()
        a.abs();
        //比较a>b返回1 a==b返回0 a<b返回-1
        System.out.println("BigInteger.abs 比较a>b返回1 a==b返回0 a<b返回-1  = " + a + " |b = " + b);
        //public BigInteger andNot(BigInteger val)
        a.compareTo(b);
        //相反数-a
        //public BigInteger negate()
        a.negate();
        //max(a,b)
        //public BigInteger max(BigInteger val)
        a.max(b);
        //min(a,b)
        //public BigInteger min(BigInteger val)
        a.min(b);
        //次方a的3次方
        //public BigInteger pow(int exponent)
        a.pow(3);
        //a的-1次方 %b
        //public BigInteger modInverse(BigInteger m)
        a.modInverse(b);
        //a的b次方 %c
        //public BigInteger modPow(BigInteger exponent,BigInteger m)
        a.modPow(b, c);

        //~a
        //public BigInteger not()
        a.not();
        //a^b
        //public BigInteger xor(BigInteger val)
        a.xor(b);
        //a|b
        //public BigInteger or(BigInteger val)
        a.or(b);
        //a&b
        //public BigInteger divide(BigInteger val)
        a.and(b);
        //a左移n位 (a << n)
        //public BigInteger shiftLeft(int n)
        a.shiftLeft(10);
        //a右移n位 (a >> n)
        //public BigInteger shiftRight(int n)
        a.shiftRight(10);
        //a&(~b)
        //public BigInteger andNot(BigInteger val)
        a.andNot(b);
        //二进制形式中把第n位二进制设为0 (a & ~(1<<n))
        //public BigInteger clearBit(int n)
        a.clearBit(10);
        //二进制形式中把第n位二进制设为1 (a | (1<<n))
        //public BigInteger setBit(int n)
        a.setBit(10);
        //二进制形式中第n位二进制是否为1 (a & (1<<n)) != 0)
        //public boolean testBit(int n)
        a.testBit(10);
        //二进制形式中把第n位二进制翻转 (a ^ (1<<n))
        //public BigInteger flipBit(int n)
        a.flipBit(10);
        //二进制形式中最低位1后面0的个数 (a == 0? -1 : log2(a & -a))
        //public int getLowestSetBit()
        a.getLowestSetBit();
        //二进制形式中与符号不同的位的数量 7为3 -7为2
        //public int bitCount()
        a.bitCount();
        //二进制形式中不包括符号位的长度
        //public int bitLength()
        a.bitLength();

        //a和b的最大公约数
        //public BigInteger gcd(BigInteger val)
        a.gcd(b);
        //a可能为素数返回true a一定为合数返回false 素数可能性大于(1-1/(2的certainty次方))
        //public boolean isProbablePrime(int certainty)
        a.isProbablePrime(10);
        //大于a的可能为素数的第一个整数。
        //public BigInteger nextProbablePrime()
        a.nextProbablePrime();
        //a的哈希码
        //public int hashCode()
        a.hashCode();

        //a的二进制补码形式
        //public byte[] toByteArray()
        a.toByteArray();
        //a的十进制字符串形式
        //public String toString()
        a.toString();
        //a的radix进制字符串形式
        //public String toString(int radix)
        a.toString(2);
        //将a转换为int
        //public int intValue()
        a.intValue();
        //将a转换为long
        //public long longValue()
        a.longValue();
        //将a转换为float
        //public float floatValue()
        a.floatValue();
        //将a转换为double
        //public double doubleValue()
        a.doubleValue();

        //JAVA 1.8
        a.byteValueExact();
        a.intValueExact();
        a.longValueExact();
        a.shortValueExact();

        //从类 java.lang.Number 继承的方法
        //将a转换为short
        //public short shortValue()
        a.shortValue();
        //将a转换为byte
        //public byte byteValue()
        a.byteValue();

        //从类 java.lang.Object 继承的方法
        //public final Class<?> getClass()
        a.getClass();
        //public final void notify()
        a.notify();
        //public final void notifyAll()
        a.notifyAll();
        try {
            //public final void wait() throws InterruptedException
            a.wait();
            //public final void wait(long timeout) throws InterruptedException
            a.wait(10);
            //public final void wait(long timeout, int nanos) throws InterruptedException
            a.wait(10, 10);
        } catch (Exception exception) {
        }
    }
}
