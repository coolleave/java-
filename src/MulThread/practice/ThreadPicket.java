package MulThread.practice;

public class ThreadPicket extends Thread{
    public  static Integer pickets;

    public  ThreadPicket(Integer pickets){
        this.pickets = pickets;
    }

    @Override
    public void run() {
        while(true) {
            synchronized (ThreadPicket.class){
                if (pickets > 0) {
                    // 模拟购票耗时

                    pickets--;
                    System.out.println(getName() + "卖票，还剩" + pickets);

                }else {
                    break;
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            }

}}