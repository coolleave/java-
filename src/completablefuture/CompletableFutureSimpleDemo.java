package completablefuture;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

    /**
     * CompletableFuture 简单示例：点餐（汉堡套餐）
     */
    public class CompletableFutureSimpleDemo {
        // 1. 自定义线程池（生产环境推荐，这里简化为固定线程池）
        private static final ExecutorService FOOD_EXECUTOR = Executors.newFixedThreadPool(3, r -> {
            Thread thread = new Thread(r);
            thread.setName("点餐-线程"); // 给线程命名，方便排查问题
            return thread;
        });

        public static void main(String[] args) throws InterruptedException {
            // 2. 异步做汉堡（有返回值，耗时1秒）
            CompletableFuture<String> burgerFuture = CompletableFuture.supplyAsync(() -> {
                System.out.println(Thread.currentThread().getName() + "：开始做汉堡");
                try {
                    TimeUnit.SECONDS.sleep(1); // 模拟耗时
                } catch (InterruptedException e) {
                    throw new RuntimeException("做汉堡失败：" + e.getMessage());
                }
                return "香辣鸡腿堡"; // 任务结果
            }, FOOD_EXECUTOR);

            // 3. 异步炸薯条（有返回值，耗时1.5秒）
            CompletableFuture<String> chipsFuture = CompletableFuture.supplyAsync(() -> {
                System.out.println(Thread.currentThread().getName() + "：开始炸薯条");
                try {
                    TimeUnit.SECONDS.sleep(1);
                    TimeUnit.MILLISECONDS.sleep(500); // 总共1.5秒
                } catch (InterruptedException e) {
                    throw new RuntimeException("炸薯条失败：" + e.getMessage());
                }
                return "大份薯条"; // 任务结果
            }, FOOD_EXECUTOR);

            // 4. 并行完成汉堡+薯条后，串行冲可乐（用前两个的结果）
            CompletableFuture<String> drinkFuture = burgerFuture
                    .thenCombine(chipsFuture, (burger, chips) -> {
                        // 这个方法会等汉堡和薯条都做好后才执行
                        System.out.println(Thread.currentThread().getName() + "：汉堡(" + burger + ")和薯条(" + chips + ")都做好了，开始冲可乐");
                        try {
                            TimeUnit.MILLISECONDS.sleep(500); // 模拟冲可乐耗时
                        } catch (InterruptedException e) {
                            throw new RuntimeException("冲可乐失败：" + e.getMessage());
                        }
                        return "冰镇可乐"; // 冲可乐的结果
                    });

            // 5. 最后组装套餐（处理最终结果，无返回值）
            drinkFuture
                    .thenApply((drink) -> {
                        // 把汉堡、薯条、可乐组装成套餐
                        return "你的套餐：" + burgerFuture.join() + " + " + chipsFuture.join() + " + " + drink;
                    })
                    .whenComplete((meal, ex) -> {
                        // 最终回调：处理成功/失败结果
                        if (ex != null) {
                            System.out.println("点餐失败：" + ex.getMessage());
                        } else {
                            System.out.println(Thread.currentThread().getName() + "：套餐做好了 → " + meal);
                        }
                    });

            // 6. 等待所有任务完成（主线程别提前退出，实际业务中不用这个，用回调即可）
            TimeUnit.SECONDS.sleep(3);
            FOOD_EXECUTOR.shutdown(); // 关闭线程池
        }
}
