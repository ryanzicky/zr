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

  

