### Spring原理
    它是一个全面的、企业应用开发一站式的解决方案，贯穿表现层、业务层、持久层。但是 Spring
    仍然可以和其他的框架无缝整合。
    
    特点：
        1. 轻量级
        2. 控制反转
        3. 面向切面
        4. 容器
        5. 框架集合
        
    常用模块：
        1. 核心容器
        2. Spring上下文
        3. Spring AOP
        4. Spring DAO
        5. Spring ORM
        6. Spring Web 模块
        7. Spring MVC 框架
        
    Spring 主要包：
    Spring 常用注解：
    Spring 第三方结合：
        权限
        缓存
        持久层框架
        定时任务
        校验框架
        
### IOC原理

### Spring Bean作用域
    5种作用域：
        1. 单例：Singleton
        2. 原型：Prototype
        3. request
        4. session
        5. global session
        
        1. 单例模式：
            Spring IOC容器中只会存在一个共享的Bean实例
            在多线程下是不安全的
        2. 原型模式：
            每次通过Spring容器获取prototype定义的bean时，容器都将创建
            一个新的Bean实例，每个Bean实例都有自己的属性和状态
            而Singleton全局只有一个对象，根据经验，对有状态的Bean使用
            prototype作用域，而对无状态的Bean使用Singleton作用域
        3. request：
            一次reques一个实例
            再一次Http请求中，容器会返回该Bean的同一实例，对不同的http请求
            会产生新的Bean，而且该Bean仅在当前Http Request内有效，当前Http请求结束
            该Bean实例也将会被销毁
        4. session
            再一次Http Session中，容器会返回该Bean的同一实例，而对不同的Session
            请求则会创建新的实例，该bean实例仅在当前Session内有效。同http请求相同，
            每一次session请求创建新的实例，而不同的实例之间不共享属性，且实例仅在自己的session
            请内有效，请求结束，则实例将销毁    
        5. global session
            在一个全局的Http Session中，容器会返回该Bean的同一个实例，仅在使用portlet context时有效
            
### Spring Bean生命周期
    1. 实例化
        实例化一个Bean，也就是我们常说的NEW
    2. IOC依赖注入
        按照Spring 上下文对实例化的Bean进行配置，也就是IOC注入
    3. setBeanName实现
        如果这个Bean实现了BeanNameAware接口，会调用它实现的setBeanName(String)方法，
        此处传递的就是Spring配置文件中Bean的id值
    4. BeanFactoryAware实现
        如果这个Bean实现了BeanFactoryAware接口，会调用它实现的setBeanFactory，setBeanFactory(BeanFactory)
        传递的是Spring 工厂自身(可以用这个方式来获取其他Bean，只需要在Spring配置文件中配置一个普通的Bean就可以)
    5. ApplicationContextAware实现
        如果这个Bean已经实现了ApplicationContextAware接口，会调用setApplicationContext(ApplicationContext)方法
        传入Spring上下文(同样这个方式也可以实现步骤4的内容，但比4更好，因为ApplicationContext是BeanFactory的子接口。
        有更多的实现方法)
    6. POSTProcessBeforeInitialization接口实现-初始化预处理
        如果这个Bean关联了BeanPostProcessor接口，会调用postProcessBeforeInitialization(Object obj, String s)方法
        BeanPostProcessor经常用作是Bean内容的更改，并且由于这个是在Bean初始化结束时调用那个的方法，也可以被应用
        于内存或缓存技术
    7. init-method
        如果Bean在Spring配置文件中配置了init-method属性会自动调用其配置的初始化方法
    8. postProcessAfterInitialization
        如果这个 Bean 关联了 BeanPostProcessor 接口，将会调用
        postProcessAfterInitialization(Object obj, String s)方法。
        注：以上工作完成以后就可以应用这个 Bean 了，那这个 Bean 是一个 Singleton 的，所以一
        般情况下我们调用同一个 id 的 Bean 会是在内容地址相同的实例，当然在 Spring 配置文件中
        也可以配置非 Singleton。
    9. Destroy 过期自动清理阶段
        如果Bean实现了DisposableBean接口，会调用哪个其实现的destory()方法
    10. destroy-method 自动配置清理
        最后，如果这个 Bean 的 Spring 配置中配置了 destroy-method 属性，会自动调用其配置的
        销毁方法。
        
### Spring依赖注入四种方式
    1. 构造器注入
    2. setter注入
    3. 静态工厂注入
    4. 实例工厂注入
            
