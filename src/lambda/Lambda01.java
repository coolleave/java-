package lambda;

public class Lambda01 {
    public static void main(String[] args) {
        // 方法1：使用常规方法，创建并实例化实现类
        // 实例化实现类
        LambdaInt lambdaIntImpl = new LambdaIntImpl();
        // 调用方法
        lambdaIntImpl.calculate(3,5);


        // 方法2.使用匿名内部类方法
        LambdaInt lambda = new LambdaInt() {
            @Override
            public int calculate(int a, int b) {
                return a+b;
            }

        };

        int result = lambda.calculate(5, 3);
        System.out.println(result);
        // 方法2 使用lambda
        LambdaInt lambdaInt =
           (int a,int b)->{
                return  a+b;
           };

        System.out.println(lambdaInt.calculate(3,5));
    }
}
