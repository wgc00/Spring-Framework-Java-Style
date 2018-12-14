package com.wgc.persons.entity;

import org.springframework.beans.factory.annotation.Value;

import java.util.Date;



public class Persons {

   /**
    * 两注解都是一样的，但一个java内部，一个是spring的
    * @Autowired
    * @Inject     这是标准，如果那天不使用了spring，还要修改，但使用java内部的，以后就不用去修改
    *
    * 机制：按照类型匹配，在按照名字匹配，如果匹配不到会报错
    */
    /**
     * 一边不建议使用@Resource，因为它太老了
     * 机制：先按照名字匹配，在去找类型匹配，如果匹配不到报错*/

    /**
     * 如果我们只想要Clothes中的某个类型名字
     * @Qualifier("cu") spring的 匹配类型，找不到就会报错
     * @Named("cu")  java内部的  匹配类型，找不到就会报错
     *
     * 但是我们还有其他的一样的主要的名字我们有不想报错，就在类上加
     * @Primary  spring的
     * */
    /**/
    /**/

    /**
     *Spring的EL表达式 简称SpEL
     *
     * */

    private Clothes clothes;

    /*spring SpEL
    * T(java.lang.Math)意思就是它就是一个静态类，不能当成变量来使用*/
    @Value("#{T(java.lang.Math).random() * 10000.0}")
    private Integer id;

    private String name;

    private Date birthday;

    private String city;

    private Integer age;

    private Long baborage;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getBaborage() {
        return baborage;
    }

    public void setBaborage(Long baborage) {
        this.baborage = baborage;
    }
}