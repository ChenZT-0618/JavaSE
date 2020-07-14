package Network.UDP.OnlineChat;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @author ChenZT
 */
public class ReceiveUtil implements Runnable {
    /*     * 基本流程: 接收端
     * Address already in use: Cannot bind  同一个协议下端口不允许冲突
     * 1、使用DatagramSocket  指定端口 创建接收端
     * 2、准备容器 封装成DatagramPacket 包裹
     * 3、阻塞式接收包裹receive​(DatagramPacket p)
     * 4、分析数据
     * byte[]  getData​()
     * getLength​()
     * 5、释放资源
     **/
    private int port;
    DatagramSocket server;

    public ReceiveUtil(int port) {
        try {
            server = new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            byte[] container = new byte[60 * 1024];
            DatagramPacket packet = new DatagramPacket(container, 0, container.length);
            try {
                server.receive(packet);
                byte[] dates = packet.getData();
                int len = packet.getLength();
                String data = new String(dates, 0, len);
                System.out.println(data);
                if ("bye".equalsIgnoreCase(data)) {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        server.close();
    }
}
