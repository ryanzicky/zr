### 背景
    Disruptor是英国外汇交易公司LMAX开发的一个高性能队列，研发的初衷是解决内存队列的延迟问题（在性能测试中发现竟然与I/O操作处于同样的数量级）。
    基于Disruptor开发的系统单线程能支撑每秒600万订单，2010年在QCon演讲后，获得了业界关注。2011年，企业应用软件专家Martin Fowler专门撰写长文介绍。
    同年它还获得了Oracle官方的Duke大奖。
    
    目前，包括Apache Storm、Camel、Log4j 2在内的很多知名项目都应用了Disruptor以获取高性能。
    
    需要特别指出的是，这里所说的队列是系统内部的内存队列，而不是Kafka这样的分布式队列。另外，本文所描述的Disruptor特性限于3.3.4。
### Java内置队列
    介绍Disruptor之前，我们先来看一看常用的线程安全的内置队列有什么问题。Java的内置队列如下表所示。

    队列 | 有界性 | 锁 | 数据结构
    ---|---|---|---
    ArrayBlockingQueue | bounded | 加锁 | arrayList
    LinkedBlockinfQueue | optionally-bounded | 加锁 | linkedList
    ConcurrentLinkedQueue | unbounded | 无锁 | linkedList
    LinkedTransferQueue | unbounded | 无锁 | linkedList
    PriorityBlockingQueue | unbounded | 加锁 | heap
    DelayQueue | unbounded | 加锁 | heap
    
    队列的底层一般分成三种：数组，链表和堆。其中，堆一般情况下是为了实现带有优先级特性的队列，暂不考虑。
    我们就从数组和链表两种数据结构来看，基于数组线程安全的队列，比较典型的是ArrayBlockingQueue，它主要通过加锁的方式来保证线程安全；
    基于链表的线程安全分成LinkedBlockingQueue和ConcurrentLinkedQueue两大类，前者也通过锁的方式来实现线程安全，
    而后者以及上面表格中的LinkedTransferQueue都是通过原子变量 compare and swap(CAS)这中不加锁的方式来实现
    
    通过不加锁的方式实现的队列都是误解的(无法保证队列的长度在确定的范围内)；而加锁的方式，可以实现有界队列。在稳定性要求特别高的系统中，
    为了防止生产速度过快，导致内存溢出，只能选择有界队列；同时，为了减少Java的垃圾回收对系统性能的影响，会尽量选择array/heap格式的数据结构，
    这样筛选下来，符合条件的队列就只有ArrayBlockingQueue。

### ArrayBlockingQueue的问题
    ArrayBlockingQueue在实际使用过程中，会因为加锁和伪共享等出现严重的性能问题，我们下面来分析一下
    
    **加锁**
    加锁通常会严重的影响性能，线程会因为竞争不到锁而被挂起，等待锁被释放的时候，线程又会恢复，这个过程中存在很大的开销，
    并且通常会有较长时间的终端，因为当一个线程正在等待锁时，它不能做任何其他事情，如果一个线程在持有锁的情况下被延迟执行，
    例如发生了缺页错误，调度延迟或者其他类似情况，那么所有需要这个锁的线程都无法执行下去。如果被阻塞线程的优先级较高，而
    持有锁的线程优先级较低，就会发生优先级反转。
    
    Disruptor论文中讲述了一个实验：
        - 这个测试程序调用了一个函数，该函数会对一个64位的计数器循环自增5亿次
        - 机器环境：2.4G 6核
        - 运算：64位的计数器累加5亿次
        
    CAS操作比单线程无锁慢了1个数量级；有锁且多线程并发的情况下，速度比单线程无锁慢3个数量级。可见无锁速度最快
    单线程情况下，不加锁的性能 > CAS操作的性能 > 加锁的性能
    在多线程情况下，为了保证线程安全，必须使用CAS或锁，这中情况下，CAS的性能超过锁的性能，前者大约是后者的8倍
    综上可知，加锁的性能是最差的
    
    **关于锁和CAS**
    保证线程安全一般分为两种方式：锁和原子变量
        **锁**
        采取加锁的方式，默认线程会冲突，访问数据时，先加上锁再访问，访问之后再解锁，通过锁界定一个临界区，同时只有一个线程进入。
        下面是ArratBlockingQueue通过加锁的方式实现的offer方法，保证线程安全：
        public boolean offer(E e) {
            checkNotNull(e);
            final ReentrantLock lock = this.lock;
            lock.lock();
            
            try {
                if (count == items.length) {
                    return false;
                } else {
                    insert(e);
                    return true;
                }
            } finally {
                lock.unlock();
            }
        } 
        
        **原子变量**
        原子变量能够保证原子性的操作，意思是某个任务在执行过程中，要么全部成功，要么全部失败回滚，恢复到执行之前的初态，
        不存在初态和成功之间的中间状态，例如CAS操作，要么比较并交换成功，要么比较并交换失败，由CPU保证原子性，
        
    