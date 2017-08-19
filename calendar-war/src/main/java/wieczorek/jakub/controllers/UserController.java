package wieczorek.jakub.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wieczorek.jakub.calendar.boundry.PersonService;
import wieczorek.jakub.calendar.dto.EventDTO;
import wieczorek.jakub.calendar.dto.PersonDTO;
import wieczorek.jakub.calendar.params.PersonParam;

import javax.inject.Inject;
import java.util.Date;
import java.util.List;

/**
 * Created by jakub on 12.08.17.
 */
@RestController
@CrossOrigin(origins = "http://localhost:1234")
@RequestMapping(value = "/user")
public class UserController
{
    @Inject
    PersonService personService;

    @RequestMapping(value = "/{mail:.+}", method = RequestMethod.GET)
    public ResponseEntity<PersonDTO> getUser(@PathVariable("mail") String aMail)
    {
        PersonDTO personDTO = personService.findUser(new PersonParam(aMail));

        if(personDTO != null)
        {
            return new ResponseEntity<>(personDTO, HttpStatus.OK);
        }

        return new ResponseEntity<>((PersonDTO) null, HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/event/{mail:.+}", method = RequestMethod.GET)
    public ResponseEntity<List<EventDTO>> getEvents(@PathVariable("mail") String aMail)
    {
        PersonDTO personDTO = personService.findUser(new PersonParam(aMail));

        List<EventDTO> events = null;

        if(personDTO != null)
        {
            events = personService.selectEvents(personDTO);
        }

        if(events != null)
        {
            return new ResponseEntity<>(events, HttpStatus.OK);
        }

        return new ResponseEntity<>((List<EventDTO>) null, HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/event/{mail:.+}", method = RequestMethod.PUT)
    public ResponseEntity<Void> addEventToPerson(@PathVariable("mail") String aMail, @RequestBody EventDTO aEvent)
    {
        PersonDTO person = personService.findUser(new PersonParam(aMail));

        if(person != null)
        {
//            EventDTO aEvent = new EventDTO();
//            aEvent.setEventDate(new Date(12331));
//            aEvent.setDescription("TEST EVENT PUT");

            personService.addEventToPerson(person, aEvent);
            return new ResponseEntity<>((Void) null, HttpStatus.OK);
        }

        return new ResponseEntity<>((Void) null, HttpStatus.NO_CONTENT);
    }
}
