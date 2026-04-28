package com.lfj.demo.controller1;

import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.util.EntityUtils;
import org.apache.http.HttpResponse;
import java.util.concurrent.CountDownLatch;

public class InternalHttpAsyncClientTest {

    public static void main(String[] args) throws InterruptedException {
        // 创建 HttpAsyncClient 实例
        try (CloseableHttpAsyncClient client = HttpAsyncClients.custom().build()) {
            // 启动 client
            client.start();

            // 创建 HTTP GET 请求
            HttpGet request = new HttpGet("https://httpbin.org/get");

            // 创建计数器，确保所有异步操作完成后再退出主线程
            CountDownLatch latch = new CountDownLatch(1);

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
                    latch.countDown();
                }

                @Override
                public void failed(Exception ex) {
                    System.err.println("Request failed: " + ex.getMessage());
                    latch.countDown();
                }

                @Override
                public void cancelled() {
                    System.out.println("Request cancelled");
                    latch.countDown();
                }
            });

            // 等待异步操作完成
            latch.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
