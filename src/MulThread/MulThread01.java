package MulThread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/*
    多线程的三种实现方法
 */
public class MulThread01 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 1.继承thread类
//        extendsThread();
        // 2.实现runnable接口，实现run方法
//        implRunnable();
        // 3.实现callable接口
//        implCallable();
        // 获取默认名字优先级
        Thread t1 = new MyThread1();
        System.out.println("默认");
        System.out.println(t1.getName());
        System.out.println(t1.getPriority());
        // 获取主线程名字与优先级
        Thread main = Thread.currentThread();
        System.out.println("主线程");
        System.out.println(main.getName());
        System.out.println(main.getPriority());
    }
    // 1.继承thread类
    public static void extendsThread(){
        Thread t1 = new MyThread1();
        Thread t2 = new MyThread1();
        t1.setName("继承Thread线程1");
        t2.setName("继承Thread线程2");
        t1.start();
        t2.start();
    }
    // 2.实现runnable接口，实现run方法
    public static void implRunnable(){

        MyThread2 myThread2 = new MyThread2();
        // Thread的构造方法为空则则运行Thread的run方法，如果不为空则运行target的run方法，这样做解耦开，方便管理
        Thread t1 = new Thread(myThread2);
        Thread t2 = new Thread(myThread2);
        t1.setName("实现接口线程1");
        t2.setName("实现接口线程2");
        t1.start();
        t2.start();

    }
    // 3.实现callable接口
    public static void implCallable() throws ExecutionException, InterruptedException {
        // 如果想用这个线程内的变量，可以实现Callable这个接口
        MyThread3 myThread3 = new MyThread3();
        // Callable没有继承Runnable接口，因此不能作为target传入线程的构造方法
        // 创建一个容器FutureTask来存储Callable和运行结果
        FutureTask<Integer> ft = new FutureTask<>(myThread3);
        Thread t1 = new Thread(ft);
        t1.start();
        Integer re = ft.get();
        System.out.println(re);
    }
}
