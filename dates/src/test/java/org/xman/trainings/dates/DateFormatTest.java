package org.xman.trainings.dates;


import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormatTest {
    private static final String GMT_PATTERN_X = "yyyy-MM-dd'T'HH:mm:ssXXX";
    private static final String GMT_PATTERN_Z = "yyyy-MM-dd'T'HH:mm:ssZ";

    private static final String T_PM_PATTERN = "HH:mm:ss aaa";

    @Test
    public void testGmtPatternX() {
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(GMT_PATTERN_X);
        // 加上时区校正
        // sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        System.out.println(sdf.format(now));
        // 输出示例：2016-08-01T12:44:12+08:00
    }

    @Test
    public void testGmtPatternZ() {
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(GMT_PATTERN_Z);

        System.out.println(sdf.format(now));
        // 输出示例：2016-08-01T12:46:45+0800
    }

    @Test
    public void testPmDate() {
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(T_PM_PATTERN, Locale.US);

        System.out.println(sdf.format(now));
        // 输出示例：12:56:05 PM
    }
}
