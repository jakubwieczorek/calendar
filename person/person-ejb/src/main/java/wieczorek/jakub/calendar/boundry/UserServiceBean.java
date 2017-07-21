package wieczorek.jakub.calendar.boundry;

import wieczorek.jakub.calendar.ds.UserDao;
import wieczorek.jakub.calendar.dto.UserDTO;
import wieczorek.jakub.calendar.entities.UserEntity;
import wieczorek.jakub.calendar.model.UserParam;
import wieczorek.jakub.calendar.service.Refactor;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Map;

/**
 * Created by jakub on 14.07.17.
 */

@Stateless
@Remote(UserService.class)
public class UserServiceBean implements UserService
{
    @Inject
    UserDao userDao;

    @Override
    public Map<String, UserDTO> selectUsers()
    {
        return Refactor.toMap(userDao.selectUsers());
    }

    @Override
    public void deleteUser(UserDTO aUser)
    {
        userDao.deleteUser(new UserEntity(aUser));
    }

    @Override
    public void addUser(UserDTO aUser)
    {
        userDao.addUser(new UserEntity(aUser));
    }

    @Override
    public void updateUser(UserParam aParam, UserDTO aUser)
    {
        userDao.updateUser(aParam, new UserEntity(aUser));
    }

    @Override
    public UserDTO findUser(UserParam aUserParam)
    {
        return userDao.findUser(aUserParam).toDTO();
    }
}
