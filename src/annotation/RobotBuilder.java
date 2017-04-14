package annotation;

import java.lang.reflect.Method;

/**
 * Description：TODO
 * Create Time：2017/4/14 10:19
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class RobotBuilder {
    public static void main(String[] args) {
        getAnnotationInfo(RobotBuilder.class);
    }

    private static void getAnnotationInfo(Class<RobotBuilder> robotBuilderClass) {
        Method[] methods = robotBuilderClass.getDeclaredMethods();
        for (Method method : methods) {
            Robot annotation = method.getAnnotation(Robot.class);
            if (method.isAnnotationPresent(Robot.class)){
                System.out.println(">>>method:"+method.getName());
            }
            if (annotation != null) {
                int robotcount = annotation.robotcount();
                String robotName = annotation.robotName();
                Robot.RobotSize robotSize = annotation.robotSize();
                System.out.println(">>>robotcount:"+robotcount);
                System.out.println(">>>robotName:"+robotName);
                System.out.println(">>>robotSize:"+robotSize);
            }
        }
    }

    @Robot(robotcount = 5, robotName = "XMAN", robotSize = Robot.RobotSize.BIG)
    public void buildRobot() {}
}
