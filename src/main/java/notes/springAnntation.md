
##  一、Spring 常用的注解
         @Bean
         @Import
         @ImportResource
         @Configuration
         @ComponentScan
         @Component
         @Controller
         @Service
         @Repository      

----

- @Bean
    
   
     @Bean :使用此注解相当与在xml定义一个<bean>标签(在方法上使用)
     示例：<bean id="a" class="com.wgc.xxx.entity.A">相当于这个
           如果我们在需要在java中给这个@Bean添加一个名字，
           
              @Bean("sqlSessionFactory")//给它一个名字
               public SqlSessionFactoryBean sqlSessionFactory() throws PropertyVetoException {
                   SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
           
                   ClassPathResource resource = new ClassPathResource("mapper/PersonsMapper.xml");
                   sqlSessionFactory.setTypeAliasesPackage("com.wgc.persons.entity");
                   sqlSessionFactory.setMapperLocations(new Resource[]{resource});
                   sqlSessionFactory.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
                   sqlSessionFactory.setDataSource(this.dataSource());
                   return sqlSessionFactory;
               }
     
     
--- 
- @Import
    
    
     @Import : 可以导入其他的类，为什么要导入呢？
     在实际的开发中我们不可能写一个类，可以分出很多的类
     如：xml标签中的<import resources="xxx.xml">
     java的使用: @Import({xxx.class, yyy.class, sss.class})
     

--- 
  - @ImportResource
  
   
     @ImportResource : 意思导入一个xml文件，这个的使用的xml文件与java style混合使用
     
     如： @ImportResource("../spring-dao.xml") 
    
    
 -- 
   - @Configuration
   
     
     @Configuration ： 意思是这个一配置文件
     使用spring配置类上
     
     
     
     @ComponentScan ：告诉Spring在初始化是要扫描那个包
     如：<contxt:component-scan base-package="com.wgc.persons.controller" /> 这句
    
--- 
  - @Component、@Controller、@Service、@Repository        
     
    
     @Component ：组件
     @Controller ：控制器
     @Service   ：服务
     @Repository   ：容器
     
     其实四个注解是单独使用的话是没有太大的区别的，
     如果，一定说区别的话就是，当他们碰到某个相关的注解时，
     他们就有的一定的语义。
     如： @Controller @ControllerAdvice 连个注解就产生了语义
     
     
     如果在不知道不明确的情况下我们，无法选这四个注解其中的时，
     那就先选@Component 因为这个注解没有语义
     
    
            

## 二、在注解方式中要确定，Bean之间的关系，需要使用一下的注解
    
    两注解都是一样的，但一个java内部，一个是spring的，
    机制：按照类型匹配，在按照名字匹配，如果匹配不到会报错 
    @Autowired  （spring注解）
    @Inject     （java内部注解，这是标准）
   
    
    机制：先按照名字匹配，在去找类型匹配，如果匹配不到报错
    一般不建议使用@Resource，因为它太老了
    @Resource   （java内部注解）
    上面三注解的意思都是一样的，都是注入值或其他
    
    
     @Value 设置值可以使用SpEL表达式
     例子：  
    
     如果我们只想要Clothes类中的某个类型名字
     @Qualifier("cu") spring的 匹配类型，找不到就会报错
     @Named("cu")  java内部的  匹配类型，找不到就会报错
     
     但是我们还有其他一样的，主要的名字我们有不想报错，就在类上加
     @Primary  （spirng）
  