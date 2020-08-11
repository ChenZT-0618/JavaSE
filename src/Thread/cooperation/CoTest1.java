package Thread.cooperation;

/**
 * 协作模型:生产者消费者实现方式一:管程法
 * 借助缓冲区
 *
 * @author ChenZT
 */
public class CoTest1 {
    public static void main(String[] args) {
        Container container = new Container();
        new Productor(container).start();
        new Consumer(container).start();
    }
}


// 生产者
class Productor extends Thread {
    Container container;

    public Productor(Container container) {
        this.container = container;
    }

    // 开始生产
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            // System.out.println("生产-->第" + i + "个馒头");
            container.product(new DataObj(i));
        }
    }
}

// 消费者
class Consumer extends Thread {
    Container container;

    public Consumer(Container container) {
        this.container = container;
    }

    // 开始消费
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            container.consume();
            // System.out.println("消费-->第" + container.consume().id + "个馒头");
        }
    }
}

// 缓冲区
class Container {
    DataObj[] objs = new DataObj[20];
    int count = 0; // 计数器

    // 生产操作
    public synchronized void product(DataObj obj) {
        // 空间满了，无法生产
        if (objs.length == count) {
            try {
                System.out.println("等待空间");
                this.wait(); // 线程阻塞 消费者通知，可解除
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 存在空间，可生产
        objs[count] = obj;
        count++;
        System.out.println("生产 --> 仓库里还剩" + count + "个资源");
        // 存在数据，可以消费
        this.notifyAll();
    }

    // 消费操作
    public synchronized void consume() {
        // 没有东西，无法消费
        if (count == 0) {
            try {
                System.out.println("等待资源");
                this.wait(); // 线程阻塞 生产者通知消费可解除
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count--;
        DataObj obj = objs[count];
        System.out.println("消费 --> 仓库里还剩" + count + "个资源");
        this.notifyAll();
    }
}

// 数据类
class DataObj {
    int id;

    public DataObj(int id) {
        this.id = id;
    }

}


