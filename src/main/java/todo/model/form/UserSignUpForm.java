package todo.model.form;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Form model for user sign up form
 *
 * @author Murat Duzgun
 */
public class UserSignUpForm {

    @NotEmpty
    private String email;

    @NotEmpty
    private String fullname;

    @NotEmpty
    private String passwd;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
