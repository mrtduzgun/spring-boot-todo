package todo.model.form;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Form model user login form
 *
 * @author Murat Duzgun
 */
public class UserLoginForm {

    @NotEmpty
    private String email;

    @NotEmpty
    private String passwd;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
