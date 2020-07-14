package Network.TCP;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @author ChenZT
 */
public class Client {
    public static void main(String[] args) throws IOException {

        Socket client = new Socket("localhost", 8888);
        DataOutputStream output = new DataOutputStream(client.getOutputStream());
        String data = "hello";
        output.writeUTF(data);
        output.flush();
        output.close();
        client.close();
    }
}
