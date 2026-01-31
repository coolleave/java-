package reflect;

import java.io.*;
import java.lang.reflect.Field;
import java.net.URLDecoder;

public class test1 {

    public static void main(String[] args) throws IllegalAccessException, IOException {
        // 要求给定一个对象，保存他的所有字段值和对象名
        Student student = new Student("张三", "001", 80);
        Teacher teacher = new Teacher("李老师", "019", 29, "语文");
        saveObject(student);
        saveObject(teacher);

    }

    public static void saveObject(Object o) throws IllegalAccessException, IOException {
        // 通过反射拿到并打印相关数据
        Class<?> c = o.getClass();
        Field[] fs = c.getDeclaredFields();
        // 创建io流
        BufferedWriter bw = new BufferedWriter(new FileWriter("reflect.txt",true));
        for(Field f:fs){
            f.setAccessible(true); // 统一突破权限
            String name = f.getName();
            Object v = f.get(o);
            System.out.println(name+"="+v);
            bw.write(name+"="+v);
            bw.newLine();
        }
        bw.close();
    }

}
