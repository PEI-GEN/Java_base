public class User1 {
    public static void main(String[] args) {
        new Thread(new UdpSender(6666,"localhost",8888)).start();
        new Thread(new UdpReceive(9999,"学生")).start();
    }
}
