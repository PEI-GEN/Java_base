import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

//等待客户端的连接
public class UdpReceiver_test01 {
    public static void main(String[] args) throws IOException {
        //开放端口
        DatagramSocket socket = new DatagramSocket(9090);
        //接受数据包
        byte[] buffer = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);//接受包，可以不需要地址的说明

        socket.receive(packet);//阻塞接收

        //解释包裹里面的东西
        System.out.println(packet.getAddress().getHostAddress());//得到发出来的地址的
        System.out.println(new String(packet.getData(),0,packet.getLength()));

        //关闭连接
        socket.close();
    }
}
