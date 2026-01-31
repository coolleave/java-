package MulThread;

// 线程的生命周期与安全问题、同步锁
// 新建
public class MulThread03 {
    public static void main(String[] args) {
        // 用多线程实现卖票问题，三个窗口卖100张票
//        AsyncThread1 t1 = new AsyncThread1();
//        AsyncThread1 t2 = new AsyncThread1();
//        AsyncThread1 t3 = new AsyncThread1();
//        t1.setName("线程1");
//        t2.setName("线程2");
//        t3.setName("线程3");
//        t1.start();
//        t2.start();
//        t3.start();
        // 使用同步方法再实现一遍
//        AsyncThread2 at2 = new AsyncThread2();
//        Thread t1 = new Thread(at2);
//        Thread t2 = new Thread(at2);
//        Thread t3 = new Thread(at2);
//        t1.setName("线程1");
//        t2.setName("线程2");
//        t3.setName("线程3");
//        t1.start();
//        t2.start();
//        t3.start();

        // 使用lock与unlock方法
        AsyncThread3 at2 = new AsyncThread3();
        Thread t1 = new Thread(at2);
        Thread t2 = new Thread(at2);
        Thread t3 = new Thread(at2);
        t1.setName("线程1");
        t2.setName("线程2");
        t3.setName("线程3");
        t1.start();
        t2.start();
        t3.start();
    }
}
