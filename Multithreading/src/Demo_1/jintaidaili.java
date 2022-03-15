package Demo_1;

/*
静态代理：
1.真实对象与代理对象要实现同一接口
2.代理对象创建代理真实角色
好处：
1.代理对象可以做很多真实对象做不了的事情，比如布置结婚场景
2.真实对象专注做自己的事情，结婚
 */
public class jintaidaili {
    public static void main(String[] args) {
        /*You you = new You();
        you.HappyMarry();*/ //原本方式，下面交给代理

        //线程类代理，实际调用了Runnable接口中的run方法
        new Thread(()-> System.out.println("我爱你")).start();

        WeddingCompany company = new WeddingCompany(new You());
        company.HappyMarry();
    }
}

interface Marry{
    void HappyMarry();
}

class You implements Marry{ //真实角色
    @Override
    public void HappyMarry() {
        System.out.println("我今天要结婚了！");
    }
}

class WeddingCompany implements Marry{ //代理角色

    private Marry target; //目标：真实对象

    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void HappyMarry() { //实现代理
        before();
        this.target.HappyMarry(); //调用真实对象的方法
        after();
    }

    private void after() {
        System.out.println("善后工作！");
    }
    private void before() {
        System.out.println("婚前布置！");
    }

}
