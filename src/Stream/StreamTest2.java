package Stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author ChenZT
 */
public class StreamTest2 {
    @Test
    public void test() {
        List<Employee> list = EmployeeData.getEmployees();
        Stream<Employee> stream = list.stream();
        // filter(Predicate p)——接收 Lambda ， 从流中排除某些元素。
        //练习：查询员工表中薪资大于7000的员工信息
        stream.filter(e -> e.getSalary() > 7000).forEach(System.out::println);
        System.out.println();

        //  limit(n)——截断流，使其元素不超过给定数量。
        list.stream().limit(5).forEach(System.out::println);
        System.out.println();
        // skip(n) —— 跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素不足 n 个，则返回一个空流。与 limit(n) 互补
        list.stream().skip(3).forEach(System.out::println);
        System.out.println();
        // distinct()——筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素
        list.add(new Employee(1010, "刘强东", 40, 8000));
        list.add(new Employee(1010, "刘强东", 41, 8000));
        list.add(new Employee(1010, "刘强东", 40, 8000));
        list.add(new Employee(1010, "刘强东", 40, 8000));
        list.add(new Employee(1010, "刘强东", 40, 8000));

        list.stream().distinct().forEach(System.out::println);
    }

    @Test
    public void test2() {
        // map(Function f)——接收一个函数作为参数，将元素转换成其他形式或提取信息，
        // 该函数会被应用到每个元素上，并将其映射成一个新的元素。——add()
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        arrayList.add(6);
        arrayList.stream().map(this::pow).forEach(System.out::println);
        System.out.println();
        // 练习1：获取员工姓名长度大于3的员工的姓名。
        List<Employee> list = EmployeeData.getEmployees();
        Stream<String> namesStream = list.stream().map(Employee::getName);
        namesStream.filter(name -> name.length() > 2).forEach(System.out::println);
        System.out.println();

        List<String> list2 = Arrays.asList("aa", "bb", "cc", "dd");
        list2.stream().map(StreamTest2::fromStringToStream).forEach(s -> {
            s.forEach(System.out::println);
        });
        System.out.println("***************************************************");
        // flatMap(Function f)——接收一个函数作为参数，
        // 将流中的每个值都换成另一个流，然后把所有流连接成一个流。——addAll()
        list2.stream().flatMap(StreamTest2::fromStringToStream).forEach(System.out::println);
    }

    public int pow(int a) {
        return (int) Math.pow(a, 2);
    }

    //将字符串中的多个字符构成的集合转换为对应的Stream的实例
    public static Stream<Character> fromStringToStream(String str) {//aa
        ArrayList<Character> list = new ArrayList<>();
        for (Character c : str.toCharArray()) {
            list.add(c);
        }
        return list.stream();

    }

    // 3-排序
    @Test
    public void test3() {
        // sorted()——自然排序，要实现Comparable接口
        List<Integer> list = Arrays.asList(12, 43, 65, 34, 87, 0, -98, 7);
        list.stream().sorted().forEach(System.out::println);

        // sorted(Comparator com)——定制排序
        List<Employee> employees = EmployeeData.getEmployees();
        employees.stream().sorted((e1, e2) -> {
            int ageValue = Integer.compare(e1.getAge(), e2.getAge());
            if (ageValue != 0) {
                return ageValue;
            } else {
                return Double.compare(e1.getSalary(), e2.getSalary());
            }
        }).forEach(System.out::println);
    }
}
