package Stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author ChenZT
 */
public class StreamTest {
    // 实例化方式一：通过接口
    @Test
    public void test() {
        List<Employee> employees = EmployeeData.getEmployees();
        // 返回一个顺序流
        Stream<Employee> stream = employees.stream();
        // 返回一个并行流
        Stream<Employee> parallelStream = employees.parallelStream();
    }

    // 创建 Stream 方式二：通过数组
    // static <T> Stream<T> stream(T[] array): 返回一个流
    @Test
    public void test2() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        //调用Arrays类的static <T> Stream<T> stream(T[] array): 返回一个流
        IntStream stream = Arrays.stream(arr);
    }

    //创建 Stream方式三：通过Stream的of()
    @Test
    public void test3() {

        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6);

    }

    //创建 Stream方式四：创建无限流
    @Test
    public void test4() {

        // 迭代
        // public static<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f)
        //遍历前10个偶数
        Stream.iterate(0, t -> t + 2).limit(10).forEach(System.out::println);


        // 生成
        // public static<T> Stream<T> generate(Supplier<T> s)
        Stream.generate(Math::random).limit(10).forEach(System.out::println);

    }
}
