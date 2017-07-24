//package wieczorek.jakub.controllers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import UserDTO;
//import wieczorek.jakub.service.PersonService;
//
///**
// * Created by jakub on 26.06.17.
// */
//@RestController
//@CrossOrigin(origins = "http://localhost:1234")
//public class LoginController
//{
//    @Autowired
//    PersonService userService;
//
//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public ResponseEntity<PersonDTO> login(@RequestBody PersonDTO loginParams)
//    {
//        User user = userService.getUsers().get(loginParams.getUsername());
//
//        if(user != null)
//        {
//            if(user.getPassword().equals(loginParams.getPassword()))
//            {
//                return new ResponseEntity<User>(user, HttpStatus.OK);
//            }
//
//            return new ResponseEntity<User>((User)null, HttpStatus.CONFLICT);
//
//        } else
//
//        return new ResponseEntity<User>((User)null, HttpStatus.NO_CONTENT);
//    }
//}
