package todo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import todo.model.AppUser;
import todo.model.User;

import java.util.Optional;

/**
 * Created by Murat on 24.08.2016.
 */
@Service
public class AppUserDetailService implements UserDetailsService {

    private final IUserService userService;

    @Autowired
    public AppUserDetailService(IUserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) {

        Optional<User> user = userService.getUserByEmail(email);

        if (!user.isPresent())
            throw new UsernameNotFoundException("User not found with email is " + email);

        return new AppUser(user.get());
    }
}
