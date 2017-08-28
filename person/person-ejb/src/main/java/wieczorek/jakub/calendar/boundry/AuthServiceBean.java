package wieczorek.jakub.calendar.boundry;

import wieczorek.jakub.calendar.ds.PersonDao;
import wieczorek.jakub.calendar.dto.PersonDTO;
import wieczorek.jakub.calendar.params.PersonParam;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Created by jakub on 27.08.17.
 */
@Stateless
@Remote(AuthService.class)
public class AuthServiceBean implements AuthService
{
    @Inject
    private PersonDao personDao;

    @Override
    public Boolean isEmailBusy(PersonParam aMail)
    {
        if(personDao.findUser(aMail) != null)
        {
            return true;
        }

        return false;
    }
}
