package todo.model.form;

import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;

/**
 * Created by Murat on 24.08.2016.
 */
public class TodoCreateForm {

    @NotEmpty
    private String content;

    @NotEmpty
    private Date date;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
