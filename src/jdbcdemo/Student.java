package jdbcdemo;


import java.sql.Date;

/**
 * Created by zhouxu on 2017/12/14 10:08.
 */
public class Student {

    private String sno;
    private String sname;
    private String gender;
    private String professional;
    private String classis;
    private String grade;
    private int age;
    private Date intime;

    public Student() {
    }

    public Student(String sno, String sname, String gender, String professional, String classis, String grade, int age, Date intime) {
        this.sno = sno;
        this.sname = sname;
        this.gender = gender;
        this.professional = professional;
        this.classis = classis;
        this.grade = grade;
        this.age = age;
        this.intime = intime;
    }


    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }

    public String getClassis() {
        return classis;
    }

    public void setClassis(String classis) {
        this.classis = classis;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getIntime() {
        return intime;
    }

    public void setIntime(Date intime) {
        this.intime = intime;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sno='" + sno + '\'' +
                ", sname='" + sname + '\'' +
                ", gender='" + gender + '\'' +
                ", professional='" + professional + '\'' +
                ", classis='" + classis + '\'' +
                ", grade='" + grade + '\'' +
                ", age=" + age +
                ", intime=" + intime +
                '}';
    }
}
