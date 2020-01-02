package sinlov.net;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * IP utils for dev
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
 * Created by sinlov on 2018/3/12 in 23:28.
 */
public class IPUtils {

    private static final boolean debug = true;

    private static final String IP_CHINA = "http://ip.chinaz.com/getip.aspx";

    public static String publicIPAtChina() throws IOException {
        return publicIPAtChina("UTF-8");
    }

    public static String publicIPAtChina(String charset) throws IOException {
        InputStream is = new URL(IP_CHINA).openStream();
        BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName(charset)));
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        String jsonText = sb.toString();
        if (debug) {
            JSONObject jsonObject = new JSONObject(jsonText);
            String ip = jsonObject.optString("ip");
            System.out.println("ip = " + ip);
            String address = jsonObject.optString("address");
            System.out.println("address = " + address);
        }
        jsonText = jsonText.replaceAll("'", "");
        jsonText = jsonText.substring(1, jsonText.length() - 1);
        jsonText = jsonText.replaceAll(",", "<br/>");
        return jsonText;
    }

    private IPUtils() {
    }
}
