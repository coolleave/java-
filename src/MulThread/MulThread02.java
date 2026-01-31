package MulThread;

public class MulThread02 {
    public static void main(String[] args) {
        // 守护线程，当非守护进程结束后，守护进程也会陆陆续续的结束
        MyThread1 t1 = new MyThread1();
        t1.setName("普通进程");
        MyThread1 tDaemon = new MyThread1();
        MyThread1 tDaemon2 = new MyThread1();
        tDaemon.setName("守护进程");
        tDaemon2.setName("守护进程2");
        tDaemon.start();
        tDaemon2.start();
        t1.start();



    }
}
