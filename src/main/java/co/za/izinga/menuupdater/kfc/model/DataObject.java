package co.za.izinga.menuupdater.kfc.model;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DataObject{
    @JsonProperty("MenuData") 
    public MenuData menuData;
    public boolean isLoggedIn;
    @JsonProperty("CarouselImages") 
    public String carouselImages;
    @JsonProperty("SEOData") 
    public String sEOData;
    @JsonProperty("ListOfStoreSpecificExcludedProducts") 
    public String listOfStoreSpecificExcludedProducts;
    public boolean isBreakfastAvailable;
    public String collectNowURL;
    public String userName;
    public String collectionPoint;
    public String customerTrackingNumber;
    public String orderMode;
    public CartInfo cartInfo;
}
