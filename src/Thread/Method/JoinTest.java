package Thread.Method;

/**
 * join:合并线程，插队线程
 *
 * @author ChenZT
 */
public class JoinTest {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                System.out.println("Thread:" + i);
            }
        });
        t.start();

        for (int i = 0; i < 50; i++) {
            if (i == 10) {
                t.join(); // 插队，main被阻塞了，等t执行完再执行
            }
            System.out.println("Main:" + i);
        }
    }
}
