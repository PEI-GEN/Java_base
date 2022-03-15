package Demo_2;

public class Stop_1 implements Runnable{
    //定义标识符
    private boolean flag=true;

    //重写run方法
    @Override
    public void run(){
        if (flag){
            System.out.println("线程开启");
        }
        else{
            System.out.println("线程结束");
        }
    }

    public void stop(){
        this.flag=false;
    }

    public static void main(String[] args) {
        //调用线程
        Stop_1 run=new Stop_1();
        new Thread(run).start();
        //种植线程
        run.stop();//如果想要开启线程，就注释此条语句
    }

}
