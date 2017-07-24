package wieczorek.jakub.calendar.service;

import wieczorek.jakub.calendar.dto.PersonDTO;
import wieczorek.jakub.calendar.entities.PersonEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jakub on 19.07.17.
 */
public final class Refactor
{
    static public Map<String, PersonDTO> toMap(List<PersonEntity> aList)
    {
        final Map<String, PersonDTO> result = new HashMap<>();

        aList.forEach(userEntity -> result.put(userEntity.getMail(), userEntity.toDTO()));

        return result;
    }

    private Refactor()
    {

    }
}
