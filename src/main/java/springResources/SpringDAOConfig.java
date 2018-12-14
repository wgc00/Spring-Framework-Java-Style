package springResources;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
@PropertySource(value = {"classpath:jdbc.properties"})
public class SpringDAOConfig {


/* @Value("${jdbc.driver}")
    String driver;
    @Value("${jdbc.url}")
    String url;
    @Value("${jdbc.user}")
    String user;
    @Value("${jdbc.password}")
    String password;
*/
    /*获取properties为后缀名的文件
     *
     * 第一种方法
     * @PropertySource注解 和Environment类（spring的）一起用
     *
     * 第二种方法
     *
     *
     * */
    @Autowired
    private Environment env;

    /*定义这个方法后就可以使用
     * 这样写： "${jdbc.url}"
     * */
    @Bean
    public static PropertySourcesPlaceholderConfigurer getPSPC() {
        /*创建一个*/
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        return configurer;
    }

    @Bean
    public DataSource dataSource() throws PropertyVetoException {
        /*
         * */
//        SimpleDriverDataSource source = new SimpleDriverDataSource();
//        PooledDataSource source = new PooledDataSource();
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setJdbcUrl("jdbc:mariadb://localhost:3308/demo");
        dataSource.setDriverClass("org.mariadb.jdbc.Driver");
        dataSource.setUser("root");
        dataSource.setPassword("123456");
//        dataSource.setJdbcUrl("${jdbc.url}");
//        dataSource.setDriverClass("${jdbc.driver}");
//        dataSource.setUser("${jdbc.user}");
//        dataSource.setPassword("${jdbc.password}");
/*        dataSource.setJdbcUrl(this.url);
        dataSource.setDriverClass(this.driver);
        dataSource.setUser(this.user);
        dataSource.setPassword(this.password);*/
        return dataSource;
    }

    /*@Bean(name = "sqlSessionFactory") 如果不写就默认方法的名字*/
    @Bean("sqlSessionFactory")
    public SqlSessionFactoryBean sqlSessionFactory() throws PropertyVetoException {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();

        ClassPathResource resource = new ClassPathResource("mapper/PersonsMapper.xml");
        sqlSessionFactory.setTypeAliasesPackage("com.wgc.persons.entity");
        sqlSessionFactory.setMapperLocations(new Resource[]{resource});
        sqlSessionFactory.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
        sqlSessionFactory.setDataSource(this.dataSource());
        return sqlSessionFactory;
    }

    @Bean
    public MapperScannerConfigurer getMapperScannerConfigurer() {
        MapperScannerConfigurer configurer = new MapperScannerConfigurer();
        configurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        configurer.setBasePackage("com.wgc.persons.dao");
        return configurer;
    }
}
