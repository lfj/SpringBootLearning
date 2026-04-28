package com.lfj.demo.controller1;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Country1Controller {

    CloseableHttpAsyncClient client;
    {
        client = HttpAsyncClients.custom().build();
        client.start();
    }

    private static final Logger logger = LoggerFactory.getLogger(Country1Controller.class);

    @GetMapping("/testHttpAsync")
    public void isDevelopedCountry() {

        // 创建 HTTP GET 请求
        HttpGet request = new HttpGet("https://httpbin.org/get");
        // 执行异步请求
        client.execute(request, new FutureCallback<HttpResponse>() {

            @Override
            public void completed(HttpResponse response) {
                try {
                    // 处理响应
                    String result = EntityUtils.toString(response.getEntity());
                    System.out.println("Response: " + result);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void failed(Exception ex) {
                System.err.println("Request failed: " + ex.getMessage());
            }

            @Override
            public void cancelled() {
                System.out.println("Request cancelled");
            }
        });
    }

}
