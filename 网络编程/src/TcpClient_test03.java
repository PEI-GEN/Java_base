import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

//客户端
public class TcpClient_test03 {
    public static void main(String[] args) {
        //变量初始化
        Socket socket =null;
        OutputStream os =null;

        try {
            //1.要知道服务器的地址,端口号
            InetAddress serverIP = InetAddress.getByName("192.168.123.111");
            int port= 9999;
            //2.创建socket连接
            socket = new Socket(serverIP,port);
            //3.发送消息 IO流
            os = socket.getOutputStream();

            os.write("你好，网络编程".getBytes());
            os.write("没有一条路是绝对可以给你带来光明前途".getBytes());

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //释放资源
            if (socket!=null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (os!=null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
