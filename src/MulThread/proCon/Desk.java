package MulThread.proCon;

// 桌子，用于存放生产的产品
public class Desk {
    // 以下成员变量都是需要多线程共享的，需要用static进行修饰
    // 桌子上产品的数量
    public static int count = 0;

    // 唯一锁对象标识
    public static final  Object lockObj = new Object();
}
