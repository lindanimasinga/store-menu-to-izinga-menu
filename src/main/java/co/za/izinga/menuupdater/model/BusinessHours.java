package co.za.izinga.menuupdater.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.DayOfWeek;
import java.util.Date;

public class BusinessHours {

    private DayOfWeek day;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private Date open;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private Date close;

    public BusinessHours() {

    }

    public BusinessHours(DayOfWeek day, Date open, Date close) {
        this.day = day;
        this.open = open;
        this.close = close;
    }

    public DayOfWeek getDay() {
        return day;
    }

    public void setDay(DayOfWeek day) {
        this.day = day;
    }

    public Date getOpen() {
        return open;
    }

    public void setOpen(Date open) {
        this.open = open;
    }

    public Date getClose() {
        return close;
    }

    public void setClose(Date close) {
        this.close = close;
    }
}
