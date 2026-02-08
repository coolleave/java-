package MulThread.ThreadPool;



import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool1 {
    public static void main(String[] args) throws InterruptedException {

        // 创建线程池
        ExecutorService pool1 = Executors.newFixedThreadPool(3);// 创建线程数为3的线程池
        ExecutorService pool2 = Executors.newCachedThreadPool(); // 创建线程数没有限制的线程池(最大线程数为int最大值 )

        // 提交任务
        // 提交任务
        pool1.submit(new MyRunnable());
        pool1.submit(new MyRunnable());
        pool1.submit(new MyRunnable());
        pool1.submit(new MyRunnable());
        pool1.submit(new MyRunnable());

        // 销毁线程池
        pool1.shutdown();

        // 看看自己电脑的最大并行数
        System.out.println("最大并行数"+Runtime.getRuntime().availableProcessors());



    }
}
