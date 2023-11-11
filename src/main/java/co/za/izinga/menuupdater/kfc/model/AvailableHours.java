package co.za.izinga.menuupdater.kfc.model;

public class AvailableHours {
    private Time startTime;
    private Time endTime;

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time value) {
        this.startTime = value;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time value) {
        this.endTime = value;
    }
}