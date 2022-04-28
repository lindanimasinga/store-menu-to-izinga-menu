package co.za.izinga.menuupdater.kfc.model;
import com.fasterxml.jackson.annotation.JsonProperty; 
public class UrlObject{
    @JsonProperty("CartUrl") 
    public String cartUrl;
    @JsonProperty("MenuUrl") 
    public String menuUrl;
    @JsonProperty("CheckoutUrl") 
    public String checkoutUrl;
    @JsonProperty("LocationUrl") 
    public String locationUrl;
}
