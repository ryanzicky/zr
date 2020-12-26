package com.web.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author zhourui
 * @Date 2020/12/26 15:34
 */
@FeignClient(name = "web-client", fallbackFactory = TestFeignFactory.class)
public interface TestFeign {

    /**
     * 测试feign调用
     *
     * @return
     */
    @GetMapping("/test/hello")
    String hello();
}
