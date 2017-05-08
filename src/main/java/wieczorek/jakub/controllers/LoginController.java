package wieczorek.jakub.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jakub on 08.05.17.
 */
@RestController
@RequestMapping("/login")
public class LoginController
{
    @RequestMapping("")
    public String showLoginPage()
    {
        return "login";
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public ResponseEntity<List<String>>renderLoginData(@PathVariable("username") String username)
    {
        List<String> list = new ArrayList<>();
        list.add("Hello " + username);

        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
