package com.zr;

import com.zr.framework.ComponentScan;
import com.zr.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: zhourui
 * @Date: 2020-12-02 15:38
 **/
@ComponentScan("com.zr.service")
public class AppConfig {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.test();

        applicationContext.registerShutdownHook();
    }
}
