package springjpa.config;

import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import springjpa.Base;

@Configuration
@ComponentScan(basePackageClasses = Base.class,
    excludeFilters = @ComponentScan.Filter(Controller.class))
public class RootConfig {
    @Bean
    public DataSource dataSource() {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName(com.mysql.cj.jdbc.Driver.class.getName());
        basicDataSource.setUrl("jdbc:mysql://133.186.211.156:3306/nhn_academy_16");
        basicDataSource.setUsername("nhn_academy_16");
        basicDataSource.setPassword("ANQDj5vXfM@1vTo@");
        basicDataSource.setInitialSize(2);
        basicDataSource.setMaxTotal(10);
        return basicDataSource;
    }

}
