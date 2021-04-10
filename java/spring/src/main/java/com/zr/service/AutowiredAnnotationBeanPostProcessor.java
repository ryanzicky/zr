package com.zr.service;

import com.zr.framework.BeanPostProcessor;
import com.zr.framework.Component;

/**
 * @Author: zhourui
 * @Date: 2020-12-04 14:10
 **/
@Component
public class AutowiredAnnotationBeanPostProcessor implements BeanPostProcessor {

    @Override
    public void autowired() {
        System.out.println("处理Autowired注解");
    }
}
