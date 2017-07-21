package wieczorek.jakub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wieczorek.jakub.calendar.boundry.UserService;
import wieczorek.jakub.calendar.dto.UserDTO;
import wieczorek.jakub.calendar.entities.UserEntity;
import wieczorek.jakub.calendar.model.UserParam;

import java.util.Map;

/**
 * Created by jakub on 08.05.17.
 */
@CrossOrigin(origins = "http://localhost:1234") // enable CORS for all requestmapping
@RestController// == @Controller + @ResponseBody (@ResponseBody before each method which
// binds returned value to outgoing http response body)
@RequestMapping("/calendar/users")
public class UsersController
{
    @Autowired
    private UserService userService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<String> createUser(@RequestBody UserDTO aUser)
    {
        if(userService.findUser(new UserParam(aUser.getMail())) == null)
        {
            userService.addUser(aUser);

            return new ResponseEntity<>("resource created successfully", HttpStatus.CREATED);
        }

        return new ResponseEntity<>("conflict: user Exist", HttpStatus.CONFLICT);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<Map<String, UserDTO>> fetchAllUsers()
    {
        return new ResponseEntity<>(userService.selectUsers(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{mail:.+}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateUser(@PathVariable(value = "mail") String aMail, @RequestBody UserDTO aUser)
    {
        UserDTO userToUpdate = this.userService.findUser(new UserParam(aMail));

        if(userToUpdate == null)
        {
            return new ResponseEntity<>("User don't exist", HttpStatus.NO_CONTENT);
        }

        if(this.userService.findUser(new UserParam(aUser.getMail())) != null)
        { // mail is busy
            return new ResponseEntity<>("Conflict occurs", HttpStatus.CONFLICT);
        } else
        {
            this.userService.updateUser(new UserParam(aMail), aUser);

            return new ResponseEntity<>("resource updated successfully", HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/{mail:.+}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteUser(@PathVariable(value = "mail") String aMail)
    {
        UserDTO toUpdate = this.userService.findUser(new UserParam(aMail));

        if(toUpdate != null)
        {
            this.userService.deleteUser(toUpdate);

            return new ResponseEntity<>("resource deleted successfully", HttpStatus.OK);
        }

        return new ResponseEntity<>("cannot delete resource: User doesn't exist", HttpStatus.NO_CONTENT);
    }
}