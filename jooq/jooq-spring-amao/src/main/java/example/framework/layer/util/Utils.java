package example.framework.layer.util;

import example.framework.layer.exception.CheckException;
import example.framework.layer.protocol.response.Error;

import java.sql.Timestamp;
import java.util.Map;
import java.util.Random;

public class Utils {
    private static final String ALLCHAR = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LETTERCHAR = "abcdefghijkllmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";


    //对日期时间的操作    开始
    private static final String NUMBERCHAR = "0123456789";
    private static DatetimeUtil datetimeUtil;

    //对日期时间的操作    结束


    //对JSON的操作    开始
    private static JsonUtil jsonUtil;

    public static long now() {
        return datetimeUtil.now();
    }

    public static Timestamp nowTime() {
        return new Timestamp(now());
    }

    //对JSON的操作    结束


    //对数据检查的操作    开始

    public static String toString(Object obj) {
        return jsonUtil.toJsonString(obj);
    }

    public static String toString(Map<String, Object> map) {
        return jsonUtil.toJsonString(map);
    }

    public static <T> T parseObject(String text, Class<T> clazz) {
        return jsonUtil.parseObject(text, clazz);
    }

    /**
     * 如果actual与expect不相等(euqals)时，抛出异常
     *
     * @param actual 实际值
     * @param expect 期望值
     * @param error  异常
     */
    public static void throwIfNotEquals(Object actual, Object expect, Error error) {
        throwIfNull(actual, error);
        throwIfNull(expect, error);
        if (actual.equals(expect)) {
            throw new CheckException(error);
        }
    }

    //对数据检查的操作    结束

    public static void throwIfNotEquals(Object actual, Object expect, Error error, String remark) {
        throwIfNull(actual, error, remark);
        throwIfNull(expect, error, remark);
        if (actual.equals(expect)) {
            throw new CheckException(error, remark);
        }
    }

    public static void throwIfNull(Object actual, Error error) {
        if (null == actual) {
            throw new CheckException(error);
        }
    }

    public static void throwIfNull(Object actual, Error error, String remark) {
        if (null == actual) {
            throw new CheckException(error, remark);
        }
    }

    public static String generateMixedString(int length) {
        StringBuffer stringBuffer = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            stringBuffer.append(ALLCHAR.charAt(random.nextInt(ALLCHAR.length())));
        }
        return stringBuffer.toString();
    }

    public static String generateLetterString(int length) {
        StringBuffer stringBuffer = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            stringBuffer.append(LETTERCHAR.charAt(random.nextInt(LETTERCHAR.length())));
        }
        return stringBuffer.toString();
    }

    public static String generateNumberString(int length) {
        StringBuffer stringBuffer = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            stringBuffer.append(NUMBERCHAR.charAt(random.nextInt(NUMBERCHAR.length())));
        }
        return stringBuffer.toString();
    }

    public static int generateNumber(int length) {
        return Integer.valueOf(generateNumberString(length));
    }
}
