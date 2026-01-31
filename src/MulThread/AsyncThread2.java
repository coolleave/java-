package MulThread;

// 实现Runnable接口实现多线程，使用同步方法处理并发问题
public class AsyncThread2 implements Runnable {
    private  int p = 0;  // 必须使用static进行修饰，这样多个线程之间才会共享票的数量

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
            method();
        }
    }

    private synchronized void method() {
        if(p<100) {
            p++;
            System.out.println(Thread.currentThread().getName() + "卖票" + p);
        }
    }

}
