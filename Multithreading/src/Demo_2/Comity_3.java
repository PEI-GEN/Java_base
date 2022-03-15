package Demo_2;

public class Comity_3 implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"线程开始执行");
        Thread.yield(); //礼让
        System.out.println(Thread.currentThread().getName()+"线程停止执行");
    }

    public static void main(String[] args) {
        Comity_3 myYield = new Comity_3(); //一个对象两个线程
        //礼让不一定成功
        new Thread(myYield, "a").start();
        new Thread(myYield, "b").start();
    }
}

