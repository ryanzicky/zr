package com.zr.framework;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zhourui
 * @Date: 2020-12-02 15:14
 **/
public class ApplicationContext {

    private Class configClass;
    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();
    private Map<String, Object> singletonObjects = new HashMap<>(); // 单例池

    public ApplicationContext(Class configClass) {
        this.configClass = configClass;

        // 扫描--beanDefinition
        scan(configClass);

        // 创建非懒加载的单例bean
        createNonLazySingleton();
    }

    private void createNonLazySingleton() {
        for (String beanName : beanDefinitionMap.keySet()) {
            BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
            if (beanDefinition.getScope().equals("singleton") && !beanDefinition.isLazy()) {
                // 创建bean
                Object bean = createBean(beanDefinition);
                singletonObjects.put(beanName, bean);
            }
        }
    }

    private Object createBean(BeanDefinition beanDefinition) {

        Class beanClass = beanDefinition.getBeanClass();
        try {
            Object instance = beanClass.getDeclaredConstructor().newInstance();

            // 填充属性
            for (Field field : beanClass.getDeclaredFields()) {
                if (field.isAnnotationPresent(Autowired.class)) {
                    Object bean = getBean(field.getName());
                    field.setAccessible(true);
                    field.set(instance, bean);
                }
            }

            return instance;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        return null;
    }

    private void scan(Class configClass) {
        if (configClass.isAnnotationPresent(ComponentScan.class)) {
            ComponentScan componentScanAnnotation = (ComponentScan) configClass.getAnnotation(ComponentScan.class);
            String path = componentScanAnnotation.value();
            path = path.replace(".", "/");

            ClassLoader classLoader = ApplicationContext.class.getClassLoader();
            URL resource = classLoader.getResource(path);
            File file = new File(resource.getFile());

            for (File f : file.listFiles()) {
                String s = f.getAbsolutePath();
                if (s.endsWith(".class")) {
                    s = s.substring(s.indexOf("com"), s.indexOf(".class"));
                    s = s.replace("\\", ".");

                    try {
                        Class clazz = classLoader.loadClass(s);
                        System.out.println(clazz);
                        if (clazz.isAnnotationPresent(Component.class)) {
                            // 这是一个bean
                            BeanDefinition beanDefinition = new BeanDefinition();
                            beanDefinition.setBeanClass(clazz);

                            Component componentAnnotation = (Component) clazz.getAnnotation(Component.class);
                            String beanName = componentAnnotation.value();

                            // 创建非懒加载的单例bean
                            if (clazz.isAnnotationPresent(Lazy.class)) {
                                // 懒加载
                            }

                            if (clazz.isAnnotationPresent(Scope.class)) {
                                Scope scopeAnnotation = (Scope) clazz.getAnnotation(Scope.class);
                                String value = scopeAnnotation.value();
                                beanDefinition.setScope(value);
                            } else {
                                // 单例
                                beanDefinition.setScope("singleton");
                            }

                            beanDefinitionMap.put(beanName, beanDefinition);
                        }
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public Object getBean(String beanName) {
        // map
        // 单例 or 原型
        if (null == beanDefinitionMap.get(beanName)) {
            throw new NullPointerException();
        } else {
            BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
            if (beanDefinition.getScope().equals("singleton")) {
                // 单例池
                Object o = singletonObjects.get(beanName);
                if (o == null) {
                    Object bean = createBean(beanDefinition);
                    singletonObjects.put(beanName, bean);
                }
                return o;
            } else if (beanDefinition.getScope().equals("propertype")) {
                // 创建一个bean
                Object bean = createBean(beanDefinition);
                return bean;
            }
        }
        return null;
    }

}
