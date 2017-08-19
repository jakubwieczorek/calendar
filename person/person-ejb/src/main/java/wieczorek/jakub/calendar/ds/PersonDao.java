package wieczorek.jakub.calendar.ds;

import wieczorek.jakub.calendar.dto.EventDTO;
import wieczorek.jakub.calendar.entities.EventEntity;
import wieczorek.jakub.calendar.entities.PersonEntity;
import wieczorek.jakub.calendar.params.PersonParam;

import javax.transaction.Transactional;
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

    List<EventEntity> selectEvents(PersonEntity aUser);

    void addEventToPerson(PersonEntity aUser, EventEntity aEvent);
}
