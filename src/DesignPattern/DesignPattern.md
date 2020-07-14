## 单例(Singleton)设计模式

所谓类的单例设计模式，就是采取一定的方法保证在整个的软件系统中，**对某个类只能存在一个对象实例**，并且该类只提供一个取得其对象实例的方法。

先将构造器设置为private，不能用new操作来生成对象。然后用静态变量来生成唯一的一个对象，同时用静态方法返回这一对象。使用静态变量使得类在加载时就已经生成了一个对象。并且只执行一次，确保该类只存在一个对象实例。

### 优点

由于单例模式只生成一个实例，减少了系统性能开销，当一个对象的产生需要比较多的资源时，如读取配置、产生其他依赖对象时，则可以通过在应用启动时直接产生一个单例对象，然后永久驻留内存的方式来解决。

### 饿汉式

- 坏处：对象加载时间过长。
- 好处：饿汉式是线程安全的

```java
class Bank {
    //1.私有化类的构造器
    private Bank() {
    }

    //2.内部创建类的对象,此对象也必须声明为静态的
    private static final Bank instance = new Bank();

    //3.提供公共的静态的方法，返回类的对象
    public static Bank getInstance() {
        return instance;
    }
}
```

### 懒汉式

- 好处：延迟对象的创建。
- 坏处：线程不安全。--->到多线程内容时，再修改

```java
class Order {
    //1.私有化类的构造器
    private Order() {
    }

    //2.声明当前类对象，没有初始化
    //4.此对象也必须声明为static的
    private static Order instance = null;

    //3.声明public、static的返回当前类对象的方法
    public static Order getInstance() {
        if (instance == null) {
            instance = new Order();
        }
        return instance;
    }
}
```

### 应用场景

- **网站的计数器**，一般也是单例模式实现，否则难以同步。
- 应用程序的**日志应用**，一般都使用单例模式实现，这一般是由于共享的日志文件一直处于打开状态，因为只能有一个实例去操作，否则内容不好追加。
- **数据库连接池**的设计一般也是采用单例模式，因为数据库连接是一种数据库资源。
- 项目中，**读取配置文件的类**，一般也只有一个对象。没有必要每次使用配置文件数据，都生成一个对象去读取。
- Windows的Task Manager (任务管理器)就是很典型的单例模式
- Windows的Recycle Bin (回收站)也是典型的单例应用。在整个系统运行过程中，回收站一直维护着仅有的一个实例。



## 模板方法(TemplateMethod)

抽象类体现的就是一种模板模式的设计，抽象类作为多个子类的通用模板，子类在抽象类的基础上进行扩展、改造，但子类总体上会保留抽象类的行为方式。

* 当功能内部一部分实现是确定的，一部分实现是不确定的。这时可以把不确定的部分暴露出去，让子类去实现。
* 换句话说，在软件开发中实现一个算法时，整体步骤很固定、通用，这些步骤已经在父类中写好了。但是某些部分易变，易变部分可以抽象出来，供不同子类实现。这就是一种模板模式。

```java
abstract class AbstractClass {
    public abstract void PrimitiveOperation1();
    public abstract void PrimitiveOperation2();

    public void TemplateMethod() { // 主要方法、整体步骤
        // 特定子类相关步骤
        PrimitiveOperation1(); 
        PrimitiveOperation2();
        System.out.println("其他重复代码");
    }
}
```

### 应用场景

* 数据库访问的封装
* Junit单元测试
* JavaWeb的Servlet中关于doGet/doPost方法调用
* Hibernate中模板程序
* Spring中JDBCTemlate、HibernateTemplate等















































