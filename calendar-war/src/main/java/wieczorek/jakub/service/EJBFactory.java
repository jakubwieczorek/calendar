package wieczorek.jakub.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import wieczorek.jakub.ds.UserDao;
import wieczorek.jakub.ds.UserDaoBean;

/**
 * Created by jakub on 08.07.17.
 */
@Service
public class EJBFactory
{
    @Bean
    public UserDao createUserDao()
    {
        return new UserDaoBean();
    }

}
