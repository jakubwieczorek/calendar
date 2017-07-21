package wieczorek.jakub.calendar.service;

import wieczorek.jakub.calendar.dto.UserDTO;
import wieczorek.jakub.calendar.entities.UserEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jakub on 19.07.17.
 */
public final class Refactor
{
    static public Map<String, UserDTO> toMap(List<UserEntity> aList)
    {
        final Map<String, UserDTO> result = new HashMap<>();

        aList.forEach(userEntity -> result.put(userEntity.getMail(), userEntity.toDTO()));

        return result;
    }

    private Refactor()
    {

    }
}
