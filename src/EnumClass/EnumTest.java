package EnumClass;

import org.junit.Test;

/**
 * @author ChenZT
 */
public class EnumTest {
    @Test
    public void test() {
        // 枚举类常用方法
        // values()
        Season[] values = Season.values();
        for (Season value : values) {
            System.out.println(value);
        }
        // valueOf(String str)
        Season spring = Season.valueOf("SPRING");
        System.out.println(spring);
        // toString()
        System.out.println(Season.SPRING.toString());
        System.out.println(Season.SPRING.getSeasonDesc());
    }


}


enum Season {
    SPRING("春天", "春暖花开"),
    SUMMER("夏天", "夏日炎炎"),
    AUTUMN("秋天", "秋高气爽"),
    WINTER("冬天", "冰天雪地");

    //2.声明Season对象的属性:private final修饰
    private final String seasonName;
    private final String seasonDesc;

    //3.私有化类的构造器,并给对象属性赋值

    Season(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }
}

// 枚举类实现接口
/*
enum Season1 implements info {
    SPRING("春天", "春暖花开"),
    SUMMER("夏天", "夏日炎炎");

    //2.声明Season对象的属性:private final修饰
    private final String seasonName;
    private final String seasonDesc;

    //2.私有化类的构造器,并给对象属性赋值

    Season1(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    public void show() {
        System.out.println("大约在冬季");
    }
}
*/
