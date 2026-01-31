package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyHandler implements InvocationHandler {
    public BigStar bigStar;
    public ProxyHandler(BigStar bigStar){
        this.bigStar = bigStar;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("sing")){
            System.out.println("准备话筒");
            return  method.invoke(bigStar,args);
        }else if(method.getName().equals("dance")){
            System.out.println("准备场地");
            return method.invoke(bigStar,args);
        }else {
            return method.invoke(bigStar,args);
        }
    }
}
