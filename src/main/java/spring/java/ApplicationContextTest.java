package spring.java;

public class ApplicationContextTest {

    public static void main(String[] args) {

        //使用Java Style的方式配置
        //Spring配置有两种中方式一种是xml、另一种是java style
        //
        ApplicationContextSpringConfig config = new ApplicationContextSpringConfig();
        Animals animals = config.animalsCall();
        animals.call();
    }
}
