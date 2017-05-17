package wieczorek.jakub.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jakub on 12.05.17.
 */

@Controller
@RequestMapping("/login")
public class LoginController
{
    @RequestMapping("")
    public String returnloginPage()
    {
        return "login";
    }
}
