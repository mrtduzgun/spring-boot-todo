package todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by murat.duzgun on 16.8.2016.
 */

@Controller
public class AuthController {

    @RequestMapping("/auth/login")
    public String login() {
       return "auth/login";
    }

    @RequestMapping("/auth/logout")
    public String logout() {
        return "index";
    }
}
