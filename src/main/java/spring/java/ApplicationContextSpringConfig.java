package spring.java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*java的方式写*/
@Configuration /*加上这个注解就相当与者是一个与spring中的xml文件一个*/

/*
 * 如果加入这个@ImportResource的意思就是xml与java style一起混合使用
 * @ImportResource(locations = "learning/spring/my-spring.xml")
 * 要去xml写这一句
 * <bean id="config" class="spring.java.ApplicationContextSpringConfig"></bean>
 * */
public class ApplicationContextSpringConfig  {


    @Bean   /*相当与<bean id="b" class="com.wgc.entity.B">*/
    public Animals animalsCall() {
        return new Dog();
    }

    //如果有一个DAO接口
    /*
    * @Bean
    * public BookDAO book() {
    *    return new Book;
    * }
    *
    * 或是注入的方法
    *@Autowired
    * private BookDAO book;
    * */
}
