#### Spring中核心概念
1. BeanDefinition

2. BeanDefinitionReader

3. AnnotatedBeanDefinitionReader

4. XmlBeanDefinitionReader

5. ClassPathBeanDefinitionScanner

6. BeanFactory

    Spring中比较核心的是BeanFacotory的实现类是DefaultListableBeanFactory

    ![img](https://cdn.nlark.com/yuque/0/2020/png/365147/1602053031607-fd00a145-67fa-4231-8cca-9186db5f2b00.png)
    
    它实现了很多接口，表示，它拥有很多功能：
    
    1. AliasRegistry：支持别名功能，一个名字可以对应多个别名
    2. BeanDefinitionRegistry：可以注册、保存、移除、获取某个BeanDefinition
    3. BeanFactory：Bean工厂，可以根据某个bean的名字、或类型、或别名获取某个Bean对象
    4. SingletonBeanRegistry：可以直接注册、获取某个**单例**Bean
    5. SimpleAliasRegistry：它是一个类，实现了AliasRegistry接口中所定义的功能，支持别名功能
    6. ListableBeanFactory：在BeanFactory的基础上，增加了其他功能，可以获取所有BeanDefinition的beanNames，可以根据某个类型获取对应的beanNames，可以根据某个类型获取{类型：对应的Bean}的映射关系
    7. HierarchicalBeanFactory：在BeanFactory的基础上，添加了获取父BeanFactory的功能
    8. DefaultSingletonBeanRegistry：它是一个类，实现了SingletonBeanRegistry接口，拥有了直接注册、获取某个**单例**Bean的功能
    9. ConfigurableBeanFactory：在HierarchicalBeanFactory和SingletonBeanRegistry的基础上，添加了设置父BeanFactory、类加载器（表示可以指定某个类加载器进行类的加载）、设置Spring EL表达式解析器（表示该BeanFactory可以解析EL表达式）、设置类型转化服务（表示该BeanFactory可以进行类型转化）、可以添加BeanPostProcessor（表示该BeanFactory支持Bean的后置处理器），可以合并BeanDefinition，可以销毁某个Bean等等功能
    10. FactoryBeanRegistrySupport：支持了FactoryBean的功能
    11. AutowireCapableBeanFactory：是直接继承了BeanFactory，在BeanFactory的基础上，支持在创建Bean的过程中能对Bean进行自动装配
    12. AbstractBeanFactory：实现了ConfigurableBeanFactory接口，继承了FactoryBeanRegistrySupport，这个BeanFactory的功能已经很全面了，但是不能自动装配和获取beanNames
    13. ConfigurableListableBeanFactory：继承了ListableBeanFactory、AutowireCapableBeanFactory、ConfigurableBeanFactory
    14. AbstractAutowireCapableBeanFactory：继承了AbstractBeanFactory，实现了AutowireCapableBeanFactory，拥有了自动装配的功能
    15. DefaultListableBeanFactory：继承了AbstractAutowireCapableBeanFactory，实现了ConfigurableListableBeanFactory接口和BeanDefinitionRegistry接口，所以DefaultListableBeanFactory的功能很强大
    
7. ApplicationContext

    ![img](https://cdn.nlark.com/yuque/0/2020/png/365147/1602055467561-b96bd4c4-9be4-4abb-99da-73f3f147ec3e.png)

    1. HierarchicalBeanFactory：拥有获取父BeanFactory的功能

    2. ListableBeanFactory：拥有获取beanNames的功能

    3. ResourcePatternResolver：资源加载器，可以一次性获取多个资源（文件资源等等）

    4. EnvironmentCapable：可以获取运行时环境（没有设置运行时环境功能）

    5. ApplicationEventPublisher：拥有广播事件的功能（没有添加事件监听器的功能）

    6. MessageSource：拥有国际化功能

    又两个比较重要的实现类：

    1. AnnotationConfigApplicationContext
    2. ClassPathXmlApplicationContext

8. AnnotationConfigApplicationContext

    ![img](https://cdn.nlark.com/yuque/0/2020/png/365147/1602055860352-0925b046-b88e-4085-b872-b1ec5aeb8fee.png)

#### Bean生命周期

**Spring最重要的功能就是帮助程序员创建对象(也就是IOC)，而确定Spring就是为创建Bean对象做准备，所以我们先明白Spring到底是怎么创建Bean的，也就是先弄明白Bean的生命周期**

![Bean的生命周期流程.png](https://cdn.nlark.com/yuque/0/2020/png/365147/1602587965056-87dd226a-0989-42ab-bfab-3fb4868fd4ac.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_20%2Ctext_6bKB54-t5a2m6Zmi5Ye65ZOB%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fresize%2Cw_746)



1. 生成BeanDefinition

    Spring启动的时候会进行扫描，会先调用

    ```
    Resource[] resources = getResourcePatternResolver().getResources(packageSearchPath);
    ```

2. 合并BeanDefinition

    如果某个BeanDefinition存在父BeanDefinition，则要进行合并
    
3. 加载类

4. 实例化前

5. 单独构造方法

6. 实例化

7. BeanDefinition的后置处理

8. 填充属性

9. 执行Aware

10. 初始化前

11. 初始化

12. 初始化后

#### Bean的销毁过程

1. 容器关闭
2. 发布COntextClosedEvent
3. 调用LifecycleProcessor的onClose方法
4. 销毁单例Bean