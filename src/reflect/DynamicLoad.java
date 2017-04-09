package reflect;

/**
 * [Des]      :     TODO
 * [Author]   :     KingJA
 * [Date]     :     2017/4/9
 * [email]    :     kingjavip@gmail.com
 */
public class DynamicLoad {
    public static void main(String[] args) {
        /**
         * 类的动态加载
         * new属于静态加载，在编译的时候就加载，
         * 从类对象创建对象属于动态加载，就是在用的时候才加载
         */
        try {
            Class c = Class.forName("reflect.Person");
            Think o = (Think) c.newInstance();
            o.think();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Person implements Think {
    @Override
    public void think() {
        System.out.println("思考");
    }
}

interface Think {
    void think();
}


