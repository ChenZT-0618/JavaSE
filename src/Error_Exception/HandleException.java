package Error_Exception;

import org.junit.Test;

/**
 * @author ChenZT
 */
public class HandleException {

    // try/catch
    @Test
    public void test() {
        String str = "abc";
        try {
            int num = Integer.parseInt(str);
            System.out.println("hello---1");
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.out.println("数据出现异常");
        } catch (NullPointerException e) {
            System.out.println("空指针异常");
        } finally {
            System.out.println("hello---2");
        }
    }
}
