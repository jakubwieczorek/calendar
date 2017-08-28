package wieczorek.jakub.calendar.boundry;

import wieczorek.jakub.calendar.dto.PersonDTO;
import wieczorek.jakub.calendar.params.PersonParam;

/**
 * Created by jakub on 27.08.17.
 */
public interface AuthService
{
    /**
     * @param aMail
     *
     * @return true if mail is busy
     * */
    Boolean isEmailBusy(PersonParam aMail);
}
