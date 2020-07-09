

### Java类介绍
面向对象的程序是由对象组成的，每个对象包含对用户公开的特定功能部分和隐藏的实现部分。
程序中的很多对象来自标准库，还有一些是自定义的。究竟是自己构造对象，还是从外界购买对象完全取决于开发项目的预算和时间。
但是，从根本上说，只要对象能够满足要求，就不必关心其功能的具体实现过程。在OOP中，不必关心对象的具体实现，只要能够满足用户的需求即可。

#### 类设计原则：

1. 保证数据私有
2. 一定要对数据初始化
3. 不要在类中使用过多的基本类型
4. 不是所有的域都需要独立的域访问器和域更改器
5. 将职责过多的类进行分解
6. 类名和方法名要 见名知意
7. 优先使用不可变类

#### 类的成员
##### 变量    

* 静态变量 --> 声明在类中，方法等结构外，随着类的加载而加载，存在静态域中  
    * 命名格式： 权限修饰符 **static** 数据类型 变量名 = 变量值；  
    * 调用：类名.变量名 或者 对象.变量名
* 变量 --> 随着对象的创建而加载，存在堆中  
    * 命名格式：权限修饰符 数据类型 变量名 = 变量值;

##### 方法(函数)    

* 普通方法 --> 属于对象，可以通过“对象.方法名”调用，可以直接调用同类中的静态方法、静态属性  
    * 声明格式： 权限修饰符 返回值类型 方法名（形参列表）{方法体}  
    * 调用：对象.方法名 
* 静态方法 --> 属于类的，不能直接调用同类中非静态的方法和非静态的属性  
    * 声明格式： 权限修饰符 **static** 返回值类型 方法名（形参列表）{方法体}
* 抽象方法 --> 存在于抽象类或接口中，**需要被抽象类的子类或接口的实现类重写**   
    * 声明格式：权限修饰符 abstract 返回值类型 方法名（形参列表）  

* 方法中的可变形参(...)：可以使得该方法能够接受任意个参数，使用时当成数组来用。
```java
public int sum(int... nums) {
    int sum = 0;
    if (nums.length == 0) return sum;
    for (int num : nums) {
        sum += num;
    }
    return sum;
}
```
* 方法重写

##### 构造器(Constructor)  

* 特征：
  * 它具有与类相同的名称
  * 它不声明返回值类型。（与声明为void不同）
  * 不能被static、final、synchronized、abstract、native修饰，不能有return语句返回值

* 构造器的作用：创建对象；给对象进行初始化

* 声明格式：权限修饰符 类名（形参列表）{执行的内容}  

```java
class Person{
	//属性
	String name;
	int age;
	//构造器
	public Person(){
		System.out.println("Person().....");
	}
	public Person(String n){
		name = n;
	}
	public Person(String n,int a){
		name = n;
		age = a;
	}	
	//方法
	public void eat(){
		System.out.println("人吃饭");
	}
	public void study(){
		System.out.println("人可以学习");
	}
	
}
```

* **注意**
  * 类一定会有构造器，如果类中没有显式的定义构造器，系统默认提供一个空参的构造器  
  * 如果显式的声明了构造器，系统将不再提供空参构造器，可以自己定义空构造器   
  * 可以定义多个构造器，彼此构成重载
  * 父类的构造器不可被子类继承

##### 代码块

1. 代码块(或初始化块)的作用：初始化类、对象

2. 分类：静态、非静态——是否用static区分

   - 相同点
     - 可以有输出语句。
     - 可以对类的属性、类的声明进行初始化操作。
     - 若有多个静态、非静态的代码块，那么按照从上到下的顺序依次执行。

   * 静态代码块：用static 修饰的代码块
     * 不可以对非静态的属性初始化。即：不可以调用非静态的属性和方法。
     * 静态代码块的执行**要先于**非静态代码块。
     * **静态代码块随着类的加载而加载，且只执行一次。**
   * 非静态代码块：没有static 修饰的代码块
     * 除了调用非静态的结构外，还可以调用静态的变量或方法。
     * **每次创建对象的时候，都会执行一次。且先于构造器执行。**

