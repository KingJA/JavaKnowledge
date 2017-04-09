package reflect;

/**
 * [Des]      :     TODO
 * [Author]   :     KingJA
 * [Date]     :     2017/4/9
 * [email]    :     kingjavip@gmail.com
 */
public class ClassObject {
    public static void main(String[] args) {
        /**
         * Class类对象三种表达方式
         */

        Person person = new Person();
        Class c1=person.getClass();
        Class c2=Person.class;
        try {
            Class c3=Class.forName("reflect.Person");
            System.out.println(c1==c2&&c2==c3);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
