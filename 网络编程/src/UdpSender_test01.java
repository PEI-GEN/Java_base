import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpSender_test01 {
    public static void main(String[] args) throws IOException {
        //1、建立一个socket连接
        DatagramSocket socket = new DatagramSocket();

        //2、创建一个包   就是要发送的数据
        String msg="Im The Boss";
        //发送给谁
        InetAddress localhost = InetAddress.getByName("localhost");
        int port=9090;
        //数据，数据的长度起，数据的长度终，要发送给谁
        DatagramPacket packet = new DatagramPacket(msg.getBytes(), 0, msg.getBytes().length, localhost, port);

        //3、发送一个包
        socket.send(packet);

        //4、关闭流
        socket.close();
    }
}
