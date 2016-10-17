package sinlov.math;

import java.math.BigDecimal;

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
 * Created by sinlov on 16/10/17.
 */
public class BigDecimalUse {
    public static void main(String[] args) {
        double baseNum = 0.123456789;
        BigDecimal bNum = new BigDecimal(Double.valueOf(baseNum));
        System.out.println("bNum = [" + bNum.toString() + "]");
        // 舍弃非零部分，同时不会非零舍弃部分相邻的一位数字加一，采取截取行为
        BigDecimal bDownNum = bNum.setScale(1, BigDecimal.ROUND_DOWN);
        System.out.println("bDownNum = [" + bDownNum + "]");
        // 舍弃非零部分，并将非零舍弃部分相邻的一位数字加一
        BigDecimal bUpNum = bNum.setScale(1, BigDecimal.ROUND_UP);
        System.out.println("bUpNum = [" + bUpNum + "]");
        // 五舍六入
        BigDecimal bHDownNum = bNum.setScale(1, BigDecimal.ROUND_HALF_DOWN);
        System.out.println("bHDownNum = [" + bHDownNum + "]");
        // 四舍五入
        BigDecimal bHUpNum = bNum.setScale(1, BigDecimal.ROUND_HALF_UP);
        System.out.println("bHUpNum = [" + bHUpNum + "]");
    }
}
