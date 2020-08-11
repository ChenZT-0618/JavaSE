package Thread.State1;

import java.lang.Thread.State;

/**
 * 查看线程的状态
 *
 * @author ChenZT
 */
public class StateTest {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(".....");
            }
        });

        State state = t.getState();// NEW
        System.out.println(state);

        t.start();
        state = t.getState();   //RUNNABLE
        System.out.println(state);
        while (state != State.TERMINATED) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            state = t.getState();   //TIMED_WAITING
            System.out.println(state);
        }
        state = t.getState();   //TERMINATED
        System.out.println(state);
    }
}
