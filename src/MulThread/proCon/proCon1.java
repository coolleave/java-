package MulThread.proCon;

// 生产者消费者模型
public class proCon1 {
    public static void main(String[] args) {
        // 创建线程，3个消费者，五个生产者
        Producer p1 = new Producer("p1");
        Producer p2 = new Producer("p2");
        Producer p3 = new Producer("p3");


        Consumer c1 = new Consumer("c1");
        Consumer c2 = new Consumer("c2");
        Consumer c3 = new Consumer("c3");
        p1.start();
        c3.start();
        p3.start();
        c1.start();
        c2.start();
        p2.start();

    }
}
