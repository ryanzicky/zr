package com.web.controller;

import com.web.domain.ResponseEntity;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.message.BasicHeader;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zhourui
 * @Date 2020/12/26 10:58
 */
@RestController
@Slf4j
@Api(value = "测试服务")
@RequestMapping("/test")
public class TestController {

    private static String HOSTS = "47.105.171.231:9200";

    public ResponseEntity<String> create() {

        ResponseEntity<String> resp = ResponseEntity.success(ResponseEntity.class);
        GetRequest getRequest = new GetRequest();

        return resp;
    }

    public RestClientBuilder getClientBuilder() {
        String[] hostNamesPort = HOSTS.split(",");

        String host;
        int port;

        String[] temp;

        RestClientBuilder restClientBuilder = null;

        if (0 != hostNamesPort.length) {
            for (String hostPort : hostNamesPort) {
                temp = hostPort.split(":");
                host = temp[0].trim();
                port = Integer.valueOf(temp[1].trim());
                restClientBuilder = RestClient.builder(new HttpHost(host, port, "http"));
            }
        }

        Header[] defaultHeaders = new Header[]{new BasicHeader("header", "application/json")};

        return restClientBuilder;
    }
}
