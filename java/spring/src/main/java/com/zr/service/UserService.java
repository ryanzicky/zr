package com.zr.service;

import com.zr.framework.*;

/**
 * @Author: zhourui
 * @Date: 2020-12-02 15:11
 **/
@Component("userService")
@Scope("propertype")
public class UserService implements BeanNameAware, InitializingBean {

    @Autowired
    private OrderService orderService;

    private String beanName;

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }

    @Override
    public void afterPropertiesSet() {

    }

    public void test() {
        System.out.println(orderService);
        System.out.println(beanName);
    }
}
