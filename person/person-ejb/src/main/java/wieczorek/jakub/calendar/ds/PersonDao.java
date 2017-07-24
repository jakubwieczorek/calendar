package wieczorek.jakub.calendar.ds;

import wieczorek.jakub.calendar.entities.PersonEntity;
import wieczorek.jakub.calendar.params.PersonParam;

import java.util.List;

/**
 * Created by jakub on 09.07.17.
 */
public interface PersonDao
{
    List<PersonEntity> selectUsers();
    void deleteUser(PersonEntity aUser);
    void addUser(PersonEntity aUser);
    void updateUser(PersonParam aParam, PersonEntity aUser);
    PersonEntity findUser(PersonParam aPersonParam);
}
