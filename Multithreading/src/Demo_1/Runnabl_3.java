package Demo_1;

public class Runnabl_3 implements Runnable {
    //胜利者
    private static String winner;

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {

            boolean flag=gameOver(i);//判断比赛是否结束
            if(flag) break;

            System.out.println(Thread.currentThread().getName()+"-->跑了"+i+"步");

            //模拟兔子休息
            if(Thread.currentThread().getName().equals("兔子")&& i%10==0){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //判断是否完成比赛
    private boolean gameOver(int steps){
        if(winner!=null){
            return true;
        }{
            if (steps==100){
                winner=Thread.currentThread().getName();
                System.out.println("winner is"+winner);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Runnabl_3 race = new Runnabl_3();
        new Thread(race,"兔子").start();
        new Thread(race,"乌龟").start();
    }
}
