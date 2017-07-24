package wieczorek.jakub.calendar.boundry;

import wieczorek.jakub.calendar.ds.PersonDao;
import wieczorek.jakub.calendar.dto.PersonDTO;
import wieczorek.jakub.calendar.entities.PersonEntity;
import wieczorek.jakub.calendar.params.PersonParam;
import wieczorek.jakub.calendar.service.Refactor;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;
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
        return personDao.findUser(aPersonParam).toDTO();
    }
}
