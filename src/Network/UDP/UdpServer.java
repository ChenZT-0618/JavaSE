package Network.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author ChenZT
 */
public class UdpServer {
    public static void main(String[] args) throws IOException {
        System.out.println("接收方启动中.....");
        // 1、使用DatagramSocket  指定端口 创建接收端
        //Address already in use: Cannot bind 端口一样
        DatagramSocket server = new DatagramSocket(6666);

        // 2、准备容器 封装成DatagramPacket 包裹 1kb * 60
        byte[] container = new byte[1024 * 60];
        DatagramPacket packet = new DatagramPacket(container, 0, container.length);
        // 3、阻塞式接收包裹receive​(DatagramPacket p)
        server.receive(packet);
        // 4、分析数据
        //    byte[]  getData​()
        //                getLength​()
        byte[] datas = packet.getData();
        System.out.println(new String(datas));
        // 5、释放资源
        server.close();
    }
}
