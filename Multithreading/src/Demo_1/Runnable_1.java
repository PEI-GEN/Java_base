package Demo_1;

public class Runnable_1 implements Runnable {
    @Override
    public void run() {
        //run方法线程体
        for (int i = 0; i < 100; i++) {
            System.out.println("run方法线程——>"+i);
        }
    }

    public static void main(String[] args) {
        //创建一个线程对象
        Runnable_1 thread3 = new Runnable_1();

        //开启线程对象来start()开启线程，代理
        new Thread(thread3).start();  //与方法1的区别

        //main主线程
        for (int i = 0; i < 1000; i++) {
            System.out.println("主线程——>"+i);
        }
    }
}
