package Array;

import java.util.Scanner;

/**
 * @author ChenZT
 */
public class ArrayTest {
    public static void main(String[] args) {
        Test2();
    }

    public static void Test() {
        int[] arr = {8, 2, 1, 0, 3};
        int[] index = {2, 0, 3, 2, 4, 0, 1, 3, 2, 3, 3};
        String tel = "";
        for (int a : index) {
            tel += arr[a];
        }
        System.out.println(tel);
    }

    public static void Test2() {
        //使用二维数组打印一个 n 行杨辉三角
        Scanner scanner = new Scanner(System.in);
        int[][] YangHui = new int[scanner.nextInt()][];
        for (int i = 0; i < YangHui.length; i++) {
            YangHui[i] = new int[i + 1];
            YangHui[i][i] = YangHui[i][0] = 1;
            for (int j = 1; j < i; j++) {
                YangHui[i][j] = YangHui[i - 1][j - 1] + YangHui[i - 1][j];
            }
        }
        for (int i = 0; i < YangHui.length; i++) {
            for (int j = 0; j < YangHui[i].length; j++) {
                System.out.print(YangHui[i][j] + "\t");
            }
            System.out.println();
        }

    }
}
