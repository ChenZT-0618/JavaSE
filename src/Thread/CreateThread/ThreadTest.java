package Thread.CreateThread;

/**
 * 创建线程一
 * 创建：继承thread类+重写run
 * 启动：创建子类对象+start()
 *
 * @author ChenZT
 */
public class ThreadTest {
    public static void main(String[] args) {
        Thread1 t1 = new Thread1();
        Thread2 t2 = new Thread2();
        Thread3 t3 = new Thread3();
        Thread4 t4 = new Thread4();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}


class Thread1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println("听歌");
        }
    }
}

class Thread2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println("学习");
        }
    }
}

class Thread3 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println("聊天");
        }
    }
}

class Thread4 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println("吃零食");
        }
    }
}
