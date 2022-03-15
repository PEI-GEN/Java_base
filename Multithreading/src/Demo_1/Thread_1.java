package Demo_1;

public class Thread_1 extends Thread{
    @Override
    public void run(){
        //run方法
        for(int i=0;i<20;i++){
            System.out.println("run方法线程——>"+i);
        }
    }

    public static void main(String[] args) {
        //创建一个线程对象
        Thread_1 thread = new Thread_1();
        //start()开启线程
        thread.start();

        //mian方法里的主线程
        for(int i=0;i<1000;i++){
            System.out.println("主线程——>"+i);
        }
    }
}
