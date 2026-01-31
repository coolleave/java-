package proxy;


public class Main {
    public static void main(String[] args) {
        // 创建明星
        BigStar bigStar = new BigStar();
        // 创建代理
        Star proxy = Agent.createProxy(bigStar);
        // 使用代理唱歌
        String resing = proxy.sing();
        System.out.println(resing);
        String redance = proxy.dance();
        System.out.println(redance);

    }
}