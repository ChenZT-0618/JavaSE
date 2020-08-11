package Thread.TerminateThread;

/**
 * 终止线程：
 * 1.线程正常执行完毕
 * 2.外部干涉
 *
 * @author ChenZT
 */
public class ThreadTest implements Runnable {
    private boolean flag = true;
    private String name;

    public ThreadTest(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        int i = 0;
        // 关联标识 true：运行，false：结束
        while (flag) {
            System.out.println(name + "-->" + i++);
        }
    }

    // 对外提供方法，改变标识
    public void terminate() {
        this.flag = false;
    }

    public static void main(String[] args) {
        ThreadTest t1 = new ThreadTest("AA");
        new Thread(t1).start();
        for (int i = 0; i < 99; i++) {
            if (i == 88) {
                t1.terminate();// 外部控制线程终止
                System.out.println("线程终止");
            }
            System.out.println("main-->" + i);
        }
    }
}
