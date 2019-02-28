package util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class EpochUtil {
    public static String convertEpocSecsToDate(long time) {

        Date date = new Date(time * 1000); // multiply by 1000 for seconds
        SimpleDateFormat format = new SimpleDateFormat("00:mm:ss", Locale.US);
        String text = format.format(date);
        return text;

    }
}
