package wieczorek.jakub.calendar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wieczorek.jakub.calendar.Model.UserService;
import wieczorek.jakub.calendar.Model.User;

import java.util.List;
import java.util.Map;

/**
 * Created by jakub on 08.05.17.
 */
@RestController// == @Controller + @ResponseBody (@ResponseBody before each method which
// binds returned value to outgoing http response body)
@RequestMapping("/users")
public class UsersController
{
    @Autowired
    private UserService userService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Void>createUser(@RequestBody User user)
    {
        userService.getUsers().put(user.getUsername(), user);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<Map<String, User>>fetchAllUsers()
    {
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.PUT)
    public ResponseEntity<Void>createUser(@PathVariable(value = "username") String username, @RequestBody User user)
    {
        User userToUpdate = userService.getUsers().get(username);

        userToUpdate.setMail(user.getMail());
        userToUpdate.setUsername(user.getUsername());

        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }
}