3. 初始化顺序：静态——非静态——构造器(由父及子)

```java
public class RunOrderTest {
    public static void main(String[] args) { // 由父及子 静态先行
        System.out.println("第一次执行");
        new Son();
        System.out.println("第二次执行");
        new Son();
    }
}

class Father {
    // 静态代码块
    static {
        System.out.println("1：父类静态");
    }

    // 非静态代码块
    {
        System.out.println("2：父类非静态");
    }

    public Father() {
        System.out.println("3：父类构造方法");
    }
}

class Son extends Father {
    // 静态代码块
    static {
        System.out.println("4：子类静态");
    }

    // 非静态代码块
    {
        System.out.println("5：子类非静态");
    }

    public Son() {
        System.out.println("6：子类构造方法");
    }
}

/* 输出结果
第一次执行
1：父类静态
4：子类静态
2：父类非静态
3：父类构造方法
5：子类非静态
6：子类构造方法
第二次执行
2：父类非静态
3：父类构造方法
5：子类非静态
6：子类构造方法
*/
```











##### 内部类

### 面向对象三大特征
#### 封装 

程序设计追求“高内聚，低耦合”。

* 高内聚 ：类的内部数据操作细节自己完成，不允许外部干涉；

* 低耦合 ：仅对外暴露少量的方法用于使用。

隐藏对象内部的复杂性，只对外公开简单的接口。便于外界调用，从而提高系统的可扩展性、可维护性。

##### 封装的体现

1. 将类的属性xxx私有化(private),同时，提供公共的(public)方法来获取(getXxx)和设置(setXxx)此属性的值

2. 通过使用权限修饰符，来实现对象对该类的内部结构的访问权限。

| 修饰符        | 类内部 | 同一个包 | 不同包的子类 | 同一个工程 |
| ------------- | ------ | -------- | ------------ | ---------- |
| private       | Yes    |          |              |            |
| default(缺省) | Yes    | Yes      |              |            |
| protected     | Yes    | Yes      | Yes          |            |
| public        | Yes    | Yes      | Yes          | Yes        |

**注：对于class的权限修饰只可以用public和default修饰。**

#### 继承(inheritance)

##### 简介

为什么要有继承：多个类中存在相同属性和行为时，将这些内容抽取到单独一个类中，那么多个类无需再定义这些属性和行为，只要继承那个类即可。

 利用继承，人们可以基于已存在的类构造一个新类 。继承已存在的类就是复用 （ 继承 ） 这些类的方法和域。在此基础上，还可以添加一些新的方法和域，以满足新的需求。

**"is-a"**关系是继承的一个明显特征： 每个经理都是一名雇员 → 经理类 extends 雇员类

##### 超类、子类：

类继承语法规则：class **Subclass** extends **SuperClass**{...}

关键字extends表明正在构造的新类派生于一个已存在的类。已存在的类称为超类、父类；新类成为子类、派生类。

##### 与继承相关的关键字：extends、super、instanceof、final、abstract

1. extends：继承专用语法

2. super：调用父类对象

   Java中利用super关键字调用父类的方法和属性

   - 访问父类成员方法：super.print();

   - 访问父类属性：super.name;

   - 访问父类构造方法：super()，如果子类没有构造器的话，默认调用父类的无参构造。

3. instanceof：判断

   **instanceof是二元运算符，左边是对象，右边是类；当对象是右面类或子类所创建对象时，返回true；否则，返回false**

4. final：阻止继承

   final关键字可以用来修饰类、类中的域、类中的方法，用来表示该类、域、方法不允许被继承、修改、覆盖。

   - final class：**表明这个类不能被继承**

   - final 方法：**该方法不允许被子类重写，但是可以被子类正常继承使用；**

   - final 变量：**final成员变量表示常量，只能被赋值一次，赋值后值不再改变。**
     - 修饰基本数据变量时，表示该数据类型的值一旦在**初始化后便不能发生变化**
     - 修饰引用类型时，表示初始化后不能指向其他对象，及不能改变地址的值。但是对象的内容可以改变

   - final 类中成员属性：赋值场景：1.定义直接初始化；2.构造方法；3.构造代码块；

