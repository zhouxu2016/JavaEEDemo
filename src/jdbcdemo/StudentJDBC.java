package jdbcdemo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by zhouxu on 2017/12/14 10:25.
 */
public class StudentJDBC {


    /** 第一种方式:   批量插入数据,使用for循环实现,每设置一条数据,执行一次sql
     * @param students
     */
    public void save(ArrayList<Student> students) {

        Connection connection = DBUtil.getConnection();
        String sql = "insert into student values(?,?,?,?,?,?,?,?)";
        PreparedStatement ps = null;

        try {

            ps = connection.prepareStatement(sql);
            for (Student student : students) {

                ps.setString(1, student.getSno());
                ps.setString(2, student.getSname());
                ps.setString(3, student.getGender());
                ps.setString(4, student.getProfessional());
                ps.setString(5, student.getClassis());
                ps.setString(6, student.getGrade());
                ps.setInt(7, student.getAge());
                ps.setDate(8, student.getIntime());

                int update = ps.executeUpdate();
                System.out.println("update>>>>>   " + update);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        finally {

            DBUtil.close(null, ps, connection);
        }

    }


    /**第二种方式: 使用addBatch()方法实现
     * @param students
     */
    public void saveTwo(ArrayList<Student> students) {


        Connection connection = DBUtil.getConnection();
        String sql = "insert into student values(?,?,?,?,?,?,?,?)";
        PreparedStatement ps = null;

        try {

            ps = connection.prepareStatement(sql);
            for (Student student : students) {

                ps.setString(1, student.getSno());
                ps.setString(2, student.getSname());
                ps.setString(3, student.getGender());
                ps.setString(4, student.getProfessional());
                ps.setString(5, student.getClassis());
                ps.setString(6, student.getGrade());
                ps.setInt(7, student.getAge());
                ps.setDate(8, student.getIntime());

//                不发送参数,不执行sql,先保存参数,添加一条要执行的sql
                ps.addBatch();
            }

//            一次性发送所有保存的参数到数据库执行
            ps.executeBatch();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        finally {

            try {
//                清空之前缓存过的sql内容(可不写,会自动清空)
                ps.clearBatch();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            DBUtil.close(null, ps, connection);
        }
    }


    public static void main(String[] args) {


        ArrayList<Student> students = new ArrayList<>();

        java.util.Date date1 = new java.util.Date();
        Date date = new Date(date1.getTime());

        System.out.println("date>>>>>   " + date);
        Student student1 = new Student("5", "enen", "男", "计算机", "计算机3班", "90", 18, date);

        Student student2 = new Student("6", "kk", "男", "计算机", "计算机3班", "90", 18, date);

        students.add(student1);
        students.add(student2);

//        new StudentJDBC().save(students);
        new StudentJDBC().saveTwo(students);
    }


}
