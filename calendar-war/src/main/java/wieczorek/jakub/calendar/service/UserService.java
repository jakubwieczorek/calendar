package wieczorek.jakub.calendar.service;

import org.springframework.stereotype.Service;
import wieczorek.jakub.calendar.model.User;

import java.util.Map;

/**
 * Created by jakub on 13.05.17.
 */
@Service
public final class UserService
{
    private Map<String, User> users;

    public Map<String, User> getUsers() {
        return users;
    }

    public void setUsers(Map<String, User> users) {
        this.users = users;
    }
}
