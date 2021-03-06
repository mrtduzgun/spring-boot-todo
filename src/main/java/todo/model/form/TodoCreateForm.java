package todo.model.form;

import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;

/**
 * Form model todo create form
 *
 * @author Murat Duzgun
 */
public class TodoCreateForm {

    @NotEmpty
    private String content;

    @NotEmpty
    private String dateRangeUserFriendly;

    @NotEmpty
    private String dateRange;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDateRangeUserFriendly() {
        return dateRangeUserFriendly;
    }

    public void setDateRangeUserFriendly(String dateRangeUserFriendly) {
        this.dateRangeUserFriendly = dateRangeUserFriendly;
    }

    public String getDateRange() {
        return dateRange;
    }

    public void setDateRange(String dateRange) {
        this.dateRange = dateRange;
    }
}
