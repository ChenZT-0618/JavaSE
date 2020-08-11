package ObjectOriented;

/**
 * @author ChenZT
 */
public class RecursionTest {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.print(test4(i) + "\t");
        }
        System.out.println();
        System.out.println(test2(10));
    }

    public static int test1(int n) {
        // 请用Java写出递归求阶乘(n!)的算法
        if (n == 1) return 1;
        else return n * test1(n - 1);
    }

    public static int test2(int n) {
        // 已知有一个数列：f(0) =1,f(1) =4,f(n+2)=2*f(n+1) +f(n),其中n是大于0的整数，求f(10)的值。
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 4;
        } else {
            return 2 * test2(n - 1) + test2(n - 2);
        }
    }

    public static int test3(int n) {
        // 已知一个数列：f(20) =1,f(21) =4,f(n+2) =2*f(n+1)+f(n),其中n是大于0的整数，求f(10)的值。
        if (n == 20) {
            return 1;
        } else if (n == 21) {
            return 4;
        } else {
            return test3(n + 2) - 2 * test3(n + 1);
        }
    }

    public static int test4(int n) {
        // 输入一个数据n，计算斐波那契数列(Fibonacci)的第n个值, 计算斐波那契数列(Fibonacci)的第n个值，并将整个数列打印出来
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return test4(n - 1) + test4(n - 2);
        }
    }


}
