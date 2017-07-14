package wieczorek.jakub.ds;

import wieczorek.jakub.model.UserDTO;
import wieczorek.jakub.model.UserEntity;
import wieczorek.jakub.model.UserParam;

import java.util.List;

/**
 * Created by jakub on 09.07.17.
 */
public interface UserDao
{
    List<UserEntity> selectUsers();
    void deleteUser(UserEntity aUser);
    void addUser(UserEntity aUser);
    void updateUser(UserParam aPrama, UserEntity aUser);
    UserEntity findUser(UserParam aUserParam);
}
