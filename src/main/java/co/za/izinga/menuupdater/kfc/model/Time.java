package co.za.izinga.menuupdater.kfc.model;

public class Time {
    private String time;

    public String getTime() {
        return time.substring(0,2) + ":" + time.substring(2,4) + ":00";
    }

    public void setTime(String value) {
        this.time = value;
    }
}
