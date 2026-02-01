package MulThread.practice;

// 红包类，需要创建五个线程
// 有三个红包
public class People extends Thread{
    // 红宝数
    public static Integer redCount = 3;
    // 金额数
    public static Integer amount = 100;

    @Override
    public void run() {
        synchronized (People.class){
            if(redCount>=2){
                int re = (int) (Math.random()*amount);
                amount-=re;
                redCount-=1;
                System.out.println(getName()+"获得了红包"+re+"元");
            } else if (redCount==1) {
                int re = amount;
                redCount-=1;
                System.out.println(getName()+"获得了红包"+re+"元");
            }
            else {
                System.out.println(getName()+"没抢到红包");
            }
        }
    }
}
