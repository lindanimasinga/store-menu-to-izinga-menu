package co.za.izinga.menuupdater.kfc.model;
import com.fasterxml.jackson.annotation.JsonProperty; 
public class OrderReadyDate{
    @JsonProperty("NowLaterIndicator") 
    public int nowLaterIndicator;
    @JsonProperty("OrderReadyDate") 
    public Object orderReadyDate;
    @JsonProperty("OrderReadyTime") 
    public Object orderReadyTime;
    @JsonProperty("OrderReadyDateTime") 
    public Object orderReadyDateTime;
}