### 5种不同方式的自动装配
    Spring 装配包括手动装配和自动装配，手动装配是有基于 xml 装配、构造方法、setter 方法等
    自动装配有五种自动装配的方式，可以用来指导 Spring 容器用自动装配方式来进行依赖注入  
    
    1. no：默认的方式是不进行自动装配，通过显式设置 ref 属性来进行装配
    2. byName：通过参数名 自动装配，Spring 容器在配置文件中发现 bean 的 autowire 属性被设
    置成 byname，之后容器试图匹配、装配和该 bean 的属性具有相同名字的 bean
    3. byType：通过参数类型自动装配，Spring 容器在配置文件中发现 bean 的 autowire 属性被
    设置成 byType，之后容器试图匹配、装配和该 bean 的属性具有相同类型的 bean。如果有多
    个 bean 符合条件，则抛出错误
    4. constructor：这个方式类似于 byType， 但是要提供给构造器参数，如果没有确定的带参数
    的构造器参数类型，将会抛出异常。
    5. autodetect：首先尝试使用 constructor 来自动装配，如果无法工作，则使用 byType 方式

### Spring AOP原理
    "横切"的技术，剖解开封装的对象内部，并将那些影响了多个类的公共行为封装到一个可重用模块，
    并将其命名为"Aspect"，即切面。所谓"切面"，简单说就是那些与业务无关，却为业务模块所共
    同调用的逻辑或责任封装起来，便于减少系统的重复代码，降低模块之间的耦合度，并有利于未
    来的可操作性和可维护性。
    使用"横切"技术，AOP 把软件系统分为两个部分：核心关注点和横切关注点。业务处理的主要流
    程是核心关注点，与之关系不大的部分是横切关注点。横切关注点的一个特点是，他们经常发生
    在核心关注点的多处，而各处基本相似，比如权限认证、日志、事物。AOP 的作用在于分离系统
    中的各种关注点，将核心关注点和横切关注点分离开来
    
    
    AOP 核心概念
        1. 切面(aspect)：类是对屋里特征的抽象，切面就是对横切关注点的抽象
        2. 横切关注点：对那些方法进行拦截，拦截后怎么处理，这些关注点称之为横切关注点
        3. 连接点(joinpoint)：被拦截到的点，因为Spring 只支持方法类型的连接点，所以在Spring
        中连接点指的就是被拦截到的方法，实际上连接点还可以是字段或者构造器
        4. 切入点(pointcut)：对连接点进行拦截的定义
        5. 通知(advice)：所谓通知指的就是指拦截到连接点之后要执行的代码，通知分为
        前置，后置，异常，最终，环绕通知五类
        6. 目标对象：代理的目标对象
        7. 织入(weave)：将切面应用到目标对象并导致代理对象创建的过程
        8. 引入(introduction)：在不修改代码的前提下，引入可以在运行期为类
        动态地添加一些方法或字段
        
### AOP 两种代理方式
    Spring 提供了两种方式来生成代理对象: JDKProxy 和 Cglib，具体使用哪种方式生成由
    AopProxyFactory 根据 AdvisedSupport 对象的配置来决定。默认的策略是如果目标类是接口，
    则使用 JDK 动态代理技术，否则使用 Cglib 来生成代理
    
    JDK 动态接口代理
        JDK 动态代理主要涉及到 java.lang.reflect 包中的两个类：Proxy 和 InvocationHandler。
        InvocationHandler是一个接口，通过实现该接口定义横切逻辑，并通过反射机制调用目标类
        的代码，动态将横切逻辑和业务逻辑编制在一起。Proxy 利用 InvocationHandler 动态创建
        一个符合某一接口的实例，生成目标类的代理对象
        
    CGLib 动态代理
        Cglib全称为Code Generation Library，是一个强大的高性能，高质量的代码生成类库
        可以在运行期扩展 Java 类与实现 Java 接口，CGLib 封装了 asm，可以再运行期动态生成新
        的 class。和 JDK 动态代理相比较：JDK 创建代理有一个限制，就是只能为接口创建代理实例，
        而对于没有通过接口定义业务方法的类，则可以通过 CGLib 创建动态代理    
        
### Spring MVC原理
    Spring 的模型-视图-控制器（MVC）框架是围绕一个DispatcherServlet来设计的，这个servlet会把
    请求分发给各个处理器，并支持可配置的处理器映射，视图渲染，本地化，失去与主题渲染等，
    甚至还能支持文件上传
    
    1. Http 请求到 DispatcherServlet
        客户端请求提交到 DispatcherServlet。
    2. HandlerMapping 寻找处理器
        由 DispatcherServlet 控制器查询一个或多个 HandlerMapping，找到处理请求的
        Controller
    3. 调用处理器Controller
        DispatcherServlet 将请求提交到 Controller
    4. Controller 调用业务逻辑处理后，返回 ModelAndView
        调用业务处理和返回结果：Controller 调用业务逻辑处理后，返回 ModelAndView
    5. DispatcherServlet 查询 ModelAndView
        处理视图映射并返回模型： DispatcherServlet 查询一个或多个 ViewResoler 视图解析器，
        找到 ModelAndView 指定的视图。
    6. ModelAndView 反馈浏览器 HTTP
        Http 响应：视图负责将结果显示到客户端
        
                   

    