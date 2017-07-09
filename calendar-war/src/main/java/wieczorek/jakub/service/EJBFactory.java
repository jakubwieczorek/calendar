package wieczorek.jakub.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import wieczorek.jakub.ds.UserDao;
import wieczorek.jakub.ds.UserDaoBean;
import wieczorek.jakub.model.User;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by jakub on 08.07.17.
 */

@Configuration
public class EJBFactory
{
    @Bean
    public UserService userService()
    {
        return new UserService();
    }

    @Bean
    public UserDao createUserDao()
    {
        return new UserDaoBean();
    }

    @Bean
    public UserConverter createUserConverter()
    {
        return new UserConverter();
    }
}
