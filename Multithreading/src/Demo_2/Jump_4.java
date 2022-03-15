package Demo_2;

public class Jump_4 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i <= 5; i++) {
            System.out.println("线程vip来了"+i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Jump_4 testJoin = new Jump_4();
        Thread thread = new Thread(testJoin);
        thread.start(); //启动我们的线程

        //主线程
        for (int i = 0; i <= 10; i++) {
            if(i==200){
                thread.join();//插队，等线程执行完
            }
            System.out.println("main"+i);
        }
    }
}
