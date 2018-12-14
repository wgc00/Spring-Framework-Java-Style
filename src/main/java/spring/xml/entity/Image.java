package spring.xml.entity;

public class Image {


    private String img;
    private Tiger tiger;


    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Image image = Image.class.newInstance();
        image.img="sdf";
        System.out.println(image.img);
    }
}
