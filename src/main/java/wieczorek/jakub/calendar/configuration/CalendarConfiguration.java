package wieczorek.jakub.calendar.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
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
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) 
    {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        
        registry.viewResolver(viewResolver);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry)
    {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    @Bean
    public UserService userService()
    {
        UserService userService = new UserService();
        userService.setUsers(new ConcurrentHashMap<String, User>());
//        userService.setUsers(new UsersList());

        User user = new User("Kuba", "kuba@op.pl");
        //user.setId(1);
        userService.getUsers().put(user.getUsername(), user);

        user = new User("Bartek", "bartek@op.pl");
        //user.setId(2);
        userService.getUsers().put(user.getUsername(), user);

        return userService;
    }
}
