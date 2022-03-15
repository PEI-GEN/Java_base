package Demo_2;

import java.text.SimpleDateFormat;
import java.util.Date;
//模拟倒计时，模拟时钟，模拟网络延时(买火车票例子)
public class Sleep_2 {
    public static void main(String[] args){

        try { //1.模拟倒计时
            tenDown(); //10s倒计时
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //2.打印当前系统时间
        Date startTime = new Date(System.currentTimeMillis()); //获取当前时间

        while (true){ //模拟时钟
            try {
                Thread.sleep(1000); //每隔1s
                System.out.println(new SimpleDateFormat("HH:mm:ss").format(startTime));
                startTime = new Date(System.currentTimeMillis()); //更新当前时间
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void tenDown() throws InterruptedException {
        int num = 10;
        while (true){
            Thread.sleep(1000); //每隔1s
            System.out.println(num--);
            if(num<=0) break;
        }
    }
}
