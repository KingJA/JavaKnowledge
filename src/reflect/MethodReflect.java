package reflect;

import java.lang.reflect.Method;

/**
 * [Des]      :     TODO
 * [Author]   :     KingJA
 * [Date]     :     2017/4/9
 * [email]    :     kingjavip@gmail.com
 */
public class MethodReflect {
    public static void main(String[] args) {
        Bean bean = new Bean();
        Class<? extends Bean> clazz = bean.getClass();
        try {
            Method noParamMethod = clazz.getMethod("noParam");
            noParamMethod.invoke(bean);
            Method singleParamMethod = clazz.getMethod("singleParam",int.class);
            singleParamMethod.invoke(bean,10);
            Method doubleParamMethod = clazz.getMethod("doubleParam",int.class,String.class);
            doubleParamMethod.invoke(bean,10,"hello");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

class Bean {
    public void noParam() {
        System.out.println("noParam");
    }

    public void singleParam(int i) {
        System.out.println("singleParam i=" + i);
    }

    public void doubleParam(int i, String s) {
        System.out.println("doubleParam i=" + i + " s=" + s);
    }
}
