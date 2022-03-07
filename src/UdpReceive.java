import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpReceive implements Runnable{
    //初始化接口、自己的端口、和对方的IP
    DatagramSocket socket=null;
    private int My_port;
    private String My_IP;


    //创建一个Receive对象用来给上面的信息赋值，并将自己的端口传入Socket
    public UdpReceive(int my_port,String my_IP){
        this.My_port=my_port;
        this.My_IP =my_IP;

        try {
            socket = new DatagramSocket(my_port);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //使用多线程对象
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
                System.out.println(My_IP + "：" + receiveData);//接收,改成了动态的

                if (receiveData.equals("bye")) {
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //关闭接口
        socket.close();

        }


    }



