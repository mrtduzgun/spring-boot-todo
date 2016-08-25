package todo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import todo.model.Todo;
import todo.model.User;

import java.util.Date;

/**
 * Todo jpa abstract layer
 *
 * @author Murat Duzgun
 */
@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

    @Query("select t from Todo t where t.startDate <= :startDate and t.finishDate >= :finishDate and t.owner = :owner")
    Page<Todo> getTodoPageByDateRange(@Param("startDate") Date startDate, @Param("finishDate") Date finishDate, @Param("owner") User owner, Pageable pageable);

    @Query("select t from Todo t where t.owner = :owner")
    Page<Todo> getTodoPage(@Param("owner") User owner, Pageable pageable);
}
