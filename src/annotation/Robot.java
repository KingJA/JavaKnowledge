package annotation;

import java.lang.annotation.*;

/**
 * [Des]      :     TODO
 * [Author]   :     KingJA
 * [Date]     :     2017/4/13
 * [email]    :     kingjavip@gmail.com
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Robot {
    public enum RobotSize {BIG, MED, MIN;}

    int robotcount() default 1;

    String robotName() default "ET";

    RobotSize robotSize() default RobotSize.MED;
}
