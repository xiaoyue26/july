package simple;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by xiaoyue26 on 17/11/16.
 */
public class DtUtils {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static boolean isValid(String dt) {
        if (dt == null || dt.length() != 10) {
            return false;
        }

        return true;
    }

    public static synchronized int dtDiff(String start, String end) throws ParseException {
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateFormat.parse(start));
        long time1 = cal.getTimeInMillis();
        cal.setTime(dateFormat.parse(end));
        long time2 = cal.getTimeInMillis();
        return Math.toIntExact(((time2 - time1) / (1000 * 3600 * 24)));
    }

}
