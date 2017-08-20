package wieczorek.jakub.calendar.boundry;

import wieczorek.jakub.calendar.ds.PersonDao;
import wieczorek.jakub.calendar.dto.EventDTO;
import wieczorek.jakub.calendar.dto.PersonDTO;
import wieczorek.jakub.calendar.entities.EventEntity;
import wieczorek.jakub.calendar.entities.PersonEntity;
import wieczorek.jakub.calendar.params.PersonParam;
import wieczorek.jakub.calendar.service.Refactor;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by jakub on 14.07.17.
 */

@Stateless
@Remote(PersonService.class)
public class PersonServiceBean implements PersonService
{
    @Inject
    PersonDao personDao;

    @Override
    public Map<String, PersonDTO> selectUsers()
    {
        return Refactor.toMap(personDao.selectUsers());
    }

    @Override
    public void deleteUser(PersonDTO aUser)
    {
        personDao.deleteUser(new PersonEntity(aUser));
    }

    @Override
    public void addUser(PersonDTO aUser)
    {
        personDao.addUser(new PersonEntity(aUser));
    }

    @Override
    public void updateUser(PersonParam aParam, PersonDTO aUser)
    {
        personDao.updateUser(aParam, new PersonEntity(aUser));
    }

    @Override
    public PersonDTO findUser(PersonParam aPersonParam)
    {
        if(personDao.findUser(aPersonParam) != null)
        {
            return personDao.findUser(aPersonParam).toDTO();
        }

        return null;
    }

    @Override
    public List<EventDTO> selectEvents(PersonParam param)
    {
        List<EventDTO> eventDTOS = new ArrayList<>();
        List<EventEntity> eventEntities = personDao.selectEvents(param);

        eventEntities.forEach((item) -> eventDTOS.add(item.toDto()));

        return eventDTOS;
    }

    @Override
    public void addEventToPerson(PersonDTO aPerson, EventDTO aEvent)
    {
        this.personDao.addEventToPerson(new PersonEntity(aPerson), new EventEntity(aEvent));
    }

    @Override
    public EventDTO findEvent(PersonParam aParam, EventDTO aEvent)
    {
//        return personDao.findEvent(aParam, new EventEntity(aEvent));
//
//        if(personDao.findEvent(aParam, new EventEntity(aEvent)) != null)
//        {
//            return personDao.findEvent(aParam, new EventEntity(aEvent)).toDTO();
//        }

        return null;
    }

    @Override
    public void deleteEvent(PersonParam aParam, EventDTO event)
    {
        personDao.deleteEvent(aParam, new EventEntity(event));
    }
}