package Network.TCP.Login;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author ChenZT
 */
public class LoginServer {
    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(8889);
        Socket client = server.accept();
        DataInputStream input = new DataInputStream(client.getInputStream());
        String[] dataArray = input.readUTF().split("&");
        String name = "";
        String password = "";

        for (String info : dataArray) {
            String[] userInfo = info.split("=");
            if (userInfo[0].equals("name")) {
                System.out.println("你的用户名为:" + userInfo[1]);
                name = userInfo[1];
            } else if (userInfo[0].equals("password")) {
                System.out.println("你的密码为:" + userInfo[1]);
                password = userInfo[1];
            }
        }
        // 返回结果
        DataOutputStream output = new DataOutputStream(client.getOutputStream());
        if ("chenzt".equals(name) && "123456".equals(password)) {
            // System.out.println("登录成功");
            output.writeUTF("登录成功");
        } else {
            // System.out.println("用户名或密码错误");
            output.writeUTF("用户名或密码错误");
        }
        output.flush();
        output.close();
        client.close();
        server.close();
    }
}
