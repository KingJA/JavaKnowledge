package jdk8.stream;

/**
 * Description：TODO
 * Create Time：2017/5/27 9:36
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class Student {
    public Student(int age, int height, int name) {
        this.age = age;
        this.height = height;
        this.name = name;
    }

    private int age;
    private int height;
    private int name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }
}
