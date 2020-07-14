package Network.TCP.Login;

import java.io.*;
import java.net.Socket;

/**
 * @author ChenZT
 */
public class LoginClient {
    public static void main(String[] args) throws IOException {

        System.out.println("-----Client-----");
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("请输入用户名:");
        String uname = console.readLine();
        System.out.print("请输入密码:");
        String upwd = console.readLine();

        Socket client = new Socket("localhost", 8889);
        DataOutputStream output = new DataOutputStream(client.getOutputStream());
        output.writeUTF("name=" + uname + "&" + "password=" + upwd);
        output.flush();

        //显示结果
        DataInputStream input = new DataInputStream(client.getInputStream());
        System.out.println(input.readUTF());

        input.close();
        output.close();


        client.close();

    }
}
