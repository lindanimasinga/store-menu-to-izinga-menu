package co.za.izinga.menuupdater.kfc.model;
import com.fasterxml.jackson.annotation.JsonProperty; 
public class PrefferedAddress{
    @JsonProperty("IsRestaurantClose") 
    public int isRestaurantClose;
    @JsonProperty("Mode") 
    public int mode;
    @JsonProperty("AddressId") 
    public Object addressId;
    @JsonProperty("CustomerAddressType") 
    public int customerAddressType;
    @JsonProperty("AddressType") 
    public Object addressType;
    @JsonProperty("AddressLine1") 
    public Object addressLine1;
    @JsonProperty("AddressLine2") 
    public Object addressLine2;
    @JsonProperty("District") 
    public Object district;
    @JsonProperty("SubDistrict") 
    public Object subDistrict;
    @JsonProperty("City") 
    public String city;
    @JsonProperty("Country") 
    public Object country;
    @JsonProperty("ZipCode") 
    public String zipCode;
    @JsonProperty("AddressMode") 
    public Object addressMode;
    @JsonProperty("DeliveryComment") 
    public Object deliveryComment;
    @JsonProperty("Landmark") 
    public Object landmark;
    @JsonProperty("IsPrimary") 
    public boolean isPrimary;
    @JsonProperty("AddressTitle") 
    public Object addressTitle;
    @JsonProperty("AddressIdPOS") 
    public String addressIdPOS;
    @JsonProperty("QuadrantId") 
    public Object quadrantId;
    @JsonProperty("QuadrantName") 
    public Object quadrantName;
    @JsonProperty("AddressName") 
    public Object addressName;
    @JsonProperty("Latitude") 
    public String latitude;
    @JsonProperty("Longitude") 
    public String longitude;
    @JsonProperty("IsUpdateAddress") 
    public boolean isUpdateAddress;
    @JsonProperty("IsMigratedAddress") 
    public boolean isMigratedAddress;
    @JsonProperty("AptNo") 
    public Object aptNo;
    @JsonProperty("BuzzCode") 
    public Object buzzCode;
    public Object deliveryOption;
    @JsonProperty("Suburb") 
    public String suburb;
    @JsonProperty("Province") 
    public String province;
    @JsonProperty("ComplexName") 
    public Object complexName;
}
