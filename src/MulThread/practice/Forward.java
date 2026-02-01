package MulThread.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Forward extends Thread{
    public static List<Integer> list = new ArrayList<>(Arrays.asList(
            10, 5, 20, 50, 100, 200,
            500, 800, 2, 80, 300, 700
    ));

    @Override
    public void run() {
        while (true){
            synchronized (Forward.class){
                if(!list.isEmpty()){
                    // 模拟随机抽奖，取到id
                    int index = (int) (Math.random()*10 % list.size());
                    int amount = list.get(index);
                    list.remove(index);
                    System.out.println(getName()+"抽到了"+amount);
                }else {
                    break;
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
