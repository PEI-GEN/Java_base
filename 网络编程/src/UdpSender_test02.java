import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class UdpSender_test02 {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(8888);

        //准备数据；控制台读取system.in

        //读取系统输入
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true){//死循环发送文件
            String data = reader.readLine();//读取这一行

            //创建数组datas用来接收字节
            byte[] datas = data.getBytes();//转换成字节


            DatagramPacket packet=new DatagramPacket(datas,0,datas.length,new InetSocketAddress("localhost",6666));

            socket.send(packet);
            if (data.equals("bye")){
                break;
            }
        }
        socket.close();
    }
}
