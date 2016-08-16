package todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import todo.repository.UserRepository;

/**
 * Created by murat.duzgun on 16.8.2016.
 */

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/")
    public String userHome() {
        return "user/index";
    }

    @RequestMapping("/")
    public String userRegister() {
        return "user/index";
    }
}
