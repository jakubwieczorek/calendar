package wieczorek.jakub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wieczorek.jakub.ds.UserDao;
import wieczorek.jakub.model.User;
import wieczorek.jakub.model.UserEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by jakub on 13.05.17.
 */
@Service
public final class UserService
{
    public Map<String, User> getUsers()
    {
        List<UserEntity> list = userDao.selectUsers();

        Map<String, User> map = new HashMap<String, User>();
        // stream, lambda

        for(UserEntity user : list)
        {
            map.put(user.getUsername(), userConverter.convertToDto(user));
        }

        return map;
    }

    @Autowired
    UserDao userDao;

    @Autowired
    UserConverter userConverter;
}
