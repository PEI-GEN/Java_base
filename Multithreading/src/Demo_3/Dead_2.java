package Demo_3;

//死锁：多线程互相抱着对方需要的资源，然后形成僵持
public class Dead_2 {
    public static void main(String[] args) {
        Makeup g1 = new Makeup(0, "灰姑娘");
        Makeup g2 = new Makeup(1, "白雪公主");

        g1.start();
        g2.start();
    }
}

//口红
class Lipstick{
}

//镜子
class Mirror{
}

class Makeup extends Thread{
    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();

    int choice;//几种选择
    String girlName; //使用者

    public Makeup(int choice, String girlName) {
        this.choice = choice;
        this.girlName = girlName;
    }

    @Override
    public void run() {
        //化妆
        try {
            makeup();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //互相持有对方的锁，就是需要拿到对方的资源
    private void makeup() throws InterruptedException {
        //选择1
        if(choice==0){
            synchronized (lipstick){ //获得口红的锁
                System.out.println(this.girlName+"获得口红的锁");
                Thread.sleep(1000);
                }
                synchronized (mirror){ //一分钟后想拿镜子
                    System.out.println(this.girlName+"获得镜子的锁");
            }
        }   //选择2
        else {
            synchronized (mirror){ //获得镜子的锁
                System.out.println(this.girlName+"获得镜子的锁");
                Thread.sleep(2000);

                }
                synchronized (lipstick){ //一分钟后想拿口红
                    System.out.println(this.girlName+"获得口红的锁");
            }

        }
    }
}
