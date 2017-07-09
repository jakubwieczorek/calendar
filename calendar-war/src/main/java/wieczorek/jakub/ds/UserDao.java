package wieczorek.jakub.ds;

import wieczorek.jakub.model.User;
import wieczorek.jakub.model.UserEntity;
import wieczorek.jakub.model.UserParam;

import java.util.List;

/**
 * Created by jakub on 09.07.17.
 */
public interface UserDao
{
    List<UserEntity> findUsers(UserParam userParam);
    List<UserEntity> selectUsers();
}
