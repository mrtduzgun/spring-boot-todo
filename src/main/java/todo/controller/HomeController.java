package todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import todo.repository.UserRepository;

/**
 * Created by murat.duzgun on 16.8.2016.
 */

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("")
    public String home() {
        return "index";
    }
}
