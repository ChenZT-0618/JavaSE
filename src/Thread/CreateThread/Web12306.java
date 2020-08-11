package Thread.CreateThread;

/**
 * @author ChenZT
 */
public class Web12306 implements Runnable {
    private int ticketNum = 99;


    @Override
    public void run() {
        while (ticketNum >= 0) {
            try {
                //模拟延时
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + "-->" + ticketNum);
                ticketNum--;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Web12306 web = new Web12306();
        new Thread(web, "AA").start();
        new Thread(web, "BB").start();
        new Thread(web, "CC").start();
        // 问题一：三个人都抢到了第一张票
        // BB-->99
        // CC-->99
        // AA-->99
        // 问题二：加上了延迟，出现负数
        // AA-->2
        // CC-->0
        // BB-->-1
        // AA-->-1

    }
}