5. abstract：继承的极致

   抽象类：可以作为一个“模板”来规定子类必须实现的方法。抽象类不能实例化对象，用于继承。

   * 抽象类里面除了有抽象方法外，还可以有变量、常量、普通方法。

   抽象方法：抽象方法需要加abstract修饰。若有子类继承这个抽象类的时候，子类中必须实现父类中的抽象方法。

##### 继承的作用：

1. 继承的出现减少了代码冗余，提高了代码的复用性。

2. 继承的出现，更有利于功能的扩展。 在子类中，可以使用父类中定义的方法和属性，也可以创建新的数据和
   方法。
3. 继承的出现让类与类之间产生了关系，提供了多态的前提

##### 继承的注意点

1. 单一继承性。（在Java中是不支持多继承的，通俗的说子类只能有一个父类，而父类可以有很多子类。）
2. 支持多层继承。（继承可以一直传下去，子类有父类，父类又有父类...)
3. 如果父类成员使用private修饰,那么子类不能被继承。（private只是对本类有效）
4. 如果一个子类继承了父类的属性和方法还可以有自己特有的属性和方法。（不光有父类的属性（可继承的）和方法（可继承的），也有自己独有的属性和方法。）
5. 当子类和父类的成员变量重名的时候,子类优先。（就近原则）
6. 构造方法不能够被继承（构造方法必须要与类名保持一致）。

##### 继承的设计技巧

1. 将公共操作和域放在超类
2. 不要使用受保护的域
3. 使用继承实现 “ is - a ” 关系
4. 除非所有继承的方法都有意义，否则不要使用继承
5. 在覆盖方法时，不要改变预期的行为
6. 使用多态，而非类型信息
7. 不要过多地使用反射

#### 多态(Polymorphism)

1. 理解多态性：多态是同一个行为具有多个不同表现形式或形态的能力。

   * 可以理解为一个事物的多种形态。例如：动物的叫声，不同的动物有不同的声音……

2. 何为多态性：父类的引用指向子类的对象（或子类的对象赋给父类的引用）

3. 多态的使用：虚拟方法调用

   * 有了对象的多态性以后，我们在编译期，只能调用父类中声明的方法，但在运行期，我们实际执行的是子类重写父类的方法。

   * 总结：编译，看左边；运行，看右边。

4. 多态性的使用前提：   

   * 类的继承关系   

   * 方法的重写
   * 父类引用指向子类对象

5. 对象的多态性，只适用于方法，不适用于属性（编译和运行都看左边）。

6. 多态的应用：抽象类、接口

   抽象类或接口定义了一个方法，是某个目的的实现步骤 ，然后其子类或实现类根据这步骤得到各自的运行结果。

### 接口

##### interface

##### implements




### 其他面向对象关键字 
##### package

* 为了更好的实现	项目中类的管理，提供包的概念
* 使用package声明类或接口所属的包，声明在源文件的首行
* 包，属于标识符，遵循标识符的命名规则、规范(xxxyyyzzz)、“见名知意”
* 每"."一次，就代表一层文件目录。
* 同一个包下，不能命名同名的接口、类。
* 不同的包下，可以命名同名的接口、类。

JDK 中主要的包介绍
1. **java.lang**----包含一些Java语言的核心类，如String、Math、Integer、 System和Thread，提供常用功能
2. **java.net**----包含执行与网络相关的操作的类和接口。
3. **java.io** ----包含能提供多种输入/输出功能的类。
4. **java.util**----包含一些实用工具类，如定义系统特性、接口的集合框架类、使用与日
期日历相关的函数。
5. **java.text**----包含了一些java格式化相关的类
6. **java.sql**----包含了java进行JDBC数据库编程的相关类/接口

##### import

为使用定义在不同包中的Java类，需用import语句来引入指定包层次下所需要的类或全部类(.*)。import语句告诉编译器到哪里去寻找类。

* 在源文件中使用import显式的导入指定包下的类或接口

* 声明在包的声明和类的声明之间。

* 如果需要导入多个类或接口，那么就并列显式多个import语句即可

