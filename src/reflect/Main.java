package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
         /*
        获取class对象的三种方法
        1. Class.forName
        2.类名.class
        3.对象实例.getClass
     */
        Class reflectClass1 = Class.forName("reflect.Reflect");
        Class reflectClass2 = Reflect.class;
        Reflect reflect = new Reflect();
        Class reflectClass3 = reflect.getClass();
        System.out.println(reflectClass1);
        System.out.println(reflectClass2);
        System.out.println(reflectClass3);

        /*
        获取类的构造方法
        1.getConstructors() 获取所有的公共构造方法的数组
        2.getDeclaredConstructors 获取所有的(包括私有)构造方法的数组
        3.getConstructor() 获取无参的、public 修饰的构造方法，如果没有，就会报错，
        也可以在()中添加参数如
        getConstructor(int a)，此方法获取的事参数为int a的公共构造方法
         */
        Constructor[] refConstructors = reflectClass1.getConstructors();
        Constructor constructor = reflectClass1.getConstructor();
        System.out.println("所有的公共的构造方法"+refConstructors);
        System.out.println("单个的构造方法"+constructor);

        /*
        获取修饰符与参数
        1.getModifiers()  获取方法修饰符
        2.getParameters()  获取参数数组
        3.getName()  获取方法名称
        4.constructor.newInstance() 创建实例,tips：如果通过getDeclaredConstructor()
        获取私有的函数，还是不能使用，需要constructor.setAccessible(true);
        临时取消修饰符权限
         */
        int modifiers = constructor.getModifiers();
        Parameter[] parameters = constructor.getParameters();
        String name = constructor.getName();
        System.out.println("函数修饰符"+modifiers);
        System.out.println("函数参数 "+parameters.toString());
        System.out.println("函数名"+name);
        constructor.setAccessible(true);
        Reflect reflectIns = (Reflect) constructor.newInstance();
    // 获取成员变量与获取构造方法类似
    // 除此之外，还可以获取成员变量的数据类型和变量记录的值
    // 获取成员变量.get(对象实例)
    // 修改变量的值，成员变量.set(对象实例，设置的值)

    // 成员方法与构造方法类似
    // 1 获取的公共方法包括父类的方法
    // 2 最重要的invoke方法
    // invoke调用  方法.invoke(调用者（对象实例）,传入参数)
        // invoke 方法的返回值就是原方法的返回值
        Method m = reflectClass1.getMethod("sayHello", String.class);
        Object re = m.invoke(reflectIns,"你好");
    }

}
