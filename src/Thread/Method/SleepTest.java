package Thread.Method;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * sleep() 模拟倒计时
 *
 * @author ChenZT
 */
public class SleepTest {
    public static void main(String[] args) {
        // 现在时间的十秒后
        Date endTime = new Date(System.currentTimeMillis() + 1000 * 10);
        long end = endTime.getTime();
        while (true) {
            try {
                System.out.println(new SimpleDateFormat("ss").format(endTime));
                Thread.sleep(1000);
                endTime = new Date(endTime.getTime() - 1000); // 减1s
                if (end - 10000 > endTime.getTime()) {
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
