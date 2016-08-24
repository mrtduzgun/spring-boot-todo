import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import todo.model.User;
import todo.repository.UserRepository;

import java.util.Optional;

/**
 * Created by Murat on 25.08.2016.
 */

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findUserOneByEmail() {
        this.entityManager.persist(new User("mrtduzgun@gmail.com", "murat", "12345"));
        Optional<User> foundUser = this.userRepository.findOneByEmail("mrtduzgun@gmail.com");
    }
}
