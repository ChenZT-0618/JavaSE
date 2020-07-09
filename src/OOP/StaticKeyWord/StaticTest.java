package OOP.StaticKeyWord;

/**
 * @author ChenZT
 */
public class StaticTest {
    String name;
    int age;
    static String NATION = "CHN";

    public static String getNation() {
        return NATION;
    }

    public void eat() {
        System.out.println("中国人吃中餐");
        //调用非静态结构
        this.info();
        System.out.println("name :" + name);
        //调用静态结构
        walk();
        System.out.println("nation : " + NATION);
    }

    public static void show() {
        System.out.println("我是一个中国人！");
        //不能调用非静态的结构
        // eat();
        // name = "Tom";
        //可以调用静态的结构
        System.out.println(NATION);
        walk();
    }

    public void info() {
        System.out.println("name :" + name + ",age : " + age);
    }

    public static void walk() {

    }

}
