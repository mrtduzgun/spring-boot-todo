package todo.service;

import todo.model.User;
import todo.model.form.UserSignUpForm;

import java.util.Optional;

/**
 * Created by Murat on 24.08.2016.
 */
public interface IUserService {

    User createUser(UserSignUpForm userSignUpForm);

    Optional<User> getUserByEmail(String email);

    Optional<User> getCurrentUser();
}
