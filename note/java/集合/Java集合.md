### 集合
    1. 接口继承关系和实现
        集合类存放于Java.util包中，主要有3种：set(集)，list（列表包含Queue）和mqp(映射)
        
        1. Collection：Collection是集合Set，List，Queue的最基本的接口
        2. Iterator：迭代器，可以通过迭代器遍历集合中的数据
        3. Map：是映射表的基础接口
        
    Collection：
        List:
                ArrayList:
                    排列有序，可重复
                    底层使用数组
                    速度快，增删慢。getter()和setter()方法快
                    线程不安全
                    当容量不够时，ArrayList是当前容量 * 1.5 + 1
                    
                Vector:
                   排列有序，可重复
                   底层使用数组
                   速度快，增删慢
                   线程安全，效率低
                   当容量不够时，Vector默认扩展一倍容量
                   
                LinkedList：
                    排列有序，可重复
                    底层使用双向循环链表数据结构
                    查询速度慢，增删快，add()和remove()方法快
                    线程不安全
                    
            Set：
                HashSet：
                    排列无序，不可重复
                    底层使用Hash表实现
                    存取速度快
                    内部是HashMap
                
                TreeSet：
                    排列无序，不可重复
                    底层使用二叉树实现
                    排序存储
                    内部是TreeMap的SortedSet
                    
                LinkedHashSet：
                    采用Hash表存储，并用双向链表记录插入顺序
                    内部是LinkedHashMap
                
            Queue：
                在两段出入的List，所以也可以使用数组或链表实现
                
    Map：
        HashMap：
            键不可重复，值可重复
            底层哈希表
            线程不安全
            允许key为null，value也可以为null
        
        HashTable：
            键不可重复，值可重复
            底层哈希表
            线程安全(全表加锁)
            key，value都不允许为null
        
        TreeMap：
            键不可重复，值可重复
            底层二叉树
            
    
    List是有序的Collection，Java List一共有三个实现类，分别是ArratList，Vector，LinkedList
    ArrayList(数组)：
        允许对元素进行快速随机访问，数组的缺点是每个元素之间不能有间隔，当数组大小不满足时需要增加存储能力，
        就要将已经有数组的数据复制到新的存储空间中。当从ArrayList的中间位置插入或者删除元素时，需要对数组进行
        复制，移动，代价比较高，因此，它适合随机查找和遍历，不适合插入和删除
    
    Vector(数组实现，线程同步)：
        Vector和ArrayList一样，也是通过数组实现的，不同的是它支持线程的同步，即某一时刻只有一个线程能够写Vector
        避免多线程同时写而引起的不一致性，但实现同步需要很高的花费，因此访问它比访问ArrayList慢
        
    LinkedList(链表)：
        LinkedList是用链表结构存储数据的，很适合数据的动态插入和删除，随机访问和遍历速度比较慢，另外，它还提供了List
        接口中没有定义的方法，专门用于操作表头和表尾，可以当做堆栈，队列和双向队列使用
        
    Set：
        Set 注重独一无二的性质,该体系集合用于存储无序(存入和取出的顺序不一定相同)元素，值不能重
        复。对象的相等性本质是对象 hashCode 值（java 是依据对象的内存地址计算出的此序号）判断
        的，如果想要让两个不同的对象视为相等的，就必须覆盖 Object 的 hashCode 方法和 equals 方
        法。
        
    HashSet(Hash 表)：
        哈希表边存放的是哈希值。HashSet 存储元素的顺序并不是按照存入时的顺序（和 List 显然不
        同） 而是按照哈希值来存的所以取数据也是按照哈希值取得。元素的哈希值是通过元素的
        hashcode 方法来获取的, HashSet 首先判断两个元素的哈希值，如果哈希值一样，接着会比较
        equals 方法 如果 equls 结果为 true ，HashSet 就视为同一个元素。如果 equals 为 false 就不是
        同一个元素。
        
    TreeSet(二叉树)：
        1. TreeSet()是使用二叉树的原理对新 add()的对象按照指定的顺序排序（升序、降序），每增
        加一个对象都会进行排序，将对象插入的二叉树指定的位置
        2. Integer 和 String 对象都可以进行默认的 TreeSet 排序，而自定义类的对象是不可以的，自
        己定义的类必须实现 Comparable 接口，并且覆写相应的 compareTo()函数，才可以正常使
        用
        3. 在覆写 compare()函数时，要返回相应的值才能使 TreeSet 按照一定的规则来排序
        4. 比较此对象与指定对象的顺序。如果该对象小于、等于或大于指定对象，则分别返回负整
        数、零或正整数
        
    LinkedList(HashSet + LinkedHashMap)
        对于 LinkedHashSet 而言，它继承与 HashSet、又基于 LinkedHashMap 来实现的。
        LinkedHashSet 底层使用 LinkedHashMap 来保存所有元素，它继承与 HashSet，其所有的方法
        操作上又与 HashSet 相同，因此 LinkedHashSet 的实现上非常简单，只提供了四个构造方法，并
        通过传递一个标识参数，调用父类的构造器，底层构造一个 LinkedHashMap 来实现，在相关操
        作上与父类 HashSet 的操作相同，直接调用父类 HashSet 的方法即可。
        
        
    HashMap(数组 + 链表 + 红黑树)：
        HashMap根据键的hashCode值存储数据，大多数情况下可以直接定位到它的值，因而具有很快的访问速度。
        但遍历顺序确实不确定的，HashMap最多只允许一条记录的键为null，允许多条记录的值为null，HashMap
        非线程安全，即任一时刻可以有多个线程同时写HashMap，可能会导致数据的不一致，如果需要满足线程安全，
        可以使用Collections的synchronizedMap方法使HashMap具有线程安全的能力，或者使用ConcurrentHashMap
        
        大方向上，HashMap里面是一个数组，然后数组中每个元素是一个单向链表
        Entry包含四个属性：
            key，value，hash值和用于单向链表的next
        1. capacity：当前数组容量，始终保持2^n，可以扩容，扩容后数组大小为当前的2倍
        2. loadFactor：负载因子，默认为0.75
        3. threshold：扩容的阈值，等于capacity * loadFactor
        
        Java8实现：
            Java8对HashMap进行了一些修改，最大的不同就是利用了红黑树，所以其由数组 + 链表 + 红黑树组成
            
            根据Java7 HashMap的介绍，我们知道，查找的时候，根据hash值我们能够快速定位到数组的具体下标，
            但是之后的话，需要顺着链表一个个比较下去才能找到我们需要的，时间复杂度取决于链表的长度，
            为O(n)。为了降低这部分的开销，在Java8中，当链表的中的元素超过了8个以后，会将链表转换为红黑树，
            在这些位置进行查找的时候可以降低时间复杂度为O(logN)
            
    ConcurrentHashMap：
        Segment段：
            ConcurrentHashMap和HashMap思路是差不多的，但是因为它支持并发操作，所以要复杂一些。
            整个ConcurrentHashMap由一个个Segment组成，Segment代表部分或一段的意思，所以很多地方
            都会将其描述为分段锁，
            
        线程安全(Segemtn继承ReenTrantLock加锁)：
            简单理解就是，ConcurrentHashMap是一个Segment数组，Segment通过继承ReenTrantLock来进行加锁，
            所以每次需要加锁的操作锁住的是一个Segment，这样只要保证每个Segment是线程安全的，也就实现了全局的线程安全
        
        并行度(moren 16)：
            concurrencyLevel：并行级别，并发数，Segment数，默认是16，
            也就是说ConcurrentHashMap有16个Segments，所以理论上，这个时候，最多可以同时支持16个线程并发泄
            只要它们的操作分别分布在不同的Segment上，这个值可以在初始化的时候设置为其他值，但是一旦初始化以后，
            它是不可扩容的，在具体到每个Segment内部，其实每个Segment很像之前介绍的HashMap，不过它要保证线程安全。
            所以处理起来要麻烦些
            
    HashTable(线程安全)：
        Hashtable 是遗留类，很多映射的常用功能与 HashMap 类似，不同的是它承自 Dictionary 类，
        并且是线程安全的，任一时间只有一个线程能写 Hashtable，并发性不如 ConcurrentHashMap，
        因为 ConcurrentHashMap 引入了分段锁。Hashtable 不建议在新代码中使用，不需要线程安全
        的场合可以用 HashMap 替换，需要线程安全的场合可以用 ConcurrentHashMap 替换
        
    TreeMap(可排序)：
        TreeMap 实现 SortedMap 接口，能够把它保存的记录根据键排序，默认是按键值的升序排序，
        也可以指定排序的比较器，当用 Iterator 遍历 TreeMap 时，得到的记录是排过序的。
        如果使用排序的映射，建议使用 TreeMap。
        在使用 TreeMap 时，key 必须实现 Comparable 接口或者在构造 TreeMap 传入自定义的
        Comparator，否则会在运行时抛出 java.lang.ClassCastException 类型的异常
        
    LinkedHashMap(记录插入顺序)：
        LinkedHashMap 是 HashMap 的一个子类，保存了记录的插入顺序，在用 Iterator 遍历
        LinkedHashMap 时，先得到的记录肯定是先插入的，也可以在构造时带参数，按照访问次序排序
        
    
    
            
                
    
        
        
    