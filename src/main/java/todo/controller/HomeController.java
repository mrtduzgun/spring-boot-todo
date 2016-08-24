package todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Range;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import todo.model.DateRange;
import todo.model.Todo;
import todo.model.form.TodoCreateForm;
import todo.service.ITodoService;

/**
 * Created by murat.duzgun on 16.8.2016.
 */

@Controller
@RequestMapping("/")
public class HomeController {

    private final static int TODO_PAGE_SIZE = 2;

    @Autowired
    private ITodoService todoService;

    @RequestMapping("")
    public String home(@RequestParam(value = "page", defaultValue = "1", required = false) int page,
                       @RequestParam(value = "range", required = false) DateRange dateRange,
                       Model model) {

        Page<Todo> todoPage;

        if (dateRange != null) {
            todoPage = todoService.getTodoPageByDateRange(dateRange, page, TODO_PAGE_SIZE);

        } else {
            todoPage = todoService.getTodoPage(page, TODO_PAGE_SIZE);
        }

        model.addAttribute("hasPrevPage", todoPage.hasPrevious());
        model.addAttribute("hasNextPage", todoPage.hasNext());
        model.addAttribute("currentPage", page);
        model.addAttribute("todos", todoPage.getContent());

        return "index";
    }

    @RequestMapping("/filterByDateRange")
    public String getTodosByDateRange(Model model) {
        model.addAttribute("form", new TodoCreateForm());
        return "todo/add";
    }
}
