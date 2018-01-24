package reflect;

import bean.Student;
import org.apache.log4j.Logger;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by zhouxu on 2017/11/22 15:41.
 */
public class ReflectDemo {

    private static Logger log = Logger.getLogger(ReflectDemo.class);

    /** 测试方法
     * @throws Exception
     */
    private void test() throws Exception {

//        获取类的字节码
//        第一种方式
        Class<Student> studentClass = Student.class;

//        第二种方式
        Student student = new Student();
        Class<? extends Student> aClass = student.getClass();

//        第三种方式
        Class clazz = Class.forName("bean.Student");

//        访问私有方法
//        getDeclareMethod()可以获取所有方法,而getMethod()只能获取被public修饰的方法
        Method method = clazz.getDeclaredMethod("sayHello", String.class);

//        压制java对访问修饰符的检查
        method.setAccessible(true);
//        调用私有方法
        method.invoke(student, "hello");

//        访问私有属性
        Field field = clazz.getDeclaredField("name");

        field.setAccessible(true);
//        为私有属性设置值
        field.set(student, "tom");
        log.info("student.getName()>>>>>" + student.getName());
    }

    public static void main(String[] args) {

        try {
            new ReflectDemo().test();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
