package proxy;

import java.lang.reflect.Proxy;

public class Agent {
    // 创建一个新代理对象需要三个参数
    // 1.本类加载器
    // 2.接口数组（需要代理哪些方法）
    // 3.处理的内容
    public static Star createProxy(BigStar bigStar){
        ProxyHandler proxyHandler = new ProxyHandler(bigStar);
        return (Star) Proxy.newProxyInstance(
                Agent.class.getClassLoader(),
                new Class[]{Star.class},
                proxyHandler);
    }

}
