package CollectionClass;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author ChenZT
 */
public class ListTest {
    /**
     * ArrayList 源码分析
     */
    @Test
    public void test() {
        ArrayList<String> aList = new ArrayList();
        aList.add("123");
    }

    @Test
    public void test2() {
        LinkedList<String> list = new LinkedList();
        list.add("123");
    }
}
