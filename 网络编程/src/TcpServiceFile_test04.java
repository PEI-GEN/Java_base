import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

//服务端
public class TcpServiceFile_test04 {
    public static void main(String[] args) throws IOException {
        //1、创建服务端口
        ServerSocket serverSocket = new ServerSocket(9000);
        //2、监听客户端的连接，没连接过来是不会停的
        Socket socket = serverSocket.accept();//阻塞式连接，会一直等待客户端连接
        //3、获取输入流
        InputStream is = socket.getInputStream();//得到当前文件

        //4、文件输出
        FileOutputStream fos = new FileOutputStream(new File("test04.png"));
        byte[] buffer = new byte[1024];
        int len;
        while ((len=is.read(buffer))!=-1){
            fos.write(buffer,0,len);
        }
        //通知客户端接受完毕了
        OutputStream os = socket.getOutputStream();
        os.write("接收完毕".getBytes());//返回成为bytes数组类型

        //5、关闭资源
        fos.close();
        is.close();
        socket.close();
        serverSocket.close();
    }
}
