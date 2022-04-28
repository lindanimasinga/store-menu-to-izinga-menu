package co.za.izinga.menuupdater.kfc.model;
import com.fasterxml.jackson.annotation.JsonProperty; 
public class Nutrition{
    @JsonProperty("Name") 
    public String name;
    @JsonProperty("Value") 
    public String value;
}
