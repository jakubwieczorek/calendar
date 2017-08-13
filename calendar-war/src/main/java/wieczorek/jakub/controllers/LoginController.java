package wieczorek.jakub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wieczorek.jakub.calendar.boundry.PersonService;
import wieczorek.jakub.calendar.dto.PersonDTO;
import wieczorek.jakub.calendar.params.PersonParam;

/**
 * Created by jakub on 26.06.17.
 */
@RestController
@CrossOrigin(origins = "http://localhost:1234")
@RequestMapping(value = "/login")
public class LoginController
{
    @Autowired
    PersonService userService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<PersonDTO> login(@RequestBody PersonDTO loginParams)
    {
        PersonDTO user = userService.findUser(new PersonParam(loginParams.getMail()));

        if(user != null)
        {
            if(user.getPassword().equals(loginParams.getPassword()))
            {
                return new ResponseEntity<>(user, HttpStatus.OK);
            }

            return new ResponseEntity<>((PersonDTO) null, HttpStatus.CONFLICT);

        } else

        return new ResponseEntity<>((PersonDTO) null, HttpStatus.NO_CONTENT);
    }
}
