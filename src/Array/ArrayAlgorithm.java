package Array;

/**
 * @author ChenZT
 * 简单介绍下有关数组、或者说是用数组来表达的数据结构算法
 * 这些算法可以直接在java.util.Arrays中调用
 */
public class ArrayAlgorithm {
    public static void main(String[] args) {
        int[] array1 = {2, 3, 5, 7, 11, 13, 17, 19};
        // int[] arr2 = new int[array1.length];
        // copyArray(array1, arr2);
        print(array1);
        System.out.println(binarySearch(array1, 4));
    }

    public static void copyArray(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            arr2[i] = arr1[i];
        }
    }

    public static void reverseArray(int[] arr1) {
        for (int i = 0; i < arr1.length / 2; i++) {
            int temp = arr1[i];
            arr1[i] = arr1[(arr1.length - 1) - i];
            arr1[(arr1.length - 1) - i] = temp;
        }
    }

    public static void print(int[] arr) {
        for (int a : arr) {
            System.out.print(a + "\t");
        }
        System.out.println();
    }

    public static int linearSearch(int[] arr, int num) {
        //线性查找，返回下标
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int num) {
        // 二分法查找。要求数组有序
        int low = 0;
        int high = arr.length;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] == num) {
                return mid;
            } else if (arr[mid] < num) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }


}
