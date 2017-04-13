package genericity;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * [Des]      :     TODO
 * [Author]   :     KingJA
 * [Date]     :     2017/4/10
 * [email]    :     kingjavip@gmail.com
 */
public class GenericityTest {

    public static void main(String[] args) {
        /**
         * 泛型是为了防止类型错误，只在编译的时候有效，可以用反射绕过编译进行操作
         */
        List<String> list=new ArrayList<>();
        Class<? extends List> clazz = list.getClass();
        try {
            Method add = clazz.getMethod("add", Object.class);
            add.invoke(list,10);
            System.out.println(list.size());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
