package wieczorek.jakub.Model;

import wieczorek.jakub.Model.User;

import java.util.ArrayList;

/**
 * Created by jakub on 14.05.17.
 */
public final class UsersList extends ArrayList<User>
{
    private Integer id;

    public UsersList()
    {
        super();

        id = 0;
    }

    @Override
    public boolean add(User user)
    {
        //user.setId(++id);

        return super.add(user);
    }
}
