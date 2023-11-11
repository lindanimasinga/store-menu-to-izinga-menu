package co.za.izinga.menuupdater.kfc.model;

public class Availability {
    private DayOfWeek dayOfWeek;
    private AvailableHours availableHours;
    private long price;

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek value) {
        this.dayOfWeek = value;
    }

    public AvailableHours getAvailableHours() {
        return availableHours;
    }

    public void setAvailableHours(AvailableHours value) {
        this.availableHours = value;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long value) {
        this.price = value;
    }
}