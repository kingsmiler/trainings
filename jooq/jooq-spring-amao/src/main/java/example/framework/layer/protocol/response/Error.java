package example.framework.layer.protocol.response;

import example.framework.layer.constant.ErrorConstant;

public interface Error {
    int defaultCode = 0;
    String defaultMessage = "ok.";

    static boolean set(Integer code) {
        return ErrorConstant.set(code);
    }

    static boolean isEmpty() {
        return ErrorConstant.isEmpty();
    }

    int getCode();

    String getMessage();

    public String toString();

    public String toString(String remark);
}
