package wieczorek.jakub.calendar.boundry;

import wieczorek.jakub.calendar.dto.EventDTO;
import wieczorek.jakub.calendar.dto.PersonDTO;
import wieczorek.jakub.calendar.params.PersonParam;

import java.util.List;
import java.util.Map;

/**
 * Created by jakub on 19.07.17.
 */
public interface PersonService
{
    Map<String, PersonDTO> selectUsers();
    void deleteUser(PersonDTO aUser);
    void addUser(PersonDTO aUser);
    void updateUser(PersonParam aParam, PersonDTO aUser);
    PersonDTO findUser(PersonParam aPersonParam);

    List<EventDTO> selectEvents(PersonDTO aPerson);

    void addEventToPerson(PersonDTO aPerson, EventDTO aEvent);
}
