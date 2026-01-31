package MulThread;

public class MyThread2 implements Runnable{
    @Override
    public void run() {

        for(int i =0;i<100;i++){
            // 由于MyThread2没有继承Thread类，所以没有getName方法，因此需要先获取当前线程的对象
            Thread t = Thread.currentThread();
            System.out.println( t.getName()+"打印"+i);
            }

    }
}
