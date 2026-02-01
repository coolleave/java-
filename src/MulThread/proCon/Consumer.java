package MulThread.proCon;


// 消费者
public class Consumer extends Thread {

    public String name="";
    public Consumer(String name){
        super(name);
        this.name = name;
    }
    // 消费者的任务
    // 判断是否有空桌子
    // 判断桌子上是否有产品
    // 有产品则消费，没产品则等待
    // 消费完产品则唤醒其他消费者或者生产者
    @Override
    public void run() {

        while(true){
            synchronized (Desk.lockObj){
                    if(Desk.count<=0){
                        try {
                            // 没有产品需要等待
                            Desk.lockObj.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }else{

                        // 消费产品模拟
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        // 消费
                        Desk.count--;
                        System.out.println(getName()+"消费完成，还剩产品数量："+Desk.count);
                        // 唤醒其他等待的线程
                        Desk.lockObj.notifyAll();
                    }

            }
        }
    }
}
