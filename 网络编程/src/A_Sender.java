import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class A_Sender implements Runnable{
    DatagramSocket socket = null;//建立连接应该在很上面的位置
    BufferedReader reader = null;

    //写对方的端口号
    private int fromPort;
    private String toIP;
    private int toPort;

    public A_Sender(int fromPort, String toIP, int toPort) {
        //告诉自己是谁，需要往哪儿发，建立连接了
        this.fromPort = fromPort;
        this.toIP = toIP;
        this.toPort = toPort;


        try{
            socket = new DatagramSocket(fromPort);
            reader = new BufferedReader(new InputStreamReader(System.in));//之前提升了作用域之后没有去删除，是导致了bug的
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @Override
    public void run(){
        //准备数据；控制台读取system.in
        while (true){ //只管一直发送消息
            try{
                String data = reader.readLine();//读取这一行
                byte[] datas = data.getBytes();//转换成字节

                DatagramPacket packet=new DatagramPacket(datas,0, datas.length,new InetSocketAddress(this.toIP,this.toPort));

                socket.send(packet);
                if (data.equals("bye")){
                    break;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        socket.close();
    }
}
