package OOP.StaticKeyWord;

/**
 * @author ChenZT
 */
public class StaticFieldDemo {
    public static void main(String[] args) {
        StaticTest st = new StaticTest();
        // 实例可以调用静态变量和方法，但是会报问题
        System.out.println(st.getNation());
        System.out.println(st.NATION);
        System.out.println(StaticTest.NATION);
    }
}


