package CommonClass;

import org.junit.Test;

/**
 * @author ChenZT
 */
public class StringBufferTest {
    @Test
    public void test() {
        // 默认是16
        StringBuffer sb1 = new StringBuffer(); // char[] value = new char[capacity]
        StringBuffer sb2 = new StringBuffer("abc");// char[] value = new char[str.length() + 16]
        System.out.println(sb2.capacity());

    }

    /**
     * 对比String、StringBuffer、StringBuilder三者的效率：
     */
    @Test
    public void test2() {
        //初始设置
        long startTime = 0L;
        long endTime = 0L;
        String text = "";
        StringBuffer buffer = new StringBuffer("");
        StringBuilder builder = new StringBuilder("");
        //开始对比
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            buffer.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer的执行时间：" + (endTime - startTime));

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            builder.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuilder的执行时间：" + (endTime - startTime));

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            text = text + i;
        }
        endTime = System.currentTimeMillis();
        System.out.println("String的执行时间：" + (endTime - startTime));
    }
}
