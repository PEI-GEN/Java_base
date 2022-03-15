import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

//客户端
public class TcpClient_test02 {
    public static void main(String[] args) throws IOException {
        //要知道服务器地址
        InetAddress sAddress=InetAddress.getByName("192.168.123.111");
        //端口号
        int port=9999;
        //创建socket连接
        Socket socket=new Socket(sAddress,port);
        //发送消息，IO流
        OutputStream stream=socket.getOutputStream();
        stream.write("我是最牛的".getBytes());
        //关闭资源
        stream.close();
        socket.close();
    }
}
