package MulThread;

import java.util.concurrent.Callable;

public class MyThread3 implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        // 把线程的返回值返回
        int re = 0;
        for(int i = 0;i<100;i++){
            re+=i;
        }
        return re;
    }
}
