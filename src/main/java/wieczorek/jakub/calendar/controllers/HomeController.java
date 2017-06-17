package wieczorek.jakub.calendar.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//import rmi.Login;


/**
 * Created by jakub on 07.05.17.
 */
@Controller
public class HomeController
{
    @RequestMapping({"/home", "/"})
    public String showHomePage()
    {
        return "home";
    }
}
