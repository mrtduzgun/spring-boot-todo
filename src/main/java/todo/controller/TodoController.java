package todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import todo.model.Todo;
import todo.repository.TodoRepository;

/**
 * Created by murat.duzgun on 16.8.2016.
 */

@Controller
@RequestMapping("todo")
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    @RequestMapping("/")
    public String todoIndex(Model model) {
        return "todo/index";
    }

    @RequestMapping("/create")
    public String todoCreate(Model model) {
        return "todo/add";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String todoCreateSubmit(@ModelAttribute Todo todo, Model model) {
        return "redirect:/todo";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String todoDelete(@RequestParam long todoId) {
        return "redirect:/todo";
    }

    @RequestMapping(value = "/edit/{todoId}")
    public String todoUpdate(@PathVariable long todoId) {
        return "redirect:/todo";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String todoUpdateSubmit(@RequestParam long todoId) {
        return "redirect:/todo";
    }
}
