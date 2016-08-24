package todo.model.form;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by Murat on 24.08.2016.
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
