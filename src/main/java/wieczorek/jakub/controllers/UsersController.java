package wieczorek.jakub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import wieczorek.jakub.Model.User;
import wieczorek.jakub.Model.UserService;

import java.util.ArrayList;
import java.util.List;

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

//    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
//    public ResponseEntity<List<User>>renderLoginData(@PathVariable("username") String username)
//    {
//        User user = new User();
//        user.setUsername(username);
//
//        userService.getUsers().add(user);
//
//        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
//    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Void>createUser(@RequestBody User user)
    {
        userService.getUsers().add(user);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<User>>fetchAllUsers()
    {
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }
}