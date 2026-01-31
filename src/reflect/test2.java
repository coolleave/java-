package reflect;


import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class test2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // 结合配置文件，运行指定类，指定方法
        // 1加载配置文件
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("reflect.properties");
        prop.load(fis);
        String className = (String) prop.get("className");
        String method = (String) prop.get("method");
        // 2利用反射获取方法
        Class<?> c = Class.forName(className);
        // 获取构造方法
        Constructor<?> constructor = c.getConstructor();

        Method m = c.getMethod(method,String.class);

        // 3 创建实例并运行指定方法
        Object ins = constructor.newInstance();
        m.invoke(ins,"张三");
    }

}
