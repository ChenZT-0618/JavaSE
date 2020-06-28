package OOP;

/**
 * @author ChenZT
 */
public class VarargsTest {
    public static void main(String[] args) {
        // System.out.println(sum(1, 2, 3, 4, 5));
        char[] arr1 = new char[]{'2', '3'};
        System.out.println(arr1);
    }


    public int sum(int... nums) {
        int sum = 0;
        if (nums.length == 0) return sum;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }

}
