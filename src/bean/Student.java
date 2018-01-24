package bean;

/**
 * Created by zhouxu on 2017/11/22 15:41.
 */
public class Student {

    private Integer age;
    private String name;

    public Student() {
    }

    public Student(Integer age, String name) {

        this.age = age;
        this.name = name;
    }


    private void sayHello(String info) {
        System.out.println("hello>>>>>" + info);
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

