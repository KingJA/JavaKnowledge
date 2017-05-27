package jdk8.defalut_interface;

/**
 * Description：TODO
 * Create Time：2017/5/27 9:19
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public interface Person {
    //默认方法
    default void getName() {
        System.out.println("Person");
    }
    //静态方法
    static void getAddress() {
        System.out.println("earth");
    }
    //普通抽象方法
    void doThing();
}
