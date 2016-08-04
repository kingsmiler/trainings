package org.xman.trainings.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PoolingPostRequest {

    private static final ContentType CONTENT_TYPE = ContentType.create("application/xml", StandardCharsets.UTF_8);
    private static final Pattern HOST_PATTERN = Pattern.compile("^((https?|ftp|file)://[a-zA-Z0-9.:]*)[a-zA-Z0-9./]*");

    private static PoolingHttpClientConnectionManager manager;
    private static CloseableHttpClient client;
    private static HttpPost request;

    public PoolingPostRequest(final String url) {
        Matcher m = HOST_PATTERN.matcher(url);
        String host;
        if (m.find()) {
            host = m.group(1);
        } else {
            throw new RuntimeException("URL is not valid : " + url);
        }

        if (manager != null) {
            finished();
        }

        HttpRoute route = new HttpRoute(HttpHost.create(host));
        manager = new PoolingHttpClientConnectionManager();
        manager.setMaxTotal(10);
        manager.setDefaultMaxPerRoute(5);
        manager.setSocketConfig(
                route.getTargetHost(),
                SocketConfig.custom().setSoTimeout(30000).build()
        );

        client = HttpClients.custom().setConnectionManager(manager).build();
        request = new HttpPost(url);
    }

    public void execute(String message, RequestCallBack requestCallBack) throws Exception {
        StringEntity stringEntity = new StringEntity(message, CONTENT_TYPE);
        request.setEntity(stringEntity);

        try (CloseableHttpResponse response = client.execute(request)) {
            requestCallBack.callback(response);
            EntityUtils.consume(response.getEntity());
        }
    }

    public void finished() {
        try {
            request.completed();
            client.close();
            manager.close();
        } catch (IOException ignored) {
        }
    }
}
