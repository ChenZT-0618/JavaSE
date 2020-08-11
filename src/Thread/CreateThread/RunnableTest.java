package Thread.CreateThread;

/**
 * 创建线程二
 * 创建：实现runnable接口+重写run
 * 启动：创建子类对象+start()
 *
 * @author ChenZT
 */
public class RunnableTest {
    public static void main(String[] args) {
        new Thread(new Runnable1()).start();
        new Thread(new Runnable2()).start();
    }
}

class Runnable1 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(i + " : 听歌");
        }
    }
}

class Runnable2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(i + " : 学习");
        }
    }
}
