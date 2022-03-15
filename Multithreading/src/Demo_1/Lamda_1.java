package Demo_1;

public class Lamda_1 {
    public static void main(String[] args) {
        new Thread (()->System.out.println("多线程学习。。。。")).start();
    }
}
