package reflect;

public class Reflect {
    private String name;
    public Reflect(){
        System.out.println("reflect被创建了");
    }
    public void sayHello(String name){
        System.out.println(name + "你好，我是"+this.name);
    }
}
