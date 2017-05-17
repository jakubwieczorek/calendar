package wieczorek.jakub.configuration;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import wieczorek.jakub.Model.User;
import wieczorek.jakub.Model.UserService;

import java.util.ArrayList;

/**
 * Created by jakub on 13.05.17.
 */
@Configuration
public class CalendarConfiguration
{
    @Bean
    public UserService userService()
    {
        UserService userService = new UserService();
        userService.setUsers(new ArrayList<User>());
//        userService.setUsers(new UsersList());

        User user = new User("Kuba", "kuba@op.pl");
        //user.setId(1);
        userService.getUsers().add(user);

        user = new User("Bartek", "bartek@op.pl");
        //user.setId(2);
        userService.getUsers().add(user);

        return userService;
    }
}
