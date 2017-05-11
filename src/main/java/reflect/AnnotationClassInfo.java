package reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

/**
 * [Des]      :     TODO
 * [Author]   :     KingJA
 * [Date]     :     2017/4/9
 * [email]    :     kingjavip@gmail.com
 */
public class AnnotationClassInfo {
    public static void main(String[] args) {
        String s = "1";
        Integer i = 1;
        Info info = new Info();
        getClassMethodInfo(info);
//        getClassFieldInfo(i);
//        getConstructorInfo(s);
    }

    public static void getClassMethodInfo(Object obj) {
        Class<?> clazz = obj.getClass();
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            Annotation[] annotations = method.getAnnotations();
            for (Annotation annotation : annotations) {
//                annotation.
            }
        }
    }

}

class Info {
    @Deprecated
    public String getName(String name) {
        return "name:" + name;
    }
}
