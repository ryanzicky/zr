package com.web.controller;

import com.web.feign.TestFeign;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

    @Autowired
    private TestFeign testFeign;

    @GetMapping("/hello")
    public String hello() {
        return testFeign.hello();
    }
}
