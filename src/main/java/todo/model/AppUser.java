package todo.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.*;

import java.util.Collection;

/**
 * Created by Murat on 24.08.2016.
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
