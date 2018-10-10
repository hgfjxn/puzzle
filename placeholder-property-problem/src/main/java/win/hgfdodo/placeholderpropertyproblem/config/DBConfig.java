package win.hgfdodo.placeholderpropertyproblem.config;

import org.h2.jdbcx.JdbcDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@Configuration
public class DBConfig {

    @Value("${db.user}")
    String user;

    @Bean
    public DataSource dataSource(PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer) {
        System.out.println(propertySourcesPlaceholderConfigurer);
        System.out.println(propertySourcesPlaceholderConfigurer.getAppliedPropertySources());
        System.out.println("db config: " + user);
        JdbcDataSource dataSource = new JdbcDataSource();
        dataSource.setUrl("jdbc:h2:˜/test");
        dataSource.setUser(user);

        return dataSource;
    }

}
