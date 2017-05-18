package sinlov.toolsclass.verify;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * for Words match
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
 * Created by sinlov on 16/3/23.
 */
public class WordsMatcher {

    public static String REG_CHINESE = "[\\u4E00-\\u9FA5]";
    public static String REG_CHINESE_ALL = "^[\\u4e00-\\u9fa5]+$";
    public static String REG_CHINESE_ENG_ALL = "^[A-Za-z\\u4e00-\\u9fa5]+$";
    public static String REG_NUMBER_WORD = "\\d";
    public static String REG_NUMBER_WORD_ALL = "^\\d+$";
    public static String REG_SP_WORD = "\\w";
    public static String REG_SP_WORD_ALL = "^\\w+$";
    public static String REG_NUMBER_OR_LETTER_ALL = "^[0-9a-zA-Z]+$";
    public static String REG_URL = "^https?://(([a-zA-Z0-9_-])+(\\\\.)?)*(:\\\\d+)?(/((\\\\.)?(\\\\?)?=?&?[a-zA-Z0-9_-](\\\\?)?)*)*$";
    public static String REG_E_MAIL = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
    public static String REG_PHONE = "^(0|86|17951)?(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$";
    public static String REG_LETTER = "^[1-9]\\d{5}(?!\\d)$";
    public static String REG_PAY_SHOW = "^￥([0-9]+|[0-9]{1,3}(,[0-9]{3})*)(.[0-9]{1,2})?$";
    /**
     * Date number regex
     */
    public static final String REG_DATE_NUMBER = "^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s(((0?[0-9])|([1-2][0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$";


    /**
     * check String is chinese words by words
     *
     * @param words string
     * @return is chinese
     */
    public static boolean checkChinese(String words) {
        return words.matches(REG_CHINESE_ALL);
    }

    /**
     * check String is chinese ignore ""
     *
     * @param words string
     * @return is chinese
     */
    public static boolean checkChineseWeak(String words) {
        String[] aryStr = words.split("");
        for (int i = 0; i < aryStr.length - 1; i++) {
            String a = aryStr[i];
            if (!a.equals("")) {
                if (!a.matches(REG_CHINESE)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 验证日期字符串是否是YYYY-MM-DD格式
     *
     * @param words words
     * @return is
     */
    public static boolean isDataFormat(String words) {
        return words.matches(REG_DATE_NUMBER);
    }

    private WordsMatcher() {
    }
}
