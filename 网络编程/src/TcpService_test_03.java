import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

//服务端
public class TcpService_test_03 {
    public static void main(String[] args) {
        //提升作用域
        ServerSocket serverSocket =null;
        Socket socket =null;
        InputStream is =null;
        ByteArrayOutputStream baos =null;

        try {
            //1、得有一个地址
            serverSocket = new ServerSocket(9999);//端口号
            while (true){  //用一个循环，就可以一直让服务器处于开着的状态
                //2.等待客户端连过来
                socket = serverSocket.accept();
                //3.读取客户端的消息
                is = socket.getInputStream();
                //管道流  用来接受客户端发来的消息
                baos = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int len;
                while ((len=is.read(buffer))!=-1){
                    baos.write(buffer,0,len);
                }
                System.out.println(baos.toString());
            }


  /*

              byte[] buffer = new byte[1024];//new个缓冲区
              int len;//判断所读区域的大小
              while ((len=is.read(buffer))!=-1){ //假设不等于负一就说明里面还有值
                //写出去
                    String msg = new String(buffer, 0, len);
                    System.out.println(msg);
            }
             */

        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            //关闭资源，先开后关

            if (baos!=null){
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (socket!=null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (serverSocket!=null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
