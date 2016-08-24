package todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import todo.model.User;
import todo.model.form.UserLoginForm;
import todo.model.form.UserSignUpForm;
import todo.repository.UserRepository;
import todo.service.IUserService;

import javax.validation.Valid;

/**
 * Created by murat.duzgun on 16.8.2016.
 */

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/login")
    public String login(Model model) {

        model.addAttribute("form", new UserLoginForm());
       return "auth/login";
    }

    @RequestMapping("/logout")
    public String logout() {
        return "index";
    }

    @RequestMapping(value = "/sign-up", method = RequestMethod.GET)
    public String signUp(Model model) {
        model.addAttribute("form", new UserSignUpForm());
        return "auth/sign-up";
    }

    @RequestMapping(value = "/sign-up", method = RequestMethod.POST)
    public String signUpSubmit(@Valid @ModelAttribute UserSignUpForm form, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {

            model.addAttribute("form", form);
            return "auth/sign-up";
        }

        try {
            userService.createUser(form);

        } catch (DataIntegrityViolationException e) {
            bindingResult.reject("email.exists", "Email already exists");
        }

        return "redirect:/auth/login";
    }
}
