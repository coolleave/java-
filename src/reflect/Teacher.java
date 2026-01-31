package reflect;

/**
 * 教师类（仿照student类结构编写）
 * 包含私有final成员变量、全参构造、getter方法
 */
public class Teacher {
    // 私有final成员变量（贴合教师业务场景）
    private  String name;       // 教师姓名
    private  String teacherId;  // 教师工号（对应student的id）
    private  Integer teachAge;  // 教龄（年，对应student的score）
    private  String subject;    // 所教科目（新增贴合教师的核心字段）

    // 全参构造方法（初始化所有final成员变量）
    public Teacher(String name, String teacherId, Integer teachAge, String subject) {
        this.name = name;
        this.teacherId = teacherId;
        this.teachAge = teachAge;
        this.subject = subject;
    }

    public Teacher(){

    }

    public void teach(String sub){
        System.out.println("老师教"+sub);
    }

    // 对应每个成员变量的public getter方法
    public String getName() {
        return name;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public Integer getTeachAge() {
        return teachAge;
    }

    public String getSubject() {
        return subject;
    }
}