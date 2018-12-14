## Spring    
  · spring的IoC(控制反转)就是一个工厂模式变种，<br/>
  · spring核心就是IoC容器，实现这个容器的接口BeanFactory,BeanFactory是最核心的、最纯粹的<br/>
     方法： <br/>
           getBean() <br/>
     实现类： <br/>
           ApplicationContext <br/>
           
  
  · 简单工厂 
        
         public class ServiceFactory() {
            public Object getServiceObject(String name) {
            
                if("bs".equals(name)) {
                    A a = new A();
                    B b = new b();
                    MyBatiscConnection conn = new MyBatiscConnection();
                    BookService bookservice = new BookService();
                    
                    //同通过setter的方式来确定他们的关系是如何的
                    //B对象包含A对象
                    b.setA(a);
                    //MyBatiscConnection对象包B对象
                    conn.setB(b);
                    //**********__``````````__**********
                    bookService.setConn(conn);
                    log.setConn(conn);
                    bookservice.setLogger(log);
                    return bookService;
                                    
                }
            }
            
         }
         
  
  
  <li> 在调用的时候就变得了简单了</li> 
  
        public class Test () {
            
            public static void main(String[] arge) {
                ServiceFactory sf = new ServiceFactory();
                
                BookService bookservice = sf.getSerivceObject("bs");
                //然后在调用bookservice的某个方法
            }
        }
  <li> 小结：</li>
      
  我们在中间加了一层，虽然不用在调用的时候，创建很多的对象。但在工厂模式中代码类增加了，
  我们在维护的时变得困难了。
  
  <li> 所以后面出现了：XML文件的形式来更清晰的描述，类的创建和类与类之间的关系</li>
  
        <!--之前是命令的形式，xml是描述的形式 -->
        <xml>
              <bean id="a" class="com.wgc.entity.A">
              </bean>
              <bean id="b" class="com.wgc.entity.B">
                <property name="a" ref="a"/>
              </bean>
              <bean id="conn" class="org...MyBatiscConntion">
                <property name="b" ref="b"/>
              </bean>
              <bean id="log" class="org...LogUitl">
                <property name="conn" ref="conn"/>
              </bean>
              <bean id="bookService" class="com...BookService">
                 <property name="conn" ref="conn"/>
                 <property name="log"  ref="log"/>
              </bean>
        </xml>
  
  
  <li> 结论</li>
      使用xml的文件中Bean标签配置，更加清晰的描述出类与类之间的关系。
      
  <li>门面模式：</li>
    例子：有一个工厂有很多的部门，要买东西的时候我们不可能一个一个部门去卖，所以把所以部门组合在一起，在去卖。
   
   
  spring有三种方式描述
  1、@Bean   java类方法<br/>
  2、<bean>  xml<br/>
  3、开启扫描的模式
     @Component <br/>
     @ComponentScan(basePackages="learning.spring") <br/>
     @ImportResource(locations = "learning/spring/my-spring.xml") <br/>
     @Service  <br/>
     @Controller: 这个注解@ControllerAdvice只作用在加上@Controller的类上<br/> 
     @Repository <br/>
  
  4、是java代码写spring的配置
      
      要在类的头部加上@Configuration注解  
      @Configuration
      如果要在java类上加这个注解就是相当xml文件中<beans>
        
   
  工厂模式与IoC的区别：
 
  工厂模式在调用时才创建对象；<br/>
  IoC容器在启动就创建了所有的对象（可以加属性lazy-init="true"：意思是这个对象没有那么重要不着急创建），
  还有所有的对象在刚刚开始都是单例模式创建了(可以加scope="prototype"修改：一般我们不会这么做，因为每次都创建一个新的对象，对内存的消耗是非常大的)
  