package Stream;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 测试Stream的终止操作
 *
 * @author ChenZT
 */
public class StreamTest3 {
    // 匹配与查找
    // boolean allMatch(Predicate p) 检查是否匹配所有元素
    // boolean anyMatch(Predicate p) 检查是否至少匹配一个元素
    // boolean noneMatch(Predicate p) 检查是否没有匹配所有元素
    // Optional findFirst() 返回第一个元素
    // Optional findAny() 返回当前流中的任意元素
    // long count() 返回流中元素总数
    // Optional max(Comparator c) 返回流中最大值
    // Optional min(Comparator c) 返回流中最小值
    // void forEach(Consumer c)
    @Test
    public void test() {
        List<Employee> employees = EmployeeData.getEmployees();
        System.out.println(employees.stream().allMatch(employee -> employee.getAge() > 18
        ));
        Optional<Employee> employeeOptional = employees.stream().findFirst();
        System.out.println(employeeOptional);
        System.out.println(employees.stream().findAny());

        System.out.println((long) employees.size());
        System.out.println(employees.stream().max(Comparator.comparingDouble(Employee::getSalary)));
    }

    // 2-归约
    @Test
    public void test2() {
        // T reduce(T identity, BinaryOperator)——可以将流中元素反复结合起来，得到一个值。返回 T
        // identity：初始值
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer sum = list.stream().reduce(0, Integer::sum);
        System.out.println(sum);
        // reduce(BinaryOperator) ——可以将流中元素反复结合起来，得到一个值。返回 Optional<T>
        // 练习2：计算公司所有员工工资的总和
        List<Employee> employees = EmployeeData.getEmployees();
        Optional<Double> reduce = employees.stream().map(Employee::getSalary).reduce(Double::sum);
        System.out.println(reduce);
    }

    // 3-收集
    @Test
    public void test3() {
        // collect(Collector c)——将流转换为其他形式。
        // 接收一个 Collector接口的实现，用于给Stream中元素做汇总的方法
        List<Employee> employees = EmployeeData.getEmployees();
        List<Employee> lists = employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toList());
        lists.forEach(System.out::println);
        System.out.println();
        Set<Employee> employeeSet = employees.stream().filter(e -> e.getSalary() > 8000).collect(Collectors.toSet());
        employeeSet.forEach(System.out::println);
    }
}
