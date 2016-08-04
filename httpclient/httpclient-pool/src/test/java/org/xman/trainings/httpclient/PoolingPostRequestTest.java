package org.xman.trainings.httpclient;


import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PoolingPostRequestTest {
    String fullUrlPattern = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";

    @Test
    public void testPattern() {
        String url = "http://localhost:8080/post";
        String urlPattern = "^((https?|ftp|file)://[a-zA-Z0-9.:]*)[a-zA-Z0-9./]*";

        Pattern pattern = Pattern.compile(urlPattern);
        Matcher m = pattern.matcher(url);
        if (m.find()) {
            System.out.println(m.group(1));
        }
    }

    @Test
    public void testConstructor() {
        String url = "http://localhost:8080/post";
        PoolingPostRequest request = new PoolingPostRequest(url);

        System.out.println(request);
    }

    @Test
    public void testExecute() throws Exception {
        String url = "http://localhost:8080/post";
        PoolingPostRequest request = new PoolingPostRequest(url);
        RequestCallBack callBack = response -> {
            HttpEntity entity = response.getEntity();
            System.out.println(EntityUtils.toString(entity, "UTF-8"));
        };

        for(int i=0; i<10; i++) {
            request.execute("计数=" + i, callBack);

            Thread.sleep(1000L);
        }
        request.finished();
    }
}
