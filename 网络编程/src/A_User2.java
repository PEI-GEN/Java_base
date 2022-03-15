public class A_User2 {
    public static void main(String[] args) {
        //开启两个线程
        new Thread(new A_Sender(7777,"localhost",9999)).start();
        new Thread(new A_Receiver(8888,"老师")).start();
    }
}