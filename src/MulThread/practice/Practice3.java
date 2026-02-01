package MulThread.practice;

public class Practice3 {
    public static void main(String[] args) {
        /*
            抢红包也用到了多线程。
            假设：100块，分成了3个包，现在有5个人去抢。
            其中，红包是共享数据。
            5个人是5条线程.
            打印结果如下：
            XX抢到了XXX元
            XX抢到了XXX元
            XXX抢到了XXX元
            XXX没抢到
             */
        Thread t1 = new People();
        Thread t2 = new People();
        Thread t3 = new People();
        Thread t4 = new People();
        Thread t5 = new People();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }


}
