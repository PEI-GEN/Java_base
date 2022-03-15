//import java.util.concurrent.*;
//
//public class Callable_1 implements Callable<Boolean> {
//    private String url;//网络图片地址
//    private String name;//报错扥文件名
//
//    //有参构造
//    public Callable_1(String url, String name) {
//        this.url = url;
//        this.name = name;
//    }
//
//    下载图片线程的执行体
//    public Boolean call() throws Exception {
//        WebDownloader webDownloader = new WebDownloader();
//        webDownloader.downloader(url, name);
//        System.out.println("下载了文件名为:" + name);
//        return true;
//    }
//
//    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        Callable_1 c = new Callable_1("https://img-home.csdnimg.cn/images/20201124032511.png", "1.png");
//        Callable_1 c1 = new Callable_1("https://img-home.csdnimg.cn/images/20201124032511.png", "2.png");
//        Callable_1 c2 = new Callable_1("https://img-home.csdnimg.cn/images/20201124032511.png", "3.png");
//        //创建执行服务
//        ExecutorService ser = Executors.newFixedThreadPool(3);
//        //提交执行
//        Future<Boolean> r = ser.submit(c);
//        Future<Boolean> r1 = ser.submit(c1);
//        Future<Boolean> r2 = ser.submit(c2);
//        //获取结果
//        boolean res = r.get();
//        boolean res1 = r1.get();
//        boolean res2 = r2.get();
//        System.out.println(res);
//        System.out.println(res1);
//        System.out.println(res2);
//        //关闭服务
//        ser.shutdownNow();
//    }
//
//}
