package example.framework.layer.util;

import com.alibaba.fastjson.JSON;

import java.util.Map;

public class JsonUtil {
    protected static String toJsonString(Object obj) {
        return JSON.toJSONString(obj);
    }

    protected static String toJsonString(Map<String, Object> map) {
        return JSON.toJSONString(map);
    }

    protected static <T> T parseObject(String text, Class<T> clazz) {
        return JSON.parseObject(text, clazz);
    }
}
