package example.framework.layer.util;

import org.joda.time.DateTime;


public class DatetimeUtil {
    protected static long now() {
        return DateTime.now().getMillis();
    }
}
