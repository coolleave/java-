package MulThread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// 使用lock方法实现同步
public class AsyncThread3 implements Runnable {
    private  int p = 0;  // 必须使用static进行修饰，这样多个线程之间才会共享票的数量

    // 实例化锁对象，如果是使用的是继承方法，则需要加上static，因为会创建多个实例，锁对象也会创建多个实例，就不唯一了
    private Lock lock = new ReentrantLock();
    @Override
    public void run() {
        // 使用同步锁住
        while (p<100){
            // 锁需要一个锁对象，这个对象必须是唯一的，使用类的字节码即可
            try {
                lock.lock();
                // 模拟耗时操作
                Thread.sleep(10);
                method();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }finally {
            lock.unlock();
            }
        }
    }

    private  void method() {
        if(p<100) {
            p++;
            System.out.println(Thread.currentThread().getName() + "卖票" + p);
        }
    }

}
