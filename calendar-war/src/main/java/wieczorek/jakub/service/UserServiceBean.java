package wieczorek.jakub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wieczorek.jakub.ds.UserDao;
import wieczorek.jakub.model.UserDTO;
import wieczorek.jakub.model.UserEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jakub on 13.05.17.
 */
@Service
public final class UserService
{
    public Map<String, UserDTO> getUsers()
    {
        List<UserEntity> list = userDao.selectUsers();

        Map<String, UserDTO> map = new HashMap<String, UserDTO>();
        // stream, lambda

        for(UserEntity user : list)
        {
            map.put(user.getMail(), userConverter.convertToDto(user));
        }

        return map;
    }

    public void addUser(UserDTO aUser)
    {
        this.userDao.addUser(this.userConverter.convertToEntity(aUser));
    }

    @Autowired
    UserDao userDao;

    @Autowired
    UserConverter userConverter;
}
