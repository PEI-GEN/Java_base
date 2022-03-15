package Demo_2;

public class State_5 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("///");
        });

        //观察状态
        Thread.State state = thread.getState();
        System.out.println(state); //NEW

        thread.start(); //启动 Run()方法
        state = thread.getState();
        System.out.println(state); //RUNNABLE

        //只要线程不终止
        while (state != Thread.State.TERMINATED){
            Thread.sleep(1000);
            state = thread.getState(); //每隔1s,打印一次线程状态
            System.out.println(state);
        }

        //thread.start();死亡之后的线程不能再次启动，报错
    }
}

