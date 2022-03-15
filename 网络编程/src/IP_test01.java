import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.SQLOutput;

public class IP_test01 {
    public static void main(String[] args) throws UnknownHostException {
        //使用ip
        InetAddress inetAddress1=InetAddress.getByName("192.168.123.111");
        System.out.println(inetAddress1);//192.168.123.111
        System.out.println("========================");

        //使用域名
        InetAddress inetAddress2=InetAddress.getByName("www.csdn.net");
        System.out.println(inetAddress2);//www.csdn.net/39.106.226.142
        System.out.println("========================");

        InetAddress inetAddress_baidu=InetAddress.getByName("www.baidu.net");
        System.out.println(inetAddress_baidu);//www.baidu.net/118.244.196.96
        System.out.println(inetAddress_baidu.getHostAddress());//118.244.196.96 IP地址
        System.out.println(inetAddress_baidu.getHostName());//www.baidu.net 主机名
        System.out.println(inetAddress_baidu.getAddress());//[B@14ae5a5
        System.out.println("========================");

        //LocalHost获取本机回环ip（192.168.123.111）
        InetAddress inetAddress3=InetAddress.getLocalHost();
        System.out.println(inetAddress3);//peigen/192.168.123.111
        System.out.println("========================");

        //System.out.println(inetAddress2.getAddress());
        //System.out.println(inetAddress2.getCanonicalHostName());
        System.out.println(inetAddress2.getHostAddress());//ip:39.106.226.142
        System.out.println(inetAddress2.getHostName());//域名:www.csdn.net
        System.out.println("========================");
    }
}
