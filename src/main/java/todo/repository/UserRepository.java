package todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import todo.model.User;

/**
 * Created by murat.duzgun on 16.8.2016.
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
