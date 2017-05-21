package sinlov.date;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by "sinlov" on 16/4/15.
 */
public class DateTest {

    private static final String DEFAULT_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss SSS";

    public static void main(String[] args) {
        String result = getNowTimeString(DEFAULT_TIME_FORMAT);
        System.out.println(result);
    }

    private static String getNowTimeString(String timeFormat) {
        SimpleDateFormat df = new SimpleDateFormat(timeFormat);
        return df.format(new Date());
    }
}
