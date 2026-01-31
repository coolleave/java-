package reflect;

public class Student {
    private  String name;

    private  String id;

    private  Integer score;

    public Student(String name, String id, Integer score){
        this.name = name;
        this.id = id;
        this.score = score;
    }

    public Student(){

    }

    public void learn(String sub){
        System.out.println("学生正在学"+sub);
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public Integer getScore() {
        return score;
    }
}
