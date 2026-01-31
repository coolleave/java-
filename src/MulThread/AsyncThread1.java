package MulThread;

public class AsyncThread1 extends Thread{
    // 100张票进行售卖
    private static int p = 0;  // 必须使用static进行修饰，这样多个线程之间才会共享票的数量

    @Override
    public void run() {
        // 使用同步锁住
        while (p<100){
            // 锁需要一个锁对象，这个对象必须是唯一的，使用类的字节码即可
            try {
                // 模拟耗时操作
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (AsyncThread1.class){
                if(p<100) {
                    p++;
                    System.out.println(getName() + "卖票" + p);
                }
            }
        }
    }
}
