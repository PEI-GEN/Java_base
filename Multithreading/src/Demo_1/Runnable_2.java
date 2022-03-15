package Demo_1;

public class Runnable_2 implements Runnable {
    //票数
    private int ticketNums = 10;

    @Override
    public void run() {
        while (true){
            if(ticketNums<=0) break;

            try { //模拟延时
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"拿到了第"+ticketNums--+"张票");
        }
    }


    public static void main(String[] args) {
        Runnable_2 ticket = new Runnable_2();
        new Thread(ticket,"小明").start();
        new Thread(ticket,"老师").start();
        new Thread(ticket,"黄牛党").start();
    }
    //问题：多个线程操作同一个资源的情况下，线程不安全，数据紊乱
}
