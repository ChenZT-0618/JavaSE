package CollectionClass;

import org.junit.Test;

import java.util.HashSet;
import java.util.TreeSet;

/**
 * @author ChenZT
 */
public class SetTest {
    @Test
    public void test() {
        HashSet<String> set = new HashSet<>();
        set.add("123");

    }

    @Test
    public void test2() {
        TreeSet<Integer> treeSet = new TreeSet<Integer>();

        treeSet.add(34);
        treeSet.add(-34);
        treeSet.add(43);
        treeSet.add(11);
        treeSet.add(8);

        for (Integer i : treeSet) {
            System.out.println(i);
        }
    }
}
