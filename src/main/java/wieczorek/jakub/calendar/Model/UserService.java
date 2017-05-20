package wieczorek.jakub.calendar.Model;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jakub on 13.05.17.
 */
@Service
public final class UserService
{
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
