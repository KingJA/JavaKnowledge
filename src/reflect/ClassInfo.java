package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * [Des]      :     TODO
 * [Author]   :     KingJA
 * [Date]     :     2017/4/9
 * [email]    :     kingjavip@gmail.com
 */
public class ClassInfo {
    public static void main(String[] args) {
        String s = "1";
        Integer i=1;
//        getClassMethodInfo(s);
//        getClassFieldInfo(i);
        getConstructorInfo(s);
    }

    public static void getClassMethodInfo(Object obj) {
        Class<?> clazz = obj.getClass();
        System.out.println(clazz.getName());
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            Class<?> returnType = method.getReturnType();
            System.out.print(returnType.getSimpleName());
            System.out.print(" " + method.getName());

            Parameter[] parameters = method.getParameters();
            System.out.print("(");
            for (int i = 0; i < parameters.length; i++) {
                if (i == parameters.length - 1) {
                    System.out.print(parameters[i].getType().getSimpleName());
                    System.out.print(" " + parameters[i].getName());
                } else {
                    System.out.print(parameters[i].getType().getSimpleName());
                    System.out.print(" " + parameters[i].getName() + ",");
                }
            }
            System.out.println(")");
        }
    }

    public static void getClassFieldInfo(Object obj) {
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            String fieldTypeName = field.getType().getName();
            String fieldName = field.getName();
            System.out.println(fieldTypeName+" "+fieldName);
        }
    }

    public static void getConstructorInfo(Object obj){
        Class<?> clazz = obj.getClass();
        Constructor<?>[] constructors = clazz.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.print(constructor.getName()+"(");
            Parameter[] parameters = constructor.getParameters();
            if (parameters != null && parameters.length > 0) {
                for (int i = 0; i < parameters.length; i++) {
                    if (i != parameters.length - 1) {
                        System.out.print(parameters[i].getType().getSimpleName());
                        System.out.print(" "+parameters[i].getName()+",");
                    }else{
                        System.out.print(parameters[i].getType().getSimpleName());
                        System.out.println(" "+parameters[i].getName()+")");

                    }
                }
            }else{
                System.out.println(")");
            }

        }
    }
}
