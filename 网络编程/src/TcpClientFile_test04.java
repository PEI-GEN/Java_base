import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class TcpClientFile_test04 {
    public static void main(String[] args) throws IOException {
        //1、创建一个socket连接
        Socket socket = new Socket(InetAddress.getByName("192.168.123.111"), 9000);
        //2、创建一个输出流
        OutputStream os = socket.getOutputStream();

        //3、得先读文件，再把文件输出去
        FileInputStream fis = new FileInputStream(new File("D:\\python2\\词云\\4.png"));
        //4、写出文件，把文件传输出去
        byte[] buffer = new byte[1024];
        int len;
        while ((len=fis.read(buffer))!=-1){
            os.write(buffer,0,len);
        }

        //通知服务器，我已经结束了
        socket.shutdownOutput();//已经传输完了


        //确定服务器段接受到了文件才能断开连接
        InputStream inputStream = socket.getInputStream();
        //String byte[]类型
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        byte[] buffer2 = new byte[2024];
        int len2;
        while ((len2=inputStream.read(buffer2))!=-1){
            baos.write(buffer2,0,len2);
        }

        System.out.println(baos.toString());

        //5、关闭资源
        baos.close();
        inputStream.close();
        fis.close();
        os.close();
        socket.close();
    }
}
