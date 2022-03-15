public class A_User1 {
    public static void main(String[] args) {
        new Thread(new A_Sender(5555,"localhost",8888)).start();
        new Thread(new A_Receiver(9999,"学生")).start();
    }
}