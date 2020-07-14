package Network.UDP.OnlineChat;

import java.io.IOException;

/**
 * 基本流程: 发送端
 * 1、使用DatagramSocket  指定端口 创建发送端
 * 2、准备数据 一定转成字节数组
 * 3、 封装成DatagramPacket 包裹，需要指定目的地
 * 4、发送包裹send​(DatagramPacket p)
 * 5、释放资源
 *
 * @author ChenZT
 */
public class TalkClient {
    public static void main(String[] args) throws IOException {
        // DatagramSocket client = new DatagramSocket(8888);
        // BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // String data = reader.readLine();
        // byte[] datas = data.getBytes();
        // DatagramPacket packet = new DatagramPacket(datas, 0, datas.length, new InetSocketAddress("localhost", 6666));
        // client.send(packet);
        // client.close();
        new Thread(new SendUtil(7777, "localhost", 5678)).start(); // 发送
        new Thread(new ReceiveUtil(8765)).start(); // 发送

    }
}
