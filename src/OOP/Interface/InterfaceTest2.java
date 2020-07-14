package OOP.Interface;

/**
 * @author ChenZT
 * 接口的使用体现 多态性
 */
public class InterfaceTest2 {
    public static void main(String[] args) {
        InterfaceTest2 it = new InterfaceTest2();
        Dog dog = new Dog();
        Cat cat = new Cat();
        it.fun1(dog);
        it.fun1(cat);
        dog.method1();
        
    }

    public void fun1(Animal animal) {
        animal.eat();
    }
}

interface Animal {
    void eat();

    // 默认方法
    default void method1() {
        System.out.println("默认方法");
    }

    // 静态方法
    static void method2() {
        System.out.println("静态方法");
    }
}

class Dog implements Animal {
    @Override
    public void eat() {
        System.out.println("狗吃肉");
    }
}

class Cat implements Animal {
    @Override
    public void eat() {
        System.out.println("猫吃鱼");
    }
}
