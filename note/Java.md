## Java笔记
1.  JVM  
2.  数组和列表
3.  多线程
    - JMM&Volatile
    - ThreadPoolExecutor
    - Synchronized
    - CAS
        - ABA
    - AQS
    - CyclicBarrier 栅栏
    - CountDownlatch 计数器
    - Semaphore 信号量
    - ForkJoinPool 
4.  Spring

### 问题
1. 对Volatile的理解
2. 对AQS的理解

    
#### 多线程
1. 并发编程的本质
 - 多线程编程：
    - 同步：线程间协作 AQS
    - 互斥：独占锁
    - 分工：大任务的拆解 ForkJoin

2. 并发学什么  
    1. JMM模型 Java线程内存模型(JMM JVM JOM)  
       
        并发特性：原子性 有序性 可见性
        硬件：机械同感 CPU缓存架构 缓存一致性协议 volatile & cas (高频)
    2. 线程 内核级线程 new Thread()和普通的java对象(new Object())有什么区别？    
        JVM不具备调度CPU的权限 javaThread------osThread-----内核线程(pthread_create)
        
    3. 锁机制  同步器(加锁目的：徐泪花的访问临界资源)    
        JVM内置锁 synchronized 自适应锁  偏向锁  轻量级锁  重量级锁  object monitor机制 
        juc 独占锁 共享锁 读写锁 公平/非公平锁  AQS (同步 条件) (高频) 
        等待唤醒机制  wait/notify park/unpark  
        中断机制  
    
    4. 线程池 线程复用  
    5. 工具类 & 并发容器  ConcurrentHashMap & HashMap(高频)
    6. 并行 forkJoin
    
#### 并发的风险：
1. 性能问题 (上下文频繁切换)
2. 活跃性问题 (饥饿 死锁 活锁)
3. 线程安全 加锁  三大特性 happens-before(八大特性 + 6条推论)

#### 并发设计模式
不变性  只读  CopyOnWrite  等待唤醒机制  生产者消费者模式  

#### JVM内存模型
虚拟机栈  线程栈

#### JVM调优
1. OOM调优
    1. 内存溢出
    2. 内存逃逸
2. CPU100%调优
    1. 找出那个进程CPU高
    2. 该进程中的哪个线程cpu高
    3. 导出该线程的堆栈
    4. 查找哪个方法(栈帧)消耗时间(jstack)
    5. 工作线程占比高|垃圾回收线程占比高
    
    
    
    
### 分布式事务
    1. 什么是事务
        要么什么都不做，要么做全套(All or Nothing)
    2. 数据库的ACID属性
        1. 原子性：事务操作的整体性
        2. 一致性：事务操作下数据的正确性
        3. 隔离性：事务并发操作下数据的正确性
        4. 持久性：事务对数据修改的可靠性
        ![数据库事务的ACID属性](https://user-gold-cdn.xitu.io/2018/12/10/1679817cdb54ec09?imageView2/0/w/1280/h/960/format/webp/ignore-error/1)
    3. 分布式事务
        分布式事务的难点：
            1. 事务的原子性
            2. 事务的一致性
            3. 事务的隔离性
    4. 分布式系统的一致性
        1. 可用性和一致性的冲突CAP理论
            ![CAP](https://user-gold-cdn.xitu.io/2018/12/10/1679817cdb4305db?imageView2/0/w/1280/h/960/format/webp/ignore-error/1)
            CAP理论的定义：在一个分布式系统中，当设计读写操作时，只能保证一致性，可用性，分区容错性三者中的两个
        2. CAP理论的延伸--BASE理论
            ![BASE](https://user-gold-cdn.xitu.io/2018/12/10/1679817d128d0b37?imageView2/0/w/1280/h/960/format/webp/ignore-error/1)
            BASE指基本可用，软状态，最终一致性，核心思想是无法做到强一致性(CAP的一致性就是强一致性),但应用可以采用适合的方式达到最终一致性
            
    5. 数据一致性模型
        1. 强一致性
        2. 弱一致性
        3. 最终一致性
        
    6. 常见分布式事务解决方案
        1. 2PC(二阶段提交)方案---强一致性
            阶段1：准备阶段
            阶段2：提交阶段
        2. 3PC(三阶段提交)方案
            阶段1：canCommit
            阶段2：preCommit
            阶段3：doCommit
            
            优点：相比二阶段提交，三阶段降低了阻塞范围
            缺点：数据不一致问题依然存在
            
        3. TCC(Try-Confirm-Cancel)事务---最终一致性
            Try操作作为一阶段，负责资源的检查和预留
            Confirm操作作为二阶段提交操作，执行真正的业务
            Cancel是预留资源的取消
            
            相对于传统事务：
                1. 性能提升
                2. 数据最终一致性
                3. 可靠性
            缺点：业务耦合度高，提高了开发成本
            
         4. 本地消息表---最终一致性
         5. MQ事务---最终一致性
         6. Sega事务---最终一致性
### 分布式锁
    1. Mysql
    2. Redis
    3. Zookeeper
    4. 
### 分布式id
    1. 百度 uidGenerator
    2. 美团 leaf
    3. 雪花算法：组成部分(64bit)
        1. 第一位 1bit始终是0
        2. 时间戳 41bit
        3. 工作机器id 10bit
        4. 序列号 12bit
    
### JVM
### Spring
### Spring boot
### Spring boot 启动原理
### volatile
### hashMap
    
### currentHashMap
### 线程池
### IOC AOP DI

### ES写入，查询原理
### 分布式事务
### RabbitMQ
    5种模式：
        1. 简单模式
        2. 工作队列模式
        3. 发布/订阅模式
        4. 路由模式
        5. 通配符模式
### Kafka
### 设计MQ
### 数据一致性
### 阻塞队列
    
### Redis
    1. 单线程还是多线程
        6.0以后IO多线程
        客户端单线程，处理数据多线程
        worker线程只有一个，每个IO内部一个socket连接，串行处理
    2. 缓存穿透
        缓存和数据库都不存在
        布隆过滤器
        redis未查到，加分布式锁
    3. 缓存击穿
        redis热点key失效，数据库有，没有缓存过
        key加锁
    4. 缓存雪崩
        大量数据没有缓存过
        key加锁
    5. 缓存淘汰：
        lru/lfu/random
        定期删除
        惰性删除
    6. 数据库与缓存不一致
        双写不一致
        
        
### MQ死信
    1. 消息被拒绝，并且requeue = false
    2. 消息TTL过期
    3. 队列达到最大长度
    
    出现死信队列，RabbitMQ自动将这个消息重新发布到设置的ExChange上
  
### JVM

### ES
    1. 写入原理
    2. 查询原理
    3. 倒排原理
        
    HashMap
    SkipList
    Tire 字典树
    FST
    
### Spring Boot启动流程
    Spring Boot启动需要@SpringBootApplication注解，实际上是一个组合注解
    包含@Configuration配置类，@ComponentScan类，包扫描，@EnableAutoConfiguration根据需求自动加载
    相关的Bean这三个注解   
    启动流程如下：
        1. 初始化监听器，以及添加到SpringApplication的自定义监听器
        2. 
        
### 
    
