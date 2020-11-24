package Thread;

import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author ChenZT
 */
public class ThreadTest {
    @Test
    public void test() {
        FutureTask<Integer> futureTask = new FutureTask<>(new Counter());
        Thread t = new Thread(futureTask);
        t.start();
        try {
            System.out.println(futureTask.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Counter implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 1; i < 11; i++) {
            sum += i;
        }
        return sum;
    }
}
