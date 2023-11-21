package co.za.izinga.menuupdater.mcdonals.model; 
import com.fasterxml.jackson.annotation.JsonProperty; 
public class HrefVariants{
    @JsonProperty("DELIVERY") 
    public String dELIVERY;
    @JsonProperty("PICKUP") 
    public String pICKUP;
}
