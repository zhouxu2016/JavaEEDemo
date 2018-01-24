package annotation;

import java.lang.annotation.*;

/** 水果颜色注解
 * Created by zhouxu on 2017/11/22 16:23.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitColor {

    /**
     * 颜色枚举
     */
    public enum Color{BULE,RED,GREEN};

    /** 颜色属性
     * @return
     */
    public Color fruitColor() default Color.BULE;
}
