package com.zr.service;

import com.zr.framework.Autowired;
import com.zr.framework.Component;
import com.zr.framework.Scope;

/**
 * @Author: zhourui
 * @Date: 2020-12-02 15:11
 **/
@Component("userService")
@Scope("propertype")
public class UserService {

    @Autowired
    private OrderService orderService;

    private String name;

    public void test() {
        System.out.println(orderService);
    }
}
