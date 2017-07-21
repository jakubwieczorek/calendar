package wieczorek.jakub.calendar.boundry;

import wieczorek.jakub.calendar.dto.UserDTO;
import wieczorek.jakub.calendar.model.UserParam;

import java.util.Map;

/**
 * Created by jakub on 19.07.17.
 */
public interface UserService
{
    Map<String, UserDTO> selectUsers();
    void deleteUser(UserDTO aUser);
    void addUser(UserDTO aUser);
    void updateUser(UserParam aParam, UserDTO aUser);
    UserDTO findUser(UserParam aUserParam);
}
