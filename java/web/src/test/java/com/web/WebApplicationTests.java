package com.web;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WebApplicationTests {

    @BeforeEach
    public static void before() {
        System.out.println("before");
    }

    @Test
    void contextLoads() {
        System.out.println("test");
    }

    @AfterAll
    public void after() {
        System.out.println("after");
    }

}
