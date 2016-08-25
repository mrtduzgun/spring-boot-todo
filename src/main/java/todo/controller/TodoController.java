package todo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import todo.model.form.TodoCreateForm;
import todo.service.ITodoService;
import todo.service.IUserService;

import javax.validation.Valid;

/**
 * Controller for operations related todo
 *
 * @author Murat Duzgun
 */
@Controller
@RequestMapping("todo")
public class TodoController {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IUserService userService;

    @Autowired
    private ITodoService todoService;

    @RequestMapping("/create")
    public String todoCreate(Model model) {
        model.addAttribute("form", new TodoCreateForm());
        return "todo/add";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String todoCreateSubmit(@Valid @ModelAttribute("form") TodoCreateForm form, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("form", form);
            return "todo/add";
        }

        todoService.createTodo(form);

        return "redirect:/";
    }

    @RequestMapping(value = "/delete/{todoId}", method = RequestMethod.POST)
    @ResponseBody
    public boolean todoDelete(@PathVariable long todoId) {
        if (!todoService.deleteTodoById(todoId).isPresent()) {
            LOGGER.error(String.format("Todo (%d) could not be deleted!", todoId));

            return false;
        }
        return true;
    }
}
