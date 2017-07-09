package wieczorek.jakub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wieczorek.jakub.model.LoginParams;
import wieczorek.jakub.model.User;
import wieczorek.jakub.service.UserService;

/**
 * Created by jakub on 26.06.17.
 */
@RestController
@CrossOrigin(origins = "http://localhost:1234")
public class LoginController
{
    @Autowired
    UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<User> login(@RequestBody LoginParams loginParams)
    {
        User user = userService.getUsers().get(loginParams.getUsername());

        if(user != null)
        {
            if(user.getPassword().equals(loginParams.getPassword()))
            {
                return new ResponseEntity<User>(user, HttpStatus.OK);
            }

            return new ResponseEntity<User>((User)null, HttpStatus.CONFLICT);

        } else

        return new ResponseEntity<User>((User)null, HttpStatus.NO_CONTENT);
    }
}
