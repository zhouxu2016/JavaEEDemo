package annotation;

import java.lang.annotation.*;

/**
 * 水果提供者注解
 * Created by zhouxu on 2017/11/22 16:42.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitProvider {

    /** 供应商编号
     * @return
     */
    public int id() default -1;

    /** 供应商名称
     * @return
     */
    public String name() default "";

    /** 供应商地址
     * @return
     */
    public String address() default "";
}