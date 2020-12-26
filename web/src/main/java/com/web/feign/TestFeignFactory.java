package com.web.feign;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Service;

/**
 * @Author zhourui
 * @Date 2020/12/26 15:38
 */
@Service
public class TestFeignFactory implements FallbackFactory<TestFeign> {

    @Override
    public TestFeign create(Throwable cause) {
        return new TestFeign() {
            @Override
            public String hello() {
                return "feign error";
            }
        };
    }
}
