package wieczorek.jakub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wieczorek.jakub.calendar.boundry.PersonService;
import wieczorek.jakub.calendar.dto.PersonDTO;
import wieczorek.jakub.calendar.params.PersonParam;

import java.util.Map;

/**
 * Created by jakub on 08.05.17.
 */
@CrossOrigin(origins = "http://localhost:1234") // enable CORS for all requestmapping
@RestController// == @Controller + @ResponseBody (@ResponseBody before each method which
// binds returned value to outgoing http response body)
@RequestMapping("/admin")
public class AdminController
{
    private static final String OK = "resource created successfully";
    private static final String CONFLICT = "conflict";
    private static final String NO_CONTENT = "User don't exist";

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<String> createUser(@RequestBody PersonDTO aUser)
    {
        if(personService.findUser(new PersonParam(aUser.getMail())) == null)
        {
            personService.addUser(aUser);

            return new ResponseEntity<>(OK, HttpStatus.CREATED);
        }

        return new ResponseEntity<>(CONFLICT, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<Map<String, PersonDTO>> fetchAllUsers()
    {
        return new ResponseEntity<>(personService.selectUsers(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{mail:.+}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateUser(@PathVariable(value = "mail") String aMail, @RequestBody PersonDTO aUser)
    {
        PersonDTO userToUpdate = this.personService.findUser(new PersonParam(aMail));

        if(userToUpdate == null)
        {
            return new ResponseEntity<>(NO_CONTENT, HttpStatus.NO_CONTENT);
        }

        if(this.personService.findUser(new PersonParam(aUser.getMail())) != null && !aUser.getMail().equals(aMail)) // mail conflict
        { // mail is busy
            return new ResponseEntity<>(CONFLICT, HttpStatus.CONFLICT);
        } else
        {
            this.personService.updateUser(new PersonParam(aMail), aUser);

            return new ResponseEntity<>(OK, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/{mail:.+}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteUser(@PathVariable(value = "mail") String aMail)
    {
        PersonDTO toUpdate = this.personService.findUser(new PersonParam(aMail));

        if(toUpdate != null)
        {
            this.personService.deleteUser(toUpdate);

            return new ResponseEntity<>(OK, HttpStatus.OK);
        }

        return new ResponseEntity<>(NO_CONTENT, HttpStatus.NO_CONTENT);
    }
}