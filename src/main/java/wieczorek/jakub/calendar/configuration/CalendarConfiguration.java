package wieczorek.jakub.calendar.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import wieczorek.jakub.calendar.Model.User;
import wieczorek.jakub.calendar.Model.UserService;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by jakub on 13.05.17.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "wieczorek.jakub.calendar")
public class CalendarConfiguration extends WebMvcConfigurerAdapter
{
    @Bean
    public UserService userService()
    {
        UserService userService = new UserService();
        userService.setUsers(new ConcurrentHashMap<String, User>());

        User user = new User("Kuba", "kuba@op.pl");

        userService.getUsers().put(user.getUsername(), user);

        user = new User("Bartek", "bartek@op.pl");

        userService.getUsers().put(user.getUsername(), user);

        return userService;
    }
}
