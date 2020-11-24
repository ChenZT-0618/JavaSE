package CollectionClass;

import org.junit.Test;

import java.util.HashMap;
import java.util.Properties;

/**
 * @author ChenZT
 */
public class MapTest {
    @Test
    public void test() {
        // 底层数组是Node[]，而非Entry[]
        HashMap<String, String> map = new HashMap<String, String>();
        // 首次调用put()方法时，底层创建长度为16的数组
        map.put("123", "456");
        Properties pros = new Properties();
        // Collections.min()
    }
}
