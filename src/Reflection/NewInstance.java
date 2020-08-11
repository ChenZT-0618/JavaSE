package Reflection;

import org.junit.Test;

import java.util.Random;

/**
 * 通过反射创建对应的运行时 类的对象
 *
 * @author ChenZT
 */
public class NewInstance {
    @Test
    public void test() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> p1 = Class.forName("Reflection.Person");
        // newInstance():调用此方法，创建对应的运行时类的对象。内部调用了运行时类的空参的构造器。
        // 要想此方法正常的创建运行时类的对象，要求：
        // 1.运行时类必须提供空参的构造器
        // 2.空参的构造器的访问权限得够。通常，设置为public。
        p1.newInstance();// 调用的是空参构造器
    }

    @Test
    public void test2() {
        int num = new Random().nextInt(3);
        String classPath = "";
        switch (num) {
            case 0:
                classPath = "java.util.Date";
                break;
            case 1:
                classPath = "java.lang.Object";
                break;
            case 2:
                classPath = "Reflection.Person";
                break;
        }
        try {
            Object obj = getInstance(classPath);
            System.out.println(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Object getInstance(String classpath) throws Exception {
        Class<?> clazz = Class.forName(classpath);
        return clazz.newInstance();
    }
}
