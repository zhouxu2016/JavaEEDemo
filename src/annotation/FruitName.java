package annotation;

import java.lang.annotation.*;

/** 水果名称注解
 * Created by zhouxu on 2017/11/22 16:18.
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitName {

//    该注解用于修饰成员变量
    public String value() default "";

}
