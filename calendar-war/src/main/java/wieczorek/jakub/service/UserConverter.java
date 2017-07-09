package wieczorek.jakub.service;

import wieczorek.jakub.model.User;
import wieczorek.jakub.model.UserEntity;

/**
 * Created by jakub on 10.07.17.
 */
public class UserConverter implements Converter<User, UserEntity>
{
    public User convertToDto(UserEntity aEntity)
    {
        User user = new User();

        user.setMail(aEntity.getMail());
        user.setPassword(aEntity.getPassword());
        user.setUsername(aEntity.getUsername());

        return user;
    }

    public UserEntity convertToEntity(User aDto)
    {
        return null;
    }
}
