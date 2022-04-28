package co.za.izinga.menuupdater.kfc.model;
import com.fasterxml.jackson.annotation.JsonProperty; 
public class RestaurantOrderModeOpenCloseTime{
    @JsonProperty("RestaurantId") 
    public String restaurantId;
    @JsonProperty("OrderMode") 
    public String orderMode;
    @JsonProperty("DayOfWeek") 
    public String dayOfWeek;
    @JsonProperty("OpenTime") 
    public String openTime;
    @JsonProperty("CloseTime") 
    public String closeTime;
}
