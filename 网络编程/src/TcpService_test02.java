import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

//服务端
public class TcpService_test02 {
    public static void main(String[] args) throws IOException {
        //需要有一个地址
        ServerSocket serverSocket=new ServerSocket(9999);
        //等待客户端连接
        Socket socket=serverSocket.accept();
        //读取消息
        InputStream is=socket.getInputStream();
        //管道流
        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        byte[] buffer =new byte[1024];
        int len;
        while ((len=is.read(buffer))!=-1){
            baos.write(buffer,0,len);
        }
        System.out.println(baos.toString());
        baos.close();
        is.close();
        socket.close();
        serverSocket.close();
    }

}
