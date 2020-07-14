package Network.UDP.OnlineChat;

import java.io.IOException;

/**
 * 基本流程: 接收端
 * Address already in use: Cannot bind  同一个协议下端口不允许冲突
 * 1、使用DatagramSocket  指定端口 创建接收端
 * 2、准备容器 封装成DatagramPacket 包裹
 * 3、阻塞式接收包裹receive​(DatagramPacket p)
 * 4、分析数据
 * byte[]  getData​()
 * getLength​()
 * 5、释放资源
 *
 * @author ChenZT
 */
public class TalkServer {
    public static void main(String[] args) throws IOException {
        new Thread(new ReceiveUtil(5678)).start();
        new Thread(new SendUtil(6666, "localhost", 8765)).start();
    }
}
