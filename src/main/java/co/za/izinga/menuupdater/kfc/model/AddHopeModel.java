package co.za.izinga.menuupdater.kfc.model;
import com.fasterxml.jackson.annotation.JsonProperty; 
public class AddHopeModel{
    @JsonProperty("Id") 
    public int id;
    @JsonProperty("HopeDesc") 
    public String hopeDesc;
    @JsonProperty("HopeValue") 
    public double hopeValue;
    @JsonProperty("PosItemId") 
    public String posItemId;
}
