package todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import todo.model.Todo;
import todo.model.form.TodoCreateForm;
import todo.repository.TodoRepository;

import javax.validation.Valid;

/**
 * Created by murat.duzgun on 16.8.2016.
 */

@Controller
@RequestMapping("todo")
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    @RequestMapping("/create")
    public String todoCreate(Model model) {
        model.addAttribute("form", new TodoCreateForm());
        return "todo/add";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String todoCreateSubmit(@Valid @ModelAttribute TodoCreateForm form, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {

            model.addAttribute("form", form);
            return "todo/create";
        }

        Todo todo = new Todo();
        todo.setContent(form.getContent());
        todo.setDate(form.getDate());
        todo.setOwner(null);
        todoRepository.save(todo);

        return "redirect:/todo";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String todoDelete(@RequestParam long todoId) {
        return "redirect:/todo";
    }
}
