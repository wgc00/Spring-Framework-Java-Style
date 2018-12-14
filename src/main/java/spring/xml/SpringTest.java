package spring.xml;

import spring.xml.entity.Image;

import java.lang.reflect.Field;

public class SpringTest {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchFieldException {

        /*创建一个ClassPathXmlApplicationContext实现类，可以获取到my-spring.xml文件*/
      /*  ApplicationContext context = new ClassPathXmlApplicationContext("learning/spring/my-spring.xml");*/
        //第一种 方式用反射的方式获取到ServiceImpl
        //ServiceImpl bean = context.getBean(Service.class);

        //第二种 方式,使用my-spring.xml中<bean>中写的id bs
//        ServiceImpl bs = (ServiceImpl) context.getBean("bs");
//        bs.seyHell();


      /*  Sheep sheep = (Sheep) context.getBean("sheep");
        System.out.println(sheep.getName());
        System.out.println(sheep.getType());
*/
      /*  Cat bean = context.getBean(Cat.class);
        List<String> type = bean.getType();
        type.forEach(System.out::println );*/

/*
        Tiger bean1 = context.getBean(Tiger.class);
        List<Image> photo = bean1.getPhoto();
        System.out.println(photo.get(0).getImg());*/

       /* Rabbit bean = context.getBean(Rabbit.class);
        System.out.println(bean.getName());
        List<String> type = bean.getType();
        type.forEach(System.out::println);*/

        Image image = new Image();
        Field names = image.getClass().getDeclaredField("img");
        names.setAccessible(true);
        names.set(image, "ds");




    }
}
