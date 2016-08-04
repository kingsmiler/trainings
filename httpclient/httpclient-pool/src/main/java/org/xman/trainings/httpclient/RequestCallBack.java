package org.xman.trainings.httpclient;


import org.apache.http.HttpResponse;

import java.io.IOException;

public interface RequestCallBack {
    /**
     * 回调函数，对响应对象进行处理。
     *
     * @param response  响应对象
     */
    void callback(HttpResponse response) throws IOException;
}
