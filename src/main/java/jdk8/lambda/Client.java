package jdk8.lambda;

/**
 * Description：TODO
 * Create Time：2017/5/27 10:31
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class Client {

    public static void main(String[] args) {
        new Thread(()-> System.out.println("run")).start();
    }
}
