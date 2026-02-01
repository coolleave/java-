package MulThread.proCon;

//  生产者的任务
// 判断桌子是否被占用
// 判断桌子上是否有产品
// 有产品则等待，没产品则制作
// 制作完成后唤醒消费者
public class Producer extends Thread{


    private  String name = "";

    public Producer(String name) {
        super(name);
        this.name = name;
    }

    @Override
    public void run() {
        while (true){
            synchronized (Desk.lockObj){

                if (Desk.count>1000){
                    try {
                        // 如果有产品就等待
                        Desk.lockObj.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }else{
                    try {
                        // 制作产品模拟
                        Thread.sleep(55);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    Desk.count++;
                    System.out.println(getName()+"制作完毕，当前产品数量"+Desk.count);
                    // 唤醒线程
                    Desk.lockObj.notifyAll();

                }
            }
        }
    }
}
