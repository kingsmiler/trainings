package org.xman.trainings.dates;


import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatTest {
    private static final String GMT_PATTERN = "yyyy-MM-dd'T'HH:mm:ssZ";

    @Test
    public void testGmtPattern() {
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(GMT_PATTERN);
        // 加上时区校正
        // sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        System.out.println(sdf.format(now));
    }
}
