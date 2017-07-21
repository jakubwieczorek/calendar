package wieczorek.jakub.calendar.ds;

import wieczorek.jakub.calendar.entities.UserEntity;
import wieczorek.jakub.calendar.model.UserParam;

import java.util.List;

/**
 * Created by jakub on 09.07.17.
 */
public interface UserDao
{
    List<UserEntity> selectUsers();
    void deleteUser(UserEntity aUser);
    void addUser(UserEntity aUser);
    void updateUser(UserParam aParam, UserEntity aUser);
    UserEntity findUser(UserParam aUserParam);
}
