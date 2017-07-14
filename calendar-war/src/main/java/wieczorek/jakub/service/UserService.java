package wieczorek.jakub.service;

import wieczorek.jakub.model.UserDTO;
import wieczorek.jakub.model.UserEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jakub on 14.07.17.
 */
public final class UserService
{
    static public Map<String, UserDTO> toMap(List<UserEntity> aList)
    {
        final Map<String, UserDTO> result = new HashMap<>();

        aList.forEach(userEntity -> result.put(userEntity.getMail(), userEntity.toDTO()));

        return result;
    }
}
