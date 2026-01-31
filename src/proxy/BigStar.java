package proxy;

public class BigStar implements Star {
    @Override
    public String sing() {
        System.out.println("唱歌");
        return "唱歌完毕";
    }

    @Override
    public String dance() {
        System.out.println("跳舞");
        return "跳舞完毕";}
}
