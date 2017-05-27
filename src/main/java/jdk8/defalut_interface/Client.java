package jdk8.defalut_interface;

/**
 * Description：TODO
 * Create Time：2017/5/27 9:21
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class Client {
    public static void main(String[] args) {
        Person person = new Person() {
            @Override
            public void doThing() {
                System.out.println("run");
            }
        };
        person.getName();
        Person.getAddress();
        person.doThing();
    }
}
