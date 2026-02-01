package MulThread.practice;

public class Practice1 {
    public  Integer pickets= 1000;
    public static void main(String[] args) {
        // 一共一千张电影票，两个窗口领取，每次领取时间为3000ms，用多线程模拟买票并打印剩余电影票数量
        Integer pickets=1000;
        ThreadPicket t1 = new ThreadPicket(pickets);
        ThreadPicket t2 = new ThreadPicket(pickets);
        t1.start();
        t2.start();
    }


}

