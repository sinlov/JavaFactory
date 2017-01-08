package com.sinlov.my.test;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
 * Created by sinlov on 16/12/20.
 */
public class URLMatchesTest {



    static String url1 = "https://www.mo9.com/gateway/mobile.shtml?m=mobile&lc=CN&version=2.2&return_url=http%3A%2F%2Ftest.g.kuaifazs.com%2Fforeign%2Frecharge%2Fcallback.php%3F_payType%3Dmo9_wap%26orderId%3D1612209900002000&amount=1.00&item_name=%E7%96%AF%E7%8B%82%E5%AE%9D%E7%9F%B3%E5%85%85%E5%80%BC&payer_id=18543&currency=CNY&m=mobile&invoice=1612209900002000&notify_url=http%3A%2F%2Ftest.g.kuaifazs.com%2Fforeign%2Frecharge%2Fnotify.php%3F_payType%3Dmo9_wap&fromDFT=true&pay_to_email=45597195%40qq.com&app_id=2014adOPnHIONj&sign=90a4d13f12547fc5a86e0102c2dce203&token=2C1EFD120A027A92D707F174FE5BBAFC";
    static String url2 = "https://www.mo9.com/gateway/wap_gateway.shtml?m=showLoginPage";
    static String url3 = "https://www.mo9.com/gateway/wap_gateway.shtml?m=showTxConfirmPage";
    static String url4 = "https://www.mo9.com/gateway/pay.shtml?m=pay&gatewayDealcode=BABFLBLPNNALLLHL&mobile=18600678470&channel=alipay&amount=1.00&subchannel=WapDirectPay&extral=%7C%7C%7C&sign=E6EE1346E072D640A7740BE83BF28C7E&topupPage=3&trade_sessionId=201612200931549004941268&merchantname=%E6%88%90%E9%83%BD%E4%BA%91%E7%AB%AF%E5%8A%A9%E6%89%8B%E7%A7%91%E6%8A%80%E6%9C%89%E9%99%90%E5%85%AC%E5%8F%B8";
    static String url5 = "http://wappaygw.alipay.com/service/rest.htm?sign=5809e364076966fd7cc4efcea2a7a37e&v=2.0&sec_id=MD5&req_data=%3Cauth_and_execute_req%3E%3Crequest_token%3E20161220117cd2c8142e433a9110cd20b0c4708c%3C%2Frequest_token%3E%3C%2Fauth_and_execute_req%3E&service=alipay.wap.auth.authAndExecute&partner=2088611361723512&format=xml";
    static String url6 = "https://wappaygw.alipay.com/service/rest.htm?sec_id=MD5&format=xml&sign=5809e364076966fd7cc4efcea2a7a37e&v=2.0&req_data=%3Cauth_and_execute_req%3E%3Crequest_token%3E20161220117cd2c8142e433a9110cd20b0c4708c%3C%2Frequest_token%3E%3C%2Fauth_and_execute_req%3E&service=alipay.wap.auth.authAndExecute&partner=2088611361723512";
    static String url7 = "https://www.mo9.com/gateway/topup/alipay/WapDirectPay/return.shtml?out_trade_no=WAAEJAJPNEJOKOEH&request_token=requestToken&result=success&trade_no=2016122021001004100233821521&sign=5cc14a8c11495e99867299a0281b6442&sign_type=MD5";
    static String url8 = "https://www.mo9.com/gateway/mobile.shtml?m=ctnTranction&mobile=18600678470&invoice=BABFLBLPNNALLLHL&dealcode=WAAEJAJPNEJOKOEH&amount=1.00&sign=E78EB29367A19A018461398DB129AAE8";
    static String url9 = "https://www.mo9.com/gateway/wap_gateway.shtml?m=showPayResult";
    static String url10 = "http://test.g.kuaifazs.com/foreign/recharge/callback.php?_payType=mo9_wap&orderId=1612209900002000";
    static String url11 = "http://api.mobile.youxigongchang.com/recharge_res.php?orderid=1612209900002000";

    public static final String IS_URL = "\"^http://([\\w-]+\\.)+[\\w-]+(/[\\w-./?%&=]*)?$\"";
    public static final String M_URL = "recharge_res.php";
    public static void main(String[] args) {
        ArrayList<String> testStr = new ArrayList<>();
        testStr.add(url1);
        testStr.add(url2);
        testStr.add(url3);
        testStr.add(url4);
        testStr.add(url5);
        testStr.add(url6);
        testStr.add(url7);
        testStr.add(url8);
        testStr.add(url9);
        testStr.add(url10);
        testStr.add(url11);
        Pattern pattern = Pattern.compile(IS_URL);

        for (String url : testStr) {
            Matcher m = pattern.matcher(url);
            if (m.lookingAt()) {
                System.out.println("Found value: " + m.group(0) );
                System.out.println("Found value: " + m.group(1) );
                System.out.println("Found value: " + m.group(2) );
            } else {
                System.out.println("NO MATCH");
            }
            if (url.matches(IS_URL)) {
                System.out.println(url);
            }
        }
        System.out.println(url11.contains(M_URL));
        String[] split = url11.split("=");
        for (String s : split) {
            System.out.println(s);
        }
    }
}
