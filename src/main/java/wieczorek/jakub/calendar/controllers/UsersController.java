package wieczorek.jakub.calendar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wieczorek.jakub.calendar.Model.UserService;
import wieczorek.jakub.calendar.Model.User;

import java.util.Map;

/**
 * Created by jakub on 08.05.17.
 */
@CrossOrigin(origins = "http://localhost:1234") // enable CORS for all requestmapping
@RestController// == @Controller + @ResponseBody (@ResponseBody before each method which
// binds returned value to outgoing http response body)
@RequestMapping("/users")
public class UsersController
{
    @Autowired
    private UserService userService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<String>createUser(@RequestBody User user)
    {
        if(userService.getUsers().get(user.getUsername()) == null)
        {
            userService.getUsers().put(user.getUsername(), user);

            return new ResponseEntity<>("resource updated successfully", HttpStatus.CREATED);
        }

        return new ResponseEntity<>("User Exist", HttpStatus.CONFLICT);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<Map<String, User>>fetchAllUsers()
    {
        return new ResponseEntity<>(this.userService.getUsers(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.PUT)
    public ResponseEntity<String>updateUser(@PathVariable(value = "username") String username, @RequestBody User user)
    {
        User userToUpdate = this.userService.getUsers().get(username);

        if(userToUpdate == null)
        {
            return new ResponseEntity<>("User don't exist", HttpStatus.NO_CONTENT);
        } else
        {
            if(this.userService.getUsers().get(user.getUsername()) != null && !user.getUsername().equals(username))
            { // new username is busy and not by current user
                return new ResponseEntity<>("Conflict occurs", HttpStatus.CONFLICT);
            } else
            {
                this.userService.getUsers().remove(username); // new key and value
                this.userService.getUsers().put(user.getUsername(), user);

                return new ResponseEntity<>("resource updated successfully", HttpStatus.OK);
            }
        }
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteUser(@PathVariable(value = "username") String username)
    {
        if(this.userService.getUsers().remove(username) != null)
        {
            return new ResponseEntity<>("resource deleted successfully", HttpStatus.OK);
        }

        return new ResponseEntity<>("User doesn't exist", HttpStatus.NO_CONTENT);
    }
}