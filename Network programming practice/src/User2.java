public class User2 {
    public static void main(String[] args) {
        new Thread(new UdpSender(7777,"localhost",9999)).start();
        new Thread(new UdpReceive(8888,"老师")).start();
    }
}
