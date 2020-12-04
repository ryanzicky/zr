package com.zr;

import com.zr.framework.ApplicationContext;
import com.zr.service.UserService;

/**
 * @Author: zhourui
 * @Date: 2020-12-02 15:13
 **/
public class Test {

    public static void main(String[] args) {
        // 1. 启动Spring 2. 扫描 3. 创建Bean(单例bean)
        ApplicationContext applicationContext = new ApplicationContext(AppConfig.class);

        /*Object userService = applicationContext.getBean("userService");
        Object userService1 = applicationContext.getBean("userService");
        Object userService2 = applicationContext.getBean("userService");
        System.out.println(userService);
        System.out.println(userService1);
        System.out.println(userService2);*/

        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.test();
    }
}
