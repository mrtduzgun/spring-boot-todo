package todo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import todo.model.DateRange;
import todo.model.Todo;
import todo.model.form.TodoCreateForm;
import todo.repository.TodoRepository;

import java.util.Optional;
import java.util.Set;

/**
 * Implements for Todo operations
 *
 * @author Murat Duzgun
 */
@Service
public class TodoService implements ITodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private IUserService userService;

    /**
     * create a todo from todo create form
     * */
    @Override
    public Todo createTodo(TodoCreateForm form) {

        Todo todo = new Todo();
        todo.setContent(form.getContent());

        DateRange dateRange = new DateRange(form.getDateRange());
        todo.setStartDate(dateRange.getBeginDate());
        todo.setFinishDate(dateRange.getEndDate());

        todo.setOwner(userService.getCurrentUser().get());

        todoRepository.save(todo);

        return todo;
    }

    /**
     * Delete todo by todo id
     * */
    @Override
    public Optional<Todo> deleteTodoById(long todoId) {
        Optional<Todo> foundTodo = Optional.of(todoRepository.findOne(todoId));
        todoRepository.delete(todoId);
        return foundTodo;
    }

    /**
     * Get todos from specific date range with pagination
     * */
    @Override
    public Page<Todo> getTodoPageByDateRange(DateRange dateRange, int pageNum, int pageSize) {

        PageRequest pageRequest = new PageRequest(pageNum-1, pageSize, Sort.Direction.DESC, "createdDate");
        return todoRepository.getTodoPageByDateRange(dateRange.getBeginDate(), dateRange.getEndDate(), userService.getCurrentUser().get(), pageRequest);
    }

    /**
     * Get todos with pagination
     * */
    @Override
    public Page<Todo> getTodoPage(int pageNum, int pageSize) {

        PageRequest pageRequest = new PageRequest(pageNum-1, pageSize, Sort.Direction.DESC, "createdDate");
        return todoRepository.getTodoPage(userService.getCurrentUser().get(), pageRequest);
    }
}
