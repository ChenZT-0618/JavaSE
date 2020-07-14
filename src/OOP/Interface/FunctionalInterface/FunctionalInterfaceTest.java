package OOP.Interface.FunctionalInterface;

import org.junit.Test;

import java.util.function.Consumer;

/**
 * @author ChenZT
 */
public class FunctionalInterfaceTest {
    public static void main(String[] args) {
        System.out.println(addMethod(3, 4, (a, b) -> {
            return a + b;
        }));
    }

    public static int addMethod(int a, int b, test t1) {
        return t1.add(a, b);
    }

    public void test(double money, Consumer<Double> con) {
        con.accept(money);
    }

    @Test
    public void test1() {
        double money = 10000;
        test(money, m -> System.out.println("消费了" + m + "元"));
        test(money, System.out::println);
    }

    @Test
    public void test2() {
        test2<String> t2 = () -> "abc";
        System.out.println(t2.speak());
    }


}

@FunctionalInterface
interface test {
    int add(int a, int b);
}

@FunctionalInterface
interface test2<T> {
    T speak();
}