* 如果在代码中**使用不同包下的同名的类**。那么就需要使用类的**全类名的方式**指明调用的是哪个类。

  * **com.atguigu.exer3**.Account acct1 = new **com.atguigu.exer3**.Account(1000,2000,0.0123);
  * 例如在java.sql和java.util中都有Date类，如果需要同时使用的话要用全类名的方式。

* 如果已经导入java.a包下的类。那么如果需要使用a包的子包下的类的话，仍然需要导入。

* 如果导入的类或接口是java.lang包下的，或者是当前包下的，则可以省略此import语句。

* import static组合的使用：调用指定类或接口下的静态的属性或方法

  ```java
  // 表示可以使用Sysem和Math包中的静态方法或属性
  import static java.lang.System.*;
  import static java.lang.Math.*;
  ```

##### this

当一个对象创建后，Java虚拟机（JVM）就会给这个对象分配一个引用自身的指针，这个指针的名字就是this。

this可以用来修饰、调用：属性、方法、构造器：

* 调用属性、方法，**使用this访问属性和方法时，如果在本类中未找到，会从父类中查找**

```java
class Person{ // 定义Person类
    private String name ;
    private int age ;
    public Person(String name,int age){
        this.name = name ;
        this.age = age ; 
    }
    public void getInfo(){
    	System.out.println("姓名：" + name) ;
   		this.speak();
    }
    public void speak(){
	    System.out.println(“年龄：” + this.age);
    }
}
```
* 调用构造器：

  * 我们在类的构造器中，可以显式的使用"this(形参列表)"方式，调用本类中指定的其他构造器
  * 构造器中不能通过"this(形参列表)"方式调用自己
  * **如果一个类中有n个构造器，则最多有 n - 1构造器中使用了"this(形参列表)"**
  * **规定："this(形参列表)"必须声明在当前构造器的首行**
  * **构造器内部，最多只能声明一个"this(形参列表)"，用来调用其他的构造器**

```java
class Person{ // 定义Person类
	private String name ;
	private int age ;
    public Person(){ // 无参构造器
 	   System.out.println("新对象实例化") ;
    }
    public Person(String name){
       this(); // 调用本类中的无参构造器
       this.name = name ;
    }
    public Person(String name,int age){
       this(name) ; // 调用有一个参数的构造器
       this.age = age;
    }	
    public String getInfo(){
       return "姓名：" + name + "，年龄：" + age ;
    }	
}
```

##### static

static 关键字可以用来修饰：属性、方法、内部类、代码块；

* 修饰属性——静态变量
  *  如果创建了类的多个对象，多个对象共享同一个静态变量。当通过某一个对象修改静态变量时，会导致其他对象调用此静态变量时，是修改过了的。
  * 静态变量随着类的加载而加载。可以通过"类.静态变量"的方式进行调用
  * 静态变量的加载要早于对象的创建。
  * 由于类只会加载一次，则静态变量在内存中也只会存在一份：存在方法区的静态域中。
* 修饰方法——静态方法
  * 随着类的加载而加载，可以通过"类.静态方法"的方式进行调用
  * 静态方法中，只能调用静态的方法或属性，不能使用this关键字、super关键字
* 注
  * 如果属性是可以被多个对象所共享的，不会随着对象的不同而不同的。——设为静态变量
  * 操作静态属性的方法——通常设为静态方法
  * 工具类中的方法，习惯上声明为static的。 比如：Math、Arrays、Collections

### Object类

Object 类是 Java 中所有类的始祖 ， 在 Java 中每个类都是由它扩展而来的。如果没有明确地指出超类，Object 就被认为是这个类的超类 。

#### 常用方法：

##### equals()

Object 类中的 equals 方法用于检测一个对象是否等于另外一个对象。在Object类中，这个方法将判断两个对象是否具有相同的引用。

**特性**：自反、对称、传递、一致

- 重写equals()方法的建议：

- 显式参数命名为 otherObject , 稍后需要将它转换成另一个叫做 other 的变量 。

- 检测 this 与 otherObject 是否引用同一个对象 

  ```java
  if(this = otherObject) return true ;
  ```

