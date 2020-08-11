package ObjectOriented.Polymorphism;

import org.junit.Test;

/**
 * @author ChenZT
 * <p>
 * 面向对象特征之三：多态性
 * <p>
 * 1.理解多态性：可以理解为一个事物的多种形态。
 * 2.何为多态性：
 * 对象的多态性：父类的引用指向子类的对象（或子类的对象赋给父类的引用）
 * <p>
 * 3. 多态的使用：虚拟方法调用
 * 有了对象的多态性以后，我们在编译期，只能调用父类中声明的方法，但在运行期，我们实际执行的是子类重写父类的方法。
 * 总结：编译，看左边；运行，看右边。
 * <p>
 * 4.多态性的使用前提：   类的继承关系   方法的重写
 * <p>
 * 5.对象的多态性，只适用于方法，不适用于属性（编译和运行都看左边）。
 */
public class PolymorphismTest {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.eat();

        Man man = new Man();
        man.eat();
        man.earnMoney();
        System.out.println(man.getClass());
        System.out.println(man.equals(p1));

        // 多态性，在继承的时候用
        // 父类引用子类对象
        Person p2 = new Man();
        // 编译看左边，运行看右边：编译的时候看左边的类是否有该方法，运行时运行右边的类的同名方法
        // 先调用子类的重写方法，在调用父类的方法。
        p2.eat();
        p2.walk();
        System.out.println(p2.id);
        // 子类特有的方法不能调用，

        // p2.earnMoney();
        String s = "OK";
        int hashcode = s.hashCode();
        System.out.println(hashcode);

    }

    @Test
    public void test() {
        Integer m = 1;
        Integer n = 1;
        System.out.println(m == n);

        Integer i = 128;
        Integer j = 128;
        System.out.println(i == j);
    }
}
