package wieczorek.jakub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wieczorek.jakub.calendar.boundry.AuthService;
import wieczorek.jakub.calendar.params.PersonParam;

/**
 * Created by jakub on 27.08.17.
 */
@RestController
@CrossOrigin(origins = "http://localhost:1234")
@RequestMapping("/validate")
public class AuthController
{
    @Autowired
    private AuthService authService;

    @RequestMapping("/mail/{mail:.+}")
    public ResponseEntity<Void> checkMail(@PathVariable("mail") String aMail)
    {
        if(authService.isEmailBusy(new PersonParam(aMail)))
        {
            return new ResponseEntity<>((Void) null, HttpStatus.OK);
        } else
        {
            return new ResponseEntity<>((Void) null, HttpStatus.CREATED);
        }
    }
}
