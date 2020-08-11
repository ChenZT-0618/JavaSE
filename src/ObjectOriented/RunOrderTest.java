package ObjectOriented;

/**
 * @author ChenZT
 * 证明代码块的执行顺序
 */
public class RunOrderTest {
    public static void main(String[] args) { // 由父及子 静态先行
        System.out.println("第一次执行");
        new Son();
        System.out.println("第二次执行");
        new Son();
    }
}

class Father {
    // 静态代码块
    static {
        System.out.println("1：父类静态");
    }

    // 非静态代码块
    {
        System.out.println("2：父类非静态");
    }

    public Father() {
        System.out.println("3：父类构造方法");
    }
}

class Son extends Father {
    // 静态代码块
    static {
        System.out.println("4：子类静态");
    }

    // 非静态代码块
    {
        System.out.println("5：子类非静态");
    }

    public Son() {
        System.out.println("6：子类构造方法");
    }
}

