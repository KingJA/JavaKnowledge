package collection;

import java.util.ArrayList;
import java.util.List;

/**
 * Description：TODO
 * Create Time：2017/4/10 13:50
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class ListTest {
    private static final List<String> strings=new ArrayList<>();
    public static void main(String[] args) {
        strings.add("a");
        strings.add("b");
        strings.add("c");
        System.out.println(strings);
    }
}
