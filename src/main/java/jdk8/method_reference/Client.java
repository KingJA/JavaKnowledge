package jdk8.method_reference;

import java.util.ArrayList;
import java.util.List;

/**
 * Description：TODO
 * Create Time：2017/5/27 9:39
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class Client {
    public static void main(String[] args) {
        List<String>strings=new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            strings.add(i+"");
        }
        strings.stream().map(Integer::valueOf).filter(integer -> integer>5).forEach(System.out::println);
    }
}
