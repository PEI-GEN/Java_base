package Demo_4;

//生产者消费者问题：1.管程法
//生产者，消费者，产品，缓冲区
public class gaunchenfa_01 {
    public static void main(String[] args) {
        SynContainter containter = new SynContainter();

        new Productor(containter).start();
        new Consumer(containter).start();
    }
}
//生产者
class Productor extends Thread{
    SynContainter containter;

    public Productor(SynContainter containter){
        this.containter =containter;
    }
    //生产
    @Override
    public void run() {
        for (int i = 1; i < 100; i++) {
            containter.push(new Chicken(i));
            System.out.println("生产了"+i+"只鸡");
        }
    }
}
//消费者
class Consumer extends Thread{
    SynContainter containter;

    public Consumer(SynContainter containter){
        this.containter =containter;
    }
    //消费
    @Override
    public void run() {
        for (int i = 1; i < 100; i++) {
            System.out.println("消费了"+containter.pop().id+"只鸡");
        }
    }
}

class Chicken{
    int id; //产品编号

    public Chicken(int id){
        this.id=id;
    }
}

//缓冲区
class SynContainter{
    //容器容量
    Chicken[] chickens =new Chicken[10];
    int count = 0;

    //生产者放入产品
    public synchronized void push(Chicken chicken){
        if(count==chickens.length){
            //生产等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        chickens[count]=chicken;
        count++;

        //可以通知消费者消费了
        this.notifyAll();
    }

    //消费者消费产品
    public synchronized Chicken pop(){
        //判断能否消费
        if(count==0){
            //等待生产者生产
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count--;
        Chicken chicken = chickens[count];

        //通知生产者生产
        this.notifyAll();
        return chicken;
    }

}
