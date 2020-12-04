package com.zr.framework;

import org.springframework.beans.BeansException;

/**
 * @Author: zhourui
 * @Date: 2020-12-04 14:09
 **/
public interface BeanPostProcessor {

    void autowired();

    default Object postProcessBeforeInitialization(Object bean, String beanName) {
        return bean;
    };

    default Object postProcessAfterInitialization(Object bean, String beanName) {
        return bean;
    }
}
