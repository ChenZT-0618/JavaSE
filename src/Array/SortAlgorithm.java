package Array;

/**
 * @author ChenZT
 */
public class SortAlgorithm {
    public static void main(String[] args) {
        int[] array1 = {43, 32, 76, -98, 0, 64, 33, -21, 32, 99};
        print(array1);
        QuickSort(array1, 0, array1.length - 1);
        print(array1);
    }

    public static void print(int[] arr) {
        for (int a : arr) {
            System.out.print(a + "\t");
        }
        System.out.println();
    }

    public static void BubbleSort(int[] arr) {
        /*
        1. 比较相邻的元素。如果第一个比第二个大（升序），就交换他们两个。
        2. 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。
        3. 针对所有的元素重复以上的步骤，除了最后一个。
        4. 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较为止。
        */
        for (int i = arr.length - 1; i > 0; i--) {
            int temp;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void QuickSort(int[] arr, int start, int end) {
        /*
        1. 从数列中挑出一个元素，称为"基准"（pivot），
        2. 重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。
        在这个分区结束之后，该基准就处于数列的中间位置。这个称为分区（partition）操作。
        3. 递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。
        4. 递归的最底部情形，是数列的大小是零或一，也就是永远都已经被排序好了。
        虽然一直递归下去，但是这个算法总会结束，因为在每次的迭代（iteration）中，它至少会把一个元素摆到它最后的位置去。
        */
        int low = start;
        int high = end;
        if (low >= high) return;
        int pivot = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= pivot) high--;
            arr[low] = arr[high];
            while (low < high && arr[low] <= pivot) low++;
            arr[high] = arr[low];
        }
        arr[low] = pivot;
        QuickSort(arr, start, low - 1);
        QuickSort(arr, low + 1, end);
    }

}
