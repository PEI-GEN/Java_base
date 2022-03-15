package Demo_3;

//一、买票不安全
public class synchronized_1 {

    public static void main(String[] args) {

        BuyTicket station = new BuyTicket();

        new Thread(station,"小明").start();
        new Thread(station,"张三").start();
        new Thread(station,"黄牛").start();
    }
}

class BuyTicket implements Runnable{
    private int ticketNums =10;
    boolean flag = true;

    @Override
    public void run() {
        while (flag){
            try {
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //同步方法：synchronized，锁的是this
    private synchronized void buy() throws InterruptedException {
        //判断是否有票
        if(ticketNums <= 0){
            this.flag = false;
            return;
        }
//        Thread.sleep(1000);
        //买票
        System.out.println(Thread.currentThread().getName()+"拿到"+ticketNums--);
    }
}

