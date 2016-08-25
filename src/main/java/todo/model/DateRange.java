package todo.model;

import java.util.Date;
import java.util.regex.Pattern;

/**
 * Custom class holds two date in custom format
 *
 * @author Murat Duzgun
 */
public class DateRange {

    private final static String RANGE_SEPERATOR = "_";

    private Date beginDate;

    private Date endDate;

    public DateRange(Date beginDate, Date endDate) {
        this.beginDate = beginDate;
        this.endDate = endDate;
    }

    public DateRange(String dateRangeStr) throws IllegalArgumentException {

        if (dateRangeStr.contains(RANGE_SEPERATOR)) {

            String[] ranges = dateRangeStr.split(Pattern.quote(RANGE_SEPERATOR));

            if (ranges.length != 2)
                throw new IllegalArgumentException("dateRangeStr must be likely: 39283129382|312321321!");

            this.beginDate = new Date(Long.parseLong(ranges[0]));
            this.endDate = new Date(Long.parseLong(ranges[1]));
        }
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
