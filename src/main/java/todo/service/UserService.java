package todo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import todo.model.AppUser;
import todo.model.Role;
import todo.model.User;
import todo.model.form.UserSignUpForm;
import todo.repository.UserRepository;

import java.util.Optional;

/**
 * Implements for User operations
 *
 * @author Murat Duzgun
 */
@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * create user from sign up form
     * */
    @Override
    public User createUser(UserSignUpForm userSignUpForm) {

        User user = new User();
        user.setEmail(userSignUpForm.getEmail());
        user.setName(userSignUpForm.getFullname());
        user.setPasswd(new BCryptPasswordEncoder().encode(userSignUpForm.getPasswd()));
        userRepository.save(user);
        return user;
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findOneByEmail(email);
    }

    /**
     * get current authenticated user that has only role 'USER'
     * */
    @Override
    public Optional<User> getCurrentUser() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (!authentication.getAuthorities().contains(new SimpleGrantedAuthority(Role.USER.toString())))
                return Optional.empty();

        return Optional.of(((AppUser)authentication.getPrincipal()).getUser());
    }
}