- 检测otherObject是否为null,如果为null，返 回 false。 这项检测是很必要的 。

  ```java
  if(otherObject = null) return false ;
  ```

- 比较 this 与 otherObject 是否属于同一个类

  -  如果 equals 的语义在每个子类中有所改变， 就使用 getClass 检测：

    ```java
    if (getClass() ! = otherObject.getCIass()) return false ;
    ```

  - 如果所有的子类都拥有统一的语义，就使用instanceof 检测 ：

    ```java
    if (!(otherObject instanceof ClassName)) return false ;
    ```

- 将 otherObject 转换为相应的类类型变量。

  ```java
  ClassName other = (ClassName)otherObject
  ```

- 现在开始对所有需要比较的域进行比较了。使用 = 比较基本类型域，使用 equals 比较对象域.如果所有的域都匹配，就返回true；否 则 返 回 false。

##### toString()

 它用于返回表示对象值的字符串

##### hashCode()

散列码(hash code)是由对象导出的一个整型值。 散列码是没有规律的 。

Object 类的默认 hashCode 方法是对象的存储地址。

**如果重新定义 equals 方法，就必须重新定义hashCode 方法，以便用户可以将对象插入到散列表中**

##### getClass()

返回一个对象所属的类 

### 包装类(Wrapper)

 针对八种基本数据类型定义相应的引用类型—包装类

#### 包装类的使用

* 基本数据类型包装成包装类的实例 --- 装箱
  * 通过包装类的构造器实现：int i = 500; Integer t = new Integer(i);  
  * 通过字符串参数构造包装类对象：
    * Float f = new Float(“4.56”)    
    * Long l = new Long(“asdf”); //NumberFormatException  
* 获得 包装类对象中包装的基本类型变量 --- 拆箱
  * 调用包装类的.xxxValue()方法：  
    * boolean b = Obj.booleanValue();

- JDK1.5之后，支持自动装箱，自动拆箱。但类型必须匹配。


#### 包装类与String类间的转换

- 通过包装类Integer.toString()将整型转换为字符串；  
- 通过Integer.parseInt()将字符串转换为int类型；  

包装类面试题：

```java
public void test() {
    Integer m = 1;
    Integer n = 1;
    System.out.println(m == n); // ture

    Integer i = 128;
    Integer j = 128;
    System.out.println(i == j); // false
}
public void test1() {
    Object o1 = true ? new Integer(1) : new Double(2.0);
    System.out.println(o1);// 1.0
    // 三元运算符 ? : 类型要一致
}
```

原因：

Integer内部定义了IntegerCache结构，IntegerCache中定义了Integer[]，保存了从-128~127范围的整数。

如果我们使用自动装箱的方式，给Integer赋值的范围在-128~127范围内时，可以直接使用数组中的元素，不用再去new了。目的：提高效率

源码：

```java
public static Integer valueOf(int i) {
    if (i >= IntegerCache.low && i <= IntegerCache.high)
        return IntegerCache.cache[i + (-IntegerCache.low)];
    return new Integer(i);
}

private static class IntegerCache {
    static final int low = -128;
    static final int high;
    static final Integer cache[];

    static {
        // high value may be configured by property
        int h = 127;
        String integerCacheHighPropValue =
            sun.misc.VM.getSavedProperty("java.lang.Integer.IntegerCache.high");
        if (integerCacheHighPropValue != null) {
            try {
                int i = parseInt(integerCacheHighPropValue);
                i = Math.max(i, 127);
                // Maximum array size is Integer.MAX_VALUE
                h = Math.min(i, Integer.MAX_VALUE - (-low) -1);
            } catch( NumberFormatException nfe) {
                // If the property cannot be parsed into an int, ignore it.
            }
        }
        high = h;

        cache = new Integer[(high - low) + 1];
        int j = low;
        for(int k = 0; k < cache.length; k++)
            cache[k] = new Integer(j++);

        // range [-128, 127] must be interned (JLS7 5.1.7)
        assert IntegerCache.high >= 127;
    }

    private IntegerCache() {}
}
```

