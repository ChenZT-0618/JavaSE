package DesignPattern.Singleton;

/**
 * @author ChenZT
 */
public class SingletonTest1 {
    public static void main(String[] args) {
        Bank b1 = Bank.getInstance();
        Bank b2 = Bank.getInstance();
        System.out.println(b1); // DesignPattern.Singleton.Bank@677327b6
        System.out.println(b2); // DesignPattern.Singleton.Bank@677327b6
        Order o1 = Order.getInstance();
        Order o2 = Order.getInstance();
        System.out.println(o1 == o2);
        for (String str : args) {
            System.out.println(str);
        }
    }
}

//饿汉式
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

// 懒汉式
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
