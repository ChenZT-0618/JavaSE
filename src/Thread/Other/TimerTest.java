package Thread.Other;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author ChenZT
 */
public class TimerTest {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new test(), 1000); // 1秒后启动
    }
}

class test extends TimerTask {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("helloworld");
        }
    }
}

