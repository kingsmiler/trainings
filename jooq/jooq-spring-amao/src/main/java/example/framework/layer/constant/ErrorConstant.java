package example.framework.layer.constant;

import java.util.LinkedHashSet;
import java.util.Set;

public class ErrorConstant {
    private static Set<Integer> codes = new LinkedHashSet<>();

    public static boolean set(Integer code) {
        return codes.add(code);
    }

    public static boolean isEmpty() {
        return codes.isEmpty();
    }
}
