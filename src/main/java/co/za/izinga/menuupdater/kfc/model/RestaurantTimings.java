package co.za.izinga.menuupdater.kfc.model;
import com.fasterxml.jackson.annotation.JsonProperty; 
public class RestaurantTimings{
    @JsonProperty("Sun") 
    public String sun;
    @JsonProperty("Mon") 
    public String mon;
    @JsonProperty("Tue") 
    public String tue;
    @JsonProperty("Wed") 
    public String wed;
    @JsonProperty("Thu") 
    public String thu;
    @JsonProperty("Fri") 
    public String fri;
    @JsonProperty("Sat") 
    public String sat;
}
