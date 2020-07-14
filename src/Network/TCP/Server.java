package Network.TCP;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author ChenZT
 */
public class Server {
    public static void main(String[] args) throws IOException {
        // 1、指定端口 使用ServerSocket创建服务器 这个要先有
        ServerSocket server = new ServerSocket(8888);
        // 2、阻塞式等待连接 accept
        Socket client = server.accept();
        System.out.println("一个客户端建立了连接");
        // 3、操作: 输入输出流操作
        DataInputStream input = new DataInputStream(client.getInputStream());
        String data = input.readUTF();
        System.out.println(data);
        input.close();
        client.close();
    }
}
