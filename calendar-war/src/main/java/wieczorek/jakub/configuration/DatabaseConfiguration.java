package wieczorek.jakub.configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import wieczorek.jakub.util.DS;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by jakub on 07.07.17.
 */
@Configuration
@EnableTransactionManagement
@EnableWebMvc
@ComponentScan(basePackages = "wieczorek.jakub")
public class DatabaseConfiguration extends WebMvcConfigurerAdapter
{
    @Bean
    public LocalSessionFactoryBean entitySessionFactory()
    {
        LocalSessionFactoryBean entityManagerFactory = new LocalSessionFactoryBean();

        entityManagerFactory.setDataSource(dataSource);
        entityManagerFactory.setPackagesToScan(env.getProperty("entitymanager.packagesToScan"));

        // Hibernate properties
        Properties additionalProperties = new Properties();

        additionalProperties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
        additionalProperties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
        additionalProperties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));

        entityManagerFactory.setHibernateProperties(additionalProperties);

        return entityManagerFactory;
    }

    @Bean
    public HibernateTransactionManager transactionManager()
    {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();

        transactionManager.setSessionFactory(entitySessionFactory().getObject());

        return transactionManager;
    }

    @Autowired
    private Environment env;

    @Autowired
    @DS
    private DataSource dataSource;
}
