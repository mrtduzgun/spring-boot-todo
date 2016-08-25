package todo.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.*;

import java.util.Collection;

/**
 * Our user model inherited by Spring Security User model
 *
 * @author Murat Duzgun
 */
public class AppUser extends org.springframework.security.core.userdetails.User {

    private User user;

    public AppUser(User user) {
        super(user.getEmail(), user.getPasswd(), AuthorityUtils.createAuthorityList(Role.USER.toString()));
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
