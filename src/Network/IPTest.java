package Network;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * IP:定位一个节点:计算机、路由、通讯设备等
 * InetAddress: 多个静态方法
 * 1、getLocalHost:本机
 * 2、getByName:根据域名DNS |  IP地址 -->IP
 * <p>
 * 两个成员方法
 * 1、getHostAddress: 返回地址
 * 2、getHostName:返回计算机名
 *
 * @author ChenZT
 */
public class IPTest {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress addr = InetAddress.getLocalHost();
        System.out.println(addr.getHostAddress());
        System.out.println(addr.getHostName());

        // 根据域名得到InetAddress对象
        InetAddress addr2 = InetAddress.getByName("www.baidu.com");
        System.out.println(Arrays.toString(addr2.getAddress()));
        System.out.println(addr2.getHostAddress());
        System.out.println(addr2.getHostName());


        // 根据ip地址得到InetAddress对象
        InetAddress addr3 = InetAddress.getByName("183.232.231.174");
        System.out.println(addr3.getHostAddress());
        System.out.println(addr3.getHostName()); // 这是返回的是IP地址
    }
}
