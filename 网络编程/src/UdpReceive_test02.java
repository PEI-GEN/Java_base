import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpReceive_test02 {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(6666);

        while(true){   //死循环的接收包裹
            //准备接收的包裹
            byte[] container = new byte[1024];
            DatagramPacket packet = new DatagramPacket(container,0,container.length);
            socket.receive(packet);//阻塞式接收包裹

            //断开连接
            byte[] data = packet.getData();
            //System.out.println(data.length);//1024
            String receiveData = new String(data, 0, data.length);//把数据读出来
            //读出数据是什么
            System.out.println(receiveData);

            if (receiveData.equals("bye")){
                break;
            }
        }
        socket.close();
    }
}
