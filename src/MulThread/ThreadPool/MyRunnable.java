package MulThread.ThreadPool;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName()+"线程正在运行");
    }
}
