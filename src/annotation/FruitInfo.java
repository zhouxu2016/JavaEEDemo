package annotation;

import org.apache.log4j.Logger;
import annotation.FruitColor.Color;

import java.lang.reflect.Field;

/**
 * 注解处理器
 * Created by zhouxu on 2017/11/22 17:01.
 */
public class FruitInfo {

    private static Logger log = Logger.getLogger(FruitInfo.class);

    private static void getFruitInfo(Class<?> clazz) {

//        获取所有的成员变量包括私有属性,返回数组(getDeclaredFields()方法可以获取所有的成员变量)
//        通过反射机制获取类的私有成员变量
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {

            log.info("field.getName()>>>" + field.getName());
//            log.info("log.info(field.getAnnotatedType())>>>>>" + field.getAnnotatedType());
//            log.info("field.getAnnotations()>>>>>" + field.getAnnotations());
//            log.info("field.getDeclaredAnnotations()" + field.getDeclaredAnnotations());
//            log.info("fields>>>>>" + field);
        }

        for (Field field : fields) {

            if (field.isAnnotationPresent(FruitName.class)) {

                FruitName fruitName = field.getAnnotation(FruitName.class);
                String value = fruitName.value();
                log.info("水果名称>>>" + value);
            } else if (field.isAnnotationPresent(FruitColor.class)) {

                FruitColor fruitColor = field.getAnnotation(FruitColor.class);
                Color color = fruitColor.fruitColor();
                log.info("水果颜色>>>" + color.toString());
            } else if (field.isAnnotationPresent(FruitProvider.class)) {

                FruitProvider fruitProvider = field.getAnnotation(FruitProvider.class);
                int id = fruitProvider.id();
                String name = fruitProvider.name();
                String address = fruitProvider.address();
                log.info("供应商编号>>>" + id + "   供应商名称>>>" + name + "   供应商地址>>>" + address);
            }
        }
    }

    public static void main(String[] args) {

        FruitInfo.getFruitInfo(Apple.class);
    }

}
