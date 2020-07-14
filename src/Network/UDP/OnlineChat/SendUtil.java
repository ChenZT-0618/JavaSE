package Network.UDP.OnlineChat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * 发送端: 使用面向对象封装
 *
 * @author ChenZT
 */
public class SendUtil implements Runnable {
    private int port;
    private final String hostname;
    private final int toPort;
    DatagramSocket client;
    BufferedReader reader;

    public SendUtil(int port, String hostname, int toPort) {
        this.hostname = hostname;
        this.toPort = toPort;
        try {
            client = new DatagramSocket(port);
            reader = new BufferedReader(new InputStreamReader(System.in));
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
    /*
    DatagramSocket client = new DatagramSocket(8888);
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String data = reader.readLine();
    byte[] datas = data.getBytes();
    DatagramPacket packet = new DatagramPacket(datas, 0, datas.length, new InetSocketAddress("localhost", 6666));
    client.send(packet);
    client.close();
    */


    @Override
    public void run() {
        while (true) {
            String data;
            try {
                data = reader.readLine();
                byte[] datas = data.getBytes();
                DatagramPacket packet = new DatagramPacket(datas, 0, datas.length, new InetSocketAddress(hostname, toPort));
                client.send(packet);
                if (data.equalsIgnoreCase("bye")) {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        client.close();
    }
}
