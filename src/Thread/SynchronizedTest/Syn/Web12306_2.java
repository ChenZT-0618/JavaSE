package Thread.SynchronizedTest.Syn;

/**
 * @author ChenZT
 */
public class Web12306_2 implements Runnable {
    public static int ticketNum = 20;

    @Override
    public void run() {
        test();
    }

    // 同步方法
    public synchronized void test() {
        while (ticketNum >= 0) {
            try {
                //模拟延时
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + "-->" + ticketNum);
                ticketNum--;
                return;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Web12306_2 web = new Web12306_2();
        while (ticketNum != 0) {
            new Thread(web, "AA").start();
            new Thread(web, "BB").start();
            new Thread(web, "CC").start();
        }
    }
}
