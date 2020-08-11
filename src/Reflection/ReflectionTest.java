package Reflection;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author ChenZT
 */

public class ReflectionTest {
    // 反射之前，对于person类的操作
    @Test
    public void test() {
        // 创建Person类的对象
        Person p1 = new Person("Tom", 12);
        // 通过对象，调用内部的属性、方法
        p1.age = 10;
        System.out.println(p1.toString());
        p1.show();
        // Person类外部，不同通过对象调用其内部私有结构
    }


    // 反射的操作
    @Test
    public void test2() throws Exception {
        // Raw use of parameterized class 'Class'
        Class<Person> clazz = Person.class;
        Constructor<Person> cons = clazz.getConstructor(String.class, int.class);
        Person p1 = cons.newInstance("tom", 12);
        System.out.println(p1.toString());
        // 通过反射，调用对象指定的属性
        Field age = clazz.getDeclaredField("age");
        age.set(p1, 10);
        System.out.println(p1.toString());

        // 通过反射，调用对象指定的方法
        // clazz.getMethod(方法名,参数……);
        Method show = clazz.getMethod("show");
        show.invoke(p1);
        System.out.println("***************************");
        // 通过反射，调用对象的私有结构
        Constructor<Person> con1 = clazz.getDeclaredConstructor(String.class);
        con1.setAccessible(true);
        Person p2 = con1.newInstance("Jerry");
        System.out.println(p2.toString());
        // 通过反射，调用对象的私有属性

        Field field = clazz.getDeclaredField("name");
        field.setAccessible(true);
        field.set(p2, "Mike");
        System.out.println(p2.toString());

        // 通过反射，调用对象的私有方法
        Method method = clazz.getDeclaredMethod("showNation", String.class);
        method.setAccessible(true);
        //invoke() 方法的返回值就是method表示的方法的返回值
        String a = (String) method.invoke(p2, "中国");
        System.out.println(a);
    }

    @Test
    public void test3() {
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        System.out.println(classLoader);// AppClassLoader
        ClassLoader classLoader1 = classLoader.getParent();
        System.out.println(classLoader1);// ExtClassLoader
    }

    // 读取配置文件
    @Test
    public void test4() throws IOException {

        Properties properties = new Properties();
        // 方式一
        // FileInputStream fileInputStream = new FileInputStream("D:\\Code\\Java\\JavaSE\\src\\Reflection\\jdbc.properties");
        // properties.load(fileInputStream);

        // 方式二
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        InputStream resource = classLoader.getResourceAsStream("Reflection\\jdbc.properties");
        properties.load(resource);
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        System.out.println("user = " + user + "\npassword = " + password);

    }
}
