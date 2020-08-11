package Reflection.getStructure;

import Reflection.getStructure.entity.Person;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * 获取当前运行时类的属性结构
 *
 * @author ChenZT
 */
public class FieldTest {
    @Test
    public void test() {
        Class clazz = Person.class;
        // 获取属性结构 getFields()
        // 获取当前运行时类及其父类中声明为public访问权限的属性
        Field[] fields = clazz.getFields();
        for (Field f : fields) {
            // public int Reflection.getStructure.entity.Person.id
            // public double Reflection.getStructure.entity.Creature.weight
            System.out.println(f);
        }

        System.out.println("************************************************");

        //getDeclaredFields():获取当前运行时类中声明的所有(包括私有的)属性。（不包含父类中声明的属性）
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field f : declaredFields) {
            // System.out.println(f);
            // 权限修饰符 + 数据类型 + 变量名
            // getModifiers()返回的是整数，需要用Modifier的静态方法来转换
            System.out.println(Modifier.toString(f.getModifiers()) + "\t" + f.getType().getName() + "\t" + f.getName());
            // System.out.println(f.getType());
            // System.out.println(f.getName());

        }

        System.out.println("************************************************");


    }
}
