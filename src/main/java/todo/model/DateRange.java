package todo.model;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * Created by Murat on 24.08.2016.
 */
public class DateRange {

    private Date beginDate;

    private Date endDate;

    public DateRange(Date beginDate, Date endDate) {
        this.beginDate = beginDate;
        this.endDate = endDate;
    }

    public DateRange(String dateRangeStr) throws IllegalArgumentException {

        if (dateRangeStr.contains("_")) {

            String[] ranges = dateRangeStr.split("_");

            if (ranges.length != 2)
                throw new IllegalArgumentException("dateRangeStr must be likely: 39283129382_312321321!");

            this.beginDate = new Date(Long.parseLong(ranges[0]));
            this.endDate = new Date(Long.parseLong(ranges[1]));

        } else {
            DateRange resolvedDateRange = rangeTagResolver(DateRangeTag.valueOf(dateRangeStr.toUpperCase()));

            if (resolvedDateRange == null) {
                throw new IllegalArgumentException("dateRangeStr must be a predefined tag eq. 'today'!");
            }

            this.beginDate = resolvedDateRange.getBeginDate();
            this.endDate = resolvedDateRange.getEndDate();
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

    private DateRange rangeTagResolver(DateRangeTag dateRangeTag) {

        DateRange resolvedDateRange = null;

        if (DateRangeTag.TODAY == dateRangeTag) {
            resolvedDateRange = new DateRange(DateRange.localDateTimeToDate(LocalDateTime.now()), DateRange.localDateTimeToDate(LocalDateTime.now().plusDays(1)));

        } else if (DateRangeTag.TOMORROW == dateRangeTag) {
            resolvedDateRange = new DateRange(DateRange.localDateTimeToDate(LocalDateTime.now()), DateRange.localDateTimeToDate(LocalDateTime.now().with(LocalDateTime.MAX)));
        }

        return resolvedDateRange;
    }

    private static Date localDateTimeToDate(LocalDateTime startOfDay) {
        return Date.from(startOfDay.atZone(ZoneId.systemDefault()).toInstant());
    }

    private enum DateRangeTag {
        TODAY,
        TOMORROW,
        THIS_WEEK,
        NEXT_WEEK,
        THIS_MONTH,
        THIS_YEAR;
    }
}
