import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;


public class UdpSender implements Runnable{//这里是多线程的使用
    //创建接口
    DatagramSocket socket=null;
    //创建阅读器
    BufferedReader reader=null;

    //创建自己的端口，对方的端口和对方的IP
    private int FromPort;
    private String ToIP;
    private int ToPort;


    //创建一个Sender对象，告诉自己是谁，需要往哪儿发，建立连接了
    public UdpSender(int fromPort,String ip,int toPort){//构造函数
        this.FromPort=fromPort;
        this.ToIP=ip;
        this.ToPort=toPort;
        try {
            socket= new DatagramSocket(fromPort);
            reader = new BufferedReader(new InputStreamReader(System.in));
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }



    @Override
    public void run() {//重载多线程
        //利用while循环一直接收和发送消息
        while(true){
            try {
                //读取阅读器的内容并且转换为字节
                String data=reader.readLine();//读取这一行
                byte[] datas=data.getBytes();
                //建立一个包来传输自己的信息
                DatagramPacket packet=new DatagramPacket(datas,0,datas.length,new InetSocketAddress(this.ToIP,this.ToPort));
                //发送数据
                socket.send(packet);
                //如果发送了“bye”，则终止程序
                if(data.equals("bye")){
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            socket.close();;
        }
    }
}
