package Error_Exception;

import org.junit.Test;

import java.util.Date;

/**
 * 常见异常，列举几个，其他的看文档
 *
 * @author ChenZT
 */
public class ExceptionTest {
    @Test
    public void test() {
        // ArrayIndexOutOfBoundsException
        // int[] arr = new int[3];
        // System.out.println(arr[3]);

        // StringIndexOutOfBoundsException
        // String s = "abc";
        // System.out.println(s.charAt(3));

        // ClassCastException
        Object obj = new Date();
        String s = (String) obj;
    }
}
