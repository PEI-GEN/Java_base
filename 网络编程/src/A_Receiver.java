import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class A_Receiver implements Runnable {
    DatagramSocket socket = null;

    private int port;//自己的端口
    private String msgFrom;//信息从哪儿来

    public A_Receiver(int port, String msgFrom) {
        this.port = port;
        this.msgFrom = msgFrom;

        try {
            socket = new DatagramSocket(port);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {   //死循环的接收包裹
            try {
                //准备接收的包裹
                byte[] container = new byte[1024];
                DatagramPacket packet = new DatagramPacket(container, 0, container.length);
                socket.receive(packet);//阻塞式接收包裹

                //断开连接
                byte[] data = packet.getData();//获得数据
                String receiveData = new String(data, 0, data.length);//把数据读出来，获得长度，获得一些消息
                //读出数据是什么
                System.out.println(msgFrom + "：" + receiveData);//接收,改成了动态的

                if (receiveData.equals("bye")) {
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        socket.close();
    }
}
