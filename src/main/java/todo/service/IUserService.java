package todo.service;

import todo.model.User;
import todo.model.form.UserSignUpForm;

import java.util.Optional;

/**
 * Interface for User operations
 *
 * @author Murat Duzgun
 */
public interface IUserService {

    User createUser(UserSignUpForm userSignUpForm);

    Optional<User> getUserByEmail(String email);

    Optional<User> getCurrentUser();
}
