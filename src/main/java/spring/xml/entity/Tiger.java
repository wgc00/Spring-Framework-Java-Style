package spring.xml.entity;

import org.springframework.beans.factory.annotation.Autowired;

public class Tiger {

    @Autowired
    private Image photo;
    private String name;

    public Tiger() {
        System.out.println(this.name);
    }

    public Tiger(String name) {
        this.name = name;
    }

    public Image getPhoto() {
        return photo;
    }

    public void setPhoto(Image photo) {
        this.photo = photo;
    }
}
