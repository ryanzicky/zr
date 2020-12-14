### 1. lambda表达式：取代匿名内部类

**FunctionalInterface**：标记注解，表名该接口只有一个需要实现的函数 修饰函数式接口

如果有该注解修饰，该接口不能再新增函数

```
Runnable run = () -> system.out.printlb("hello world");
```

变量作用域

**匿名函数**：只能引用final类型的外部变量（静态内部类可以访问）

普通内部类持有外部类的引用



