package todo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import todo.model.DateRange;
import todo.model.Todo;
import todo.model.form.TodoCreateForm;

import java.util.Optional;
import java.util.Set;

/**
 * Interface for Todo operations
 *
 * @author Murat Duzgun
 */
public interface ITodoService {

    Todo createTodo(TodoCreateForm form);

    Optional<Todo> deleteTodoById(long todoId);

    Page<Todo> getTodoPageByDateRange(DateRange dateRange, int pageNum, int pageSize);

    Page<Todo> getTodoPage(int pageNum, int pageSize);
}
