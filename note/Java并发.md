**JMM模型**

**并发特性：**

- 原子性
- 有序性
- 可见性

**缓存一致性协议  MESI MSI MOESI**

M：修改

E：独占

S：独享

I：无效

总线嗅探机制



###### 初始化对象

1. 分配一片内存空间
2. 对象的初始化
3. 指向内存地址



#### Volatile重排序规则

![image.png](https://cdn.nlark.com/yuque/0/2020/png/1446391/1600328003232-dfc38184-11be-4cf1-97f7-67639bfe1553.png?x-oss-process=image%2Fresize%2Cw_447)

**结论：**

1. 第二个操作是volatile写，不管第一个操作是什么都不会重排序
2. 第一个操作是volatile读，不管第二个操作是什么都不会重排序
3. 第一个操作是volatile写，第二个操作是volatile读，也不会发生重排序



***JMM内存屏障插入策略：***

1. 在每个volatile写操作的前面插入一个StoreStore屏障
2. 在每个volatile写操作的后面插入一个StoreLoad屏障
3. 在每个volatile读操作的前面插入一个LoadLoad屏障
4. 在每个volatile读操作的后面插入一个LoadLoad屏障

<font color='red'>注意：X86处理器不会对读-读、读-写和写-写操作做重排序, 会省略掉这3种操作类型对应的内存屏障。仅会对写-读操作做重排序，所以volatile写-读操作只需要在volatile写后插入StoreLoad屏障</font>

***内存屏障***

硬件层提供了一系列的内存屏障memory barrier / memory fence(Intel的提法)来提供一直性的能力，那X86平台来说，有几种主要的内存屏障：

1. lfence，是一种Load Barrier读屏障

2. sfence，是一种Store Barrier写屏障

3. mfence，是一种全能型的屏障，具备lfence和sfence的能力

4. Lock前缀，Lock不是一种内存屏障，但是它能完成类似内存屏障的功能，Lock会对CPU总线和告诉缓存加锁，可以理解为CPU指令级的一种锁，它后面可以跟ADD, ADC, AND, BTC, BTR, BTS, CMPXCHG, CMPXCH8B, DEC, INC, NEG, NOT, OR, SBB, SUB, XOR, XADD, and XCHG等指令

   ​	

   内存屏障有两个能力：

   1. 阻止屏障两边的指令重排序
   2. 刷新处理器缓存/冲刷处理器缓存

对Load Barrier来说，在读指令前插入读屏障，可以让告诉缓存中的数据失效，重新从主内存中加载数据

对Store Barrier来说，在写指令之后插入写屏障，能让写入缓存的最新数据写回到主内存



Lock前缀实现了类似的能力，它先对总线和缓存加锁，然后执行后面的指令，最后释放后会把告诉缓存中的数据刷新回主内存，在Lock锁住总线的时候，其他CPU的读写请求都会被阻塞，直到锁释放

不同硬件实现内存屏障的方式不同，Java内存模型屏蔽了这种底层硬件平台的差异，由JVM来为不同的平台生成相应的机器码



***ThreadPoolExecutor***

1. newFixedThreadPool
   1. CorePoolSize: n
   2. MaximumPoolSize: n
   3. KeepAliveTime: 0
   4. LinkedBlockingQueue
2. newCachedThreadPool
   1. CorePoolSize: 0
   2. MaximumPoolSize: Integer.MAX
   3. KeepAliveTime: 60L
   4. SynchronousQueue
3. newSingleThreadPool
   1. CorePoolSize: 1
   2. MaximumPoolSize: 1
   3. KeepAliveTime: 0
   4. LinkedBlockingQueue

***多线程类型***

1. IO密集型
2. CPU密集